package com.illdangag.stream.csv;

import com.illdangag.stream.data.People;
import com.illdangag.stream.data.Sex;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PeopleCSVReader {
    private PeopleCSVReader() {}

    public static List<People> getList() throws IOException {
        URL csvUrl = PeopleCSVReader.class.getClassLoader().getResource("people-100.csv");
        Reader reader = new FileReader(csvUrl.getPath());
        return getPeopleList(reader);
    }

    public static List<People> getLargeList() throws IOException {
        URL csvUrl = PeopleCSVReader.class.getClassLoader().getResource("people-100000.csv");
        Reader reader = new FileReader(csvUrl.getPath());
        return getPeopleList(reader);
    }

    private static List<People> getPeopleList(Reader reader) throws IOException {
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return StreamSupport.stream(records.spliterator(), false)
                .map(record -> {
                    try {
                        return People.builder()
                                .index(record.get("Index"))
                                .userId(record.get("User Id"))
                                .firstName(record.get("First Name"))
                                .lastName(record.get("Last Name"))
                                .sex(Sex.valueOf(record.get("Sex")))
                                .email(record.get("Email"))
                                .phone(record.get("Phone"))
                                .dateOfBirth(simpleDateFormat.parse(record.get("Date of birth")))
                                .jobTitle(record.get("Job Title"))
                                .build();
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }
}

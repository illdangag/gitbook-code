package com.illdangag.stream;

import com.illdangag.stream.csv.PeopleCSVReader;
import com.illdangag.stream.data.People;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilterStreamMain {
    public static void main(String[] args) throws Exception {
        List<People> peopleList = PeopleCSVReader.get();

        // 2000년 1월 1일
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        Date date = calendar.getTime();

        List<People> filteredList = peopleList.stream()
                .filter(people -> {
                    return people.getDateOfBirth().after(date);
                })
                .collect(Collectors.toList());

        filteredList.forEach(people -> {
            log.info("{}", people);
        });
    }
}

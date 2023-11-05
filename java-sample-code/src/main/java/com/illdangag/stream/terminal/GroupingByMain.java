package com.illdangag.stream.terminal;

import com.illdangag.stream.csv.PeopleCSVReader;
import com.illdangag.stream.data.People;
import com.illdangag.stream.data.Sex;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class GroupingByMain {
    public static void main(String[] args) throws Exception {
        List<People> peopleList = PeopleCSVReader.getList();

        Map<Sex, List<People>> peopleMap =  peopleList.stream()
                .collect(Collectors.groupingBy(
                        People::getSex
                ));

        List<People> maleList = peopleMap.get(Sex.Male);
        List<People> femaleList = peopleMap.get(Sex.Female);
        log.info("Male: {}, Female: {}", maleList.size(), femaleList.size());
    }
}

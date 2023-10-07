package com.illdangag.stream;

import com.illdangag.stream.csv.PeopleCSVReader;
import com.illdangag.stream.data.People;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class BirthFilterSkipLimitStreamMain {
    public static void main(String[] args) throws Exception {
        List<People> peopleList = PeopleCSVReader.get();

        // 2000년 1월 1일
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        Date date = calendar.getTime();

        List<People> filteredList = peopleList.stream()
                .limit(20) // stream에서 처음부터 20개만 다음 연산으로 전달한다
                .filter(people -> {
                    return people.getDateOfBirth().after(date);
                })
                .skip(5) // stream의 결과중에 처음부터 5개를 건너뛴다
                .collect(Collectors.toList());

        log.info("filtered list size: {}", filteredList.size());
        filteredList.forEach(people -> {
            log.info("{}", people);
        });
    }
}

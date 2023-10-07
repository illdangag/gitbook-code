package com.illdangag.stream.data;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Builder
@Getter
public class People {
    private String index;
    private String userId;
    private String firstName;
    private String lastName;
    private Sex sex;
    private String email;
    private String phone;
    private Date dateOfBirth;
    private String jobTitle;
}

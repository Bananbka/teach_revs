package org.example.teacherreviews.DTO;

import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class User {
    private final int id;
    private final String username;
    private String password;
    private String email;
    private Date registrationDate;

}

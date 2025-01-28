package org.example.teacherreviews.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Teacher {
    private final int id;
    private final String name;
    private final String universityId;
    private double rating;
    private String[] traits;
}

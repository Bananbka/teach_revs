package org.example.teacherreviews.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Teacher {
    private final int id;
    private final String name;
    private final String universityId;
    private double rating;
    private String[] traits;
}

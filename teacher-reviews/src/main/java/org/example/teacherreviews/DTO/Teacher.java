package org.example.teacherreviews.DTO;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

@NoArgsConstructor(force=true)
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Teacher {
    private int id;
    private String name;
    private University university;
    private double rating;
    private JsonNode traits;
}

package org.example.teacherreviews.DTO;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

@NoArgsConstructor(force=true)
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
    private JsonNode traits;
}

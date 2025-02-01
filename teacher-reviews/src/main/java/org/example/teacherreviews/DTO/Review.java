package org.example.teacherreviews.DTO;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(force=true)
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Review {
    private final int id;
    private final int reviewerId;
    private final int teacherId;
    private final String subject;
    private String content;
    private int rating;
    private final LocalDateTime cratedAt;
    private LocalDateTime editedAt;
    private Boolean isVerified;
}

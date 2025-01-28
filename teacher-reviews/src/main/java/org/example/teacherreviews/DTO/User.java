package org.example.teacherreviews.DTO;

import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {
    private final int id;
    private final String username;
    private final String password;
    private final String salt;
    private String email;
    private LocalDateTime registrationDate;
    private String pfpPath;
    private String bio;
}

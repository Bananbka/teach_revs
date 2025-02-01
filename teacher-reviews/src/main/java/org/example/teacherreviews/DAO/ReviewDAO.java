package org.example.teacherreviews.DAO;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name="review")
@Entity
public class ReviewDAO {

    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="reviewerId", nullable = false)
    private final int reviewerId;

    @Column(name="teacherId", nullable = false)
    private final int teacherId;

    @Column(name="subject", nullable = false)
    private final String subject;

    @Column(name="content")
    private String content;

    @Column(name="createdAt", nullable = false)
    private final LocalDateTime createdAt;

    @Column(name="editedAt")
    private LocalDateTime editedAt;

    @Column(name="isVerified")
    private Boolean isVerified;
}

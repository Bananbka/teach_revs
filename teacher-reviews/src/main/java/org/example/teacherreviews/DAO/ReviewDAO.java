package org.example.teacherreviews.DAO;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "reviews")
public class ReviewDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_reviews_user")
    )
    private UserDAO user;


    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_reviews_teacher")
    )
    private TeacherDAO teacher;

    @Column(name="subject", nullable = false)
    private String subject;

    @Column(name="content")
    private String content;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="edited_at")
    private LocalDateTime editedAt;

    @Column(name="is_verified")
    private Boolean isVerified;
}


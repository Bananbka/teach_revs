package org.example.teacherreviews.DAO;


import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.teacherreviews.converter.JsonNodeConverter;

@Getter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name="teacher")
@Entity
public class TeacherDAO {
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="name", nullable = false)
    private final String name;

    @Column(name="universityId")
    private final String universityId;

    @Column(name="rating")
    private double rating;

    @Column(name="traits", columnDefinition = "json")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode traits;


}

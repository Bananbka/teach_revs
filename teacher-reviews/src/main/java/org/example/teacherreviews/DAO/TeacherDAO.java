package org.example.teacherreviews.DAO;


import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.*;
import org.example.teacherreviews.converter.JsonNodeConverter;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name="teachers")
@Entity
public class TeacherDAO {
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "university", nullable = false,
            foreignKey = @ForeignKey(name = "fk_teachers_universities"))
    private UniversityDAO university;

    @Column(name="rating")
    private double rating;

    @Column(name="traits", columnDefinition = "json")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode traits;


}

package org.example.teacherreviews.DAO;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "universities")
public class UniversityDAO {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "parentId")
    private String parentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "shortName")
    private String shortName;

    @Column(name = "englishName")
    private String englishName;

    @Column(name = "crimeaEntrant")
    private String crimeaEntrant;

    @Column(name = "registrationYear")
    private String registrationYear;

    @Column(name = "type")
    private String type;

    @Column(name = "financingType")
    private String financingType;

    @Column(name = "governanceType")
    private String governanceType;

    @Column(name = "postIndex")
    private String postIndex;

    @Column(name = "katottgCode")
    private String katottgCode;

    @Column(name = "katottgName")
    private String katottgName;

    @Column(name = "region")
    private String region;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "site")
    private String site;

    @Column(name = "directorPost")
    private String directorPost;

    @Column(name = "directorPib")
    private String directorPIB;

    @Column(name = "closeDate")
    private String closeDate;

    @Column(name = "note")
    private String note;
}

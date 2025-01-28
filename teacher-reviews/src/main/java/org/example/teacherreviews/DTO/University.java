package org.example.teacherreviews.DTO;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Getter
@ToString
public class University {

    private String id;
    private String parentId;
    private String name;
    private String shortName;
    private String englishName;
    private String crimeaEntrant;
    private String registrationYear;
    private String type;
    private String financingType;
    private String governanceType;
    private String postIndex;
    private String katottgCode;
    private String katottgName;
    private String region;
    private String address;
    private String phone;
    private String email;
    private String site;
    private String directorPost;
    private String directorPIB;
    private String closeDate;
    private String note;



    public University(JsonNode json) {
        this.id = json.get("university_id").asText();
        this.parentId = json.get("university_parent_id").asText();
        this.name = json.get("university_name").asText();
        this.shortName = json.get("university_short_name").asText();
        this.englishName = json.get("university_name_en").asText();
        this.crimeaEntrant = json.get("is_from_crimea").asText();
        this.registrationYear = json.get("registration_year").asText();
        this.type = json.get("university_type_name").asText();
        this.financingType = json.get("university_financing_type_name").asText();
        this.governanceType = json.get("university_governance_type_name").asText();
        this.postIndex = json.get("post_index_u").asText();
        this.katottgCode = json.get("katottgcodeu").asText();
        this.katottgName = json.get("katottg_name_u").asText();
        this.region = json.get("region_name_u").asText();
        this.address = json.get("university_address_u").asText();
        this.phone = json.get("university_phone").asText();
        this.email = json.get("university_email").asText();
        this.site = json.get("university_site").asText();
        this.directorPost = json.get("university_director_post").asText();
        this.directorPIB = json.get("university_director_fio").asText();
        this.closeDate = json.get("close_date").asText();
        this.note = json.get("primitki").asText();
    }
}

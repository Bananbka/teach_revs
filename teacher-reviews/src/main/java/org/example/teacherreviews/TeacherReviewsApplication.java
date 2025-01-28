package org.example.teacherreviews;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.teacherreviews.DTO.University;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

@SpringBootApplication
public class TeacherReviewsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TeacherReviewsApplication.class, args);

		URL url = new URL("https://registry.edbo.gov.ua/api/universities/?exp=json");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(url);
        for (Iterator<JsonNode> it = json.elements(); it.hasNext(); ) {
			JsonNode i = it.next();
			University uni = new University(i);
			System.out.println(uni);

		}


		System.out.println("Hello, world! st: ");
	}
}

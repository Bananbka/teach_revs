package org.example.teacherreviews;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.teacherreviews.DTO.University;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Iterator;

@SpringBootApplication
public class TeacherReviewsApplication {

	public static void getUniversitiesFromAPI() throws IOException {
		URL url = new URL("https://registry.edbo.gov.ua/api/universities/?exp=json");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(url);
		for (Iterator<JsonNode> it = json.elements(); it.hasNext(); ) {
			JsonNode i = it.next();
			University uni = new University(i);
			System.out.println(uni);
		}
	}

	public static void generateSalt() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] salt = new byte[16];
		secureRandom.nextBytes(salt);
		String saltyString = Base64.getEncoder().encodeToString(salt); //result
	}

	private static String toSHA256(String toEncode) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(
				toEncode.getBytes(StandardCharsets.UTF_8));

		StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
		return hexString.toString();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(TeacherReviewsApplication.class, args);

		String coolPassword = "qwerty83";
		System.out.println("My password:\n" + coolPassword + "\nHashed:\n" + toSHA256(coolPassword));


		System.out.println("Finishing...");
	}
}	

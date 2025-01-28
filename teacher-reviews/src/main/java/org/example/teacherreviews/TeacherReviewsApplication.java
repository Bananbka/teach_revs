package org.example.teacherreviews;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.teacherreviews.DTO.University;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.script.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

	private static String resolvePythonScriptPath(String path){
		File file = new File(path);
		return file.getAbsolutePath();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TeacherReviewsApplication.class, args);

		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory: " + workingDir);

		ProcessBuilder processBuilder = new ProcessBuilder("python3", resolvePythonScriptPath(resolvePythonScriptPath("py-modules/frequency_sensitivity_detector.py")));
		processBuilder.redirectErrorStream(true);

		Process process = processBuilder.start();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("Python output: " + line); // Виводимо результат
			}
		}

		// Чекаємо завершення процесу
		int exitCode = process.waitFor();
		System.out.println("Python script exited with code: " + exitCode);


		System.out.println("Finishing...");
	}
}

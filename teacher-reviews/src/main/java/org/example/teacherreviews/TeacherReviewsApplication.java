package org.example.teacherreviews;

import org.example.teacherreviews.service.TeacherService;
import org.example.teacherreviews.timerTask.UpdateTeacherTraitsTask;
import org.example.teacherreviews.timerTask.UpdateUniversityJSONTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Timer;


@SpringBootApplication
public class TeacherReviewsApplication {

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

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(TeacherReviewsApplication.class, args);

		Timer time = new Timer();
		UpdateUniversityJSONTask task = new UpdateUniversityJSONTask();
		UpdateTeacherTraitsTask task2 = new UpdateTeacherTraitsTask(context.getBean(TeacherService.class));

		time.schedule(task, 0, 10000);
		time.schedule(task2, 0, 10000);

		System.out.println("🏁 Finishing...");
	}
}

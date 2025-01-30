package org.example.teacherreviews;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.teacherreviews.DTO.University;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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

		/* Here should be method that will give info about reviews from database */
		/* For first time here would be placeholder – databaseReview             */

		String databaseReview = "Der Lehrer ist fantastisch! Ich habe viel gelernt.\n" +
				"Sehr hilfreich, aber ich wünschte, die Erklärungen wären detaillierter.\n" +
				"Ich fand den Kurs interessant, aber in einigen Konzepten hatte ich Schwierigkeiten.\n" +
				"Gute Kommunikation und großartige Beispiele im Unterricht.\n" +
				"Leider konnte ich das meiste nicht verstehen.\n" +
				"Ich liebe diesen Kurs! Jetzt fühle ich mich viel sicherer.\n" +
				"Es war nicht die beste Erfahrung. Der Lehrer schien nicht vorbereitet zu sein.\n" +
				"Ich schätze die klare Struktur des Kurses.\n" +
				"Einige Teile waren wirklich langweilig, aber der Lehrer hat es trotzdem spannend gemacht.\n" +
				"Der Lehrer ist sehr kompetent, aber das Tempo war zu schnell.\n" +
				"Einer der besten Lehrer, die ich je hatte! Sehr empfehlenswert.\n" +
				"Ich habe nicht viel gelernt.\n" +
				"Der Lehrer macht den Unterricht sehr interessant und interaktiv!\n" +
				"Ich stimme einigen Methoden nicht zu, aber ich habe trotzdem etwas gelernt.\n" +
				"Die Erklärungen könnten klarer sein. Manchmal war ich verwirrt.\n" +
				"Sehr geduldig und hat alle meine Fragen beantwortet.\n" +
				"Ich wünschte, der Kurs hätte mehr praktische Aufgaben.\n" +
				"Sehr begeistert, aber der Inhalt war schwer zu folgen.\n" +
				"Das Feedback des Lehrers war sehr hilfreich und konstruktiv.\n" +
				"Für mich war das Tempo etwas zu schnell, aber insgesamt okay.\n" +
				"Der Lehrer hat alles sehr detailliert erklärt, und ich bin sehr dankbar dafür.\n" +
				"Ich fand den Kurs nicht herausfordernd genug, der Inhalt war zu einfach.\n" +
				"Der Lehrer ist großartig, aber die Kursorganisation war etwas chaotisch.\n" +
				"Ich mochte diese Unterrichtsmethode nicht, aber ich habe trotzdem etwas gelernt.\n" +
				"Der Kurs war klar, aber der Inhalt war etwas kompliziert.\n" +
				"Fantastisch! Jede Lektion war spannend!\n" +
				"Der Lehrer schien wenig Interesse zu haben, und die Atmosphäre war langweilig.\n" +
				"Ich mag die Lehrmethode des Lehrers, aber ich wünsche mir mehr Aktivitäten.\n" +
				"Sehr unterstützend und ermutigend, aber das Tempo war inkonsistent.\n" +
				"Ich konnte nicht ganz folgen, aber der Lehrer hat mir geholfen.\n" +
				"Der Lehrer hat schwierige Konzepte wirklich gut erklärt.\n" +
				"Ich mag das Kursformat nicht, aber der Lehrer ist in Ordnung.\n" +
				"Der Lehrer stellt sicher, dass jeder versteht, bevor er weitermacht.\n" +
				"Der Lehrer könnte mehr Beispiele im Unterricht geben.\n" +
				"Ich war sehr engagiert während des gesamten Kurses.\n" +
				"Technische Probleme haben den Kursfluss gestört.\n" +
				"Die Begeisterung des Lehrers hat den Unterricht sehr interessant gemacht!\n" +
				"Ich war mit dem Feedback des Lehrers nicht zufrieden, ich hätte mehr Details erwartet.\n" +
				"Die Lehrmethoden des Lehrers sind innovativ und halten mich interessiert.\n" +
				"Der Kurs war für mich etwas zu schwierig.\n" +
				"Der Lehrer ist immer bereit zu helfen und unterstützt uns.\n" +
				"Ich mochte den Unterrichtsstil nicht, aber ich habe den Inhalt verstanden.\n" +
				"Der Lehrer sollte während des Unterrichts mehr organisiert sein.\n" +
				"Der Lehrer hat den Inhalt interessant gemacht, obwohl er herausfordernd war.\n" +
				"Der Kurs war schwer zu folgen, aber ich habe viel gelernt.\n" +
				"Der Kurs könnte interaktiver sein, aber der Lehrer war trotzdem gut.\n" +
				"Ich fühlte mich etwas überfordert, aber der Lehrer war sehr unterstützend.\n" +
				"Der Lehrer erklärt sehr gut, aber ich hatte trotzdem Schwierigkeiten, ihm zu folgen.\n" +
				"Ich mag die Erklärungen des Lehrers, aber die Aufgaben sind zu schwierig.\n" +
				"Der Kurs war spannend, aber ich hätte gerne mehr praktische Beispiele gehabt.\n" +
				"Ein hervorragender Lehrer, der jedes Thema leicht verständlich gemacht hat.\n" +
				"Das Tempo war für mich gerade richtig, aber ich fand den Inhalt nicht ganz zutreffend.\n" +
				"Der Lehrer hat mich mit seiner Begeisterung für das Fach inspiriert.\n" +
				"Der Lehrer war zu streng, und die Atmosphäre im Kurs war unangenehm.\n" +
				"Ich habe in diesem Kurs nicht viel gelernt.\n" +
				"Das Feedback des Lehrers war sehr hilfreich und hat mir geholfen, mich zu verbessern.\n" +
				"Der Kurs war spannend, aber ich hätte gerne mehr Gruppendiskussionen gehabt.\n" +
				"Der Lehrer war immer freundlich und geduldig, aber das Tempo war zu langsam.\n" +
				"Ich mag die Begeisterung des Lehrers, aber der Kursinhalt hat mich nicht wirklich interessiert.\n" +
				"Der Lehrer hat wenig interagiert, und der Kurs war langweilig.\n" +
				"Der Kurs war sehr interaktiv, aber der Inhalt war schwer zu verstehen.\n" +
				"Ich denke, der Lehrer könnte flexibler mit den Abgabeterminen umgehen.\n" +
				"Der Lehrer hat mir das Gefühl gegeben, dass Lernen nicht stressig sein muss, was ich sehr schätze.\n" +
				"Der Kurs fühlt sich zu theoretisch an, es fehlt der praktische Bezug.\n" +
				"Der Lehrer stellt sicher, dass jeder versteht, bevor er weitermacht.\n" +
				"Der Kurs ist gut organisiert, aber der Lehrer könnte noch strukturierter sein.\n" +
				"Der Inhalt war zu einfach für mich, ich hätte mir mehr Herausforderungen gewünscht.\n" +
				"Der Lehrer hat viel Wissen und wertvolle Einblicke gegeben.\n" +
				"Ich war im Kurs etwas verwirrt, aber der Lehrer war sehr zugänglich.\n" +
				"Der Kurs war spannend, aber ich hätte gerne mehr konkrete Beispiele gesehen.\n" +
				"Der Lehrer ist sehr hilfsbereit, aber ich fand das Fach etwas langweilig.\n" +
				"Manchmal schien der Lehrer nicht so organisiert zu sein, aber ich habe viel gelernt.\n" +
				"Der Kurs war sehr spannend, aber in einigen Teilen hatte ich Schwierigkeiten.\n" +
				"Ich wurde durch die Begeisterung des Lehrers inspiriert!\n" +
				"Der Lehrer hat gut erklärt, aber der Kurs war manchmal zu schnell.\n" +
				"Ich mag den Unterrichtsstil des Lehrers, aber der Kursinhalt hat mich nicht wirklich gefesselt.\n" +
				"Der Lehrer hat sehr gut erklärt, aber der Kurs war manchmal schwer zu folgen.\n" +
				"Das Feedback des Lehrers war sehr konstruktiv und hat mir geholfen, mich zu verbessern.\n" +
				"Ich mag die Begeisterung des Lehrers, aber der Kurs hätte mehr Struktur vertragen können.\n" +
				"Der Lehrer konzentrierte sich zu sehr auf die Theorie und weniger auf die praktische Anwendung.\n" +
				"Ich finde den Kurs sehr hilfreich und mag die Art, wie der Lehrer unterrichtet.\n" +
				"Das Tempo war für mich genau richtig, aber der Inhalt entsprach nicht ganz meinen Zielen.\n" +
				"Der Lehrer hat den Unterricht spannend gemacht, aber ich hätte mir mehr Herausforderungen gewünscht.\n" +
				"Der Lehrer ist großartig, aber ich konnte mich nicht mit dem Inhalt identifizieren.\n" +
				"Der Kurs war gut organisiert, aber der Lehrer könnte noch etwas fesselnder sein.\n" +
				"Ich fand den Unterrichtsstil des Lehrers ein wenig repetitiv.\n" +
				"Der Lehrer hat viele gute Ressourcen angeboten, aber der Kursfortschritt war zu schnell.\n" +
				"Ich mochte diesen Kurs, aber ich fand einige Themen nicht gut erklärt.\n" +
				"Der Lehrer hat den Inhalt lebendig und interessant gemacht.\n" +
				"Der Kurs war schwer, aber der Lehrer war geduldig und hilfsbereit.\n" +
				"Ich schätze die Hilfe des Lehrers, aber ich konnte nicht mit dem Tempo mithalten.\n" +
				"Der Lehrer sollte auf Fragen schneller antworten.\n" +
				"Der Kurs war leicht zu verstehen, aber ich hätte mir mehr Herausforderungen gewünscht.\n" +
				"Die Beispiele des Lehrers waren sehr hilfreich, um komplexe Konzepte zu verstehen.\n" +
				"Der Lehrer war sehr begeistert, aber der Kursinhalt hat mich nicht wirklich interessiert.\n" +
				"Der Kurs war schwierig, aber der Lehrer hat mir sehr geholfen.\n" +
				"Der Lehrer hat den Inhalt spannend gemacht, aber ich hätte mir mehr Vielfalt gewünscht.\n" +
				"Der Kurs war interessant, aber ich hätte mehr Unterstützung bei einigen Themen gebraucht.\n" +
				"Der Lehrer hat viel Wissen, aber der Kurs war etwas eintönig.\n" +
				"Insgesamt mochte ich den Kurs, aber ich hätte mir eine strukturiertere Unterrichtsmethode gewünscht.";


		new File("../data/request.txt");
		FileWriter writer = new FileWriter("../data/request.txt");
		writer.write(databaseReview);
		writer.close();


		ProcessBuilder processBuilder = new ProcessBuilder("python3", resolvePythonScriptPath(resolvePythonScriptPath("../py-modules/frequency_sensitivity_detector.py")));
		processBuilder.redirectErrorStream(true);

		Process process = processBuilder.start();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("🐍 Python output: " + line);
			}
		}
		int exitCode = process.waitFor();
		System.out.println("🐍 Python script exited with code: " + exitCode);

		if (exitCode == 0) {


			ObjectMapper mapper = new ObjectMapper();
			JsonNode json = mapper.readTree(new FileReader("../data/result.json"));
            for (Iterator<JsonNode> it = json.elements(); it.hasNext(); ) {
                var a = it.next();
				System.out.println(a.get("name").asText() + "\t" +
						a.get("count").asText() + "\t" +
						a.get("polarity").asText() + "\n");

            }

		}


		System.out.println("Finishing...");
	}
}

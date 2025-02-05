package org.example.teacherreviews.timerTask;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.teacherreviews.DTO.Review;
import org.example.teacherreviews.DTO.Teacher;
import org.example.teacherreviews.service.ReviewService;
import org.example.teacherreviews.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.TimerTask;

@Component
public class UpdateTeacherTraitsTask extends TimerTask {

    private final TeacherService teacherService;
    private final ReviewService reviewService;

    @Autowired
    public UpdateTeacherTraitsTask(TeacherService teacherService, ReviewService reviewService) {
        this.teacherService = teacherService;
        this.reviewService = reviewService;
    }

    @Override
    public void run() {
        List<Teacher> teachers = teacherService.findAll();

        for (Teacher teacher : teachers) {
            int id = teacher.getId();
            List<Review> reviews = reviewService.findByTeacherId(id);
            String rawReviews = reviews.stream()
                    .map(Review::getContent)
                    .reduce((review1, review2) -> review1 + "." + review2)
                    .get();
            try {
                JsonNode newTraits = runPythonModule(rawReviews);
                teacherService.updateTraitsById(newTraits, id);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String resolvePythonScriptPath(String path){
        File file = new File(path);
        return file.getAbsolutePath();
    }

    private JsonNode runPythonModule(String rawReviews) throws IOException, InterruptedException {

        new File("../data/request.txt");
        FileWriter writer = new FileWriter("../data/request.txt");
        writer.write(rawReviews);
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
        System.out.println("🐍 Python script exited with code: " + process.waitFor());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(new FileReader("../data/result.json"));
    }

}

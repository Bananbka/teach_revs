package org.example.teacherreviews.timerTask;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.teacherreviews.DTO.University;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.TimerTask;

@Component
public class UpdateUniversityJSONTask extends TimerTask {

    @Override
    public void run() {
        try {
            getUniversitiesFromAPI();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getUniversitiesFromAPI() throws IOException {
        URL url = new URL("https://registry.edbo.gov.ua/api/universities/?exp=json");

        /* Parse id like an int, but not a String */

        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(url);
        for (Iterator<JsonNode> it = json.elements(); it.hasNext(); ) {
            JsonNode i = it.next();
            University uni = new University(i);
            System.out.println(uni);
        }
    }
}

package org.example.teacherreviews.timerTask;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.teacherreviews.DAO.UniversityDAO;
import org.example.teacherreviews.DTO.University;
import org.example.teacherreviews.mapper.UniversityMapper;
import org.example.teacherreviews.service.UniversityService;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;

@Component
public class UpdateUniversityJSONTask extends TimerTask {

    private final UniversityService universityService;

    public UpdateUniversityJSONTask(UniversityService universityService) {
        this.universityService = universityService;
    }

    @Override
    public void run() {
        try {
            getUniversitiesFromAPI();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<Integer, JsonNode> universitySearchMap(JsonNode uniArray) {
        Map<Integer, JsonNode> map = new HashMap<>();
        for (JsonNode uni : uniArray) {
            map.put(uni.get("university_id").asInt(), uni);
        }
        return map;
    }

    private void getUniversitiesFromAPI() throws IOException {
        URL url = new URL("https://registry.edbo.gov.ua/api/universities/?exp=json");

        String dateAppendix = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String fileName = "uni" + dateAppendix + ".json";
        String filePath = "../data/universities-data/";
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(filePath + fileName);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        String dateAppendixOld = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String fileNameOld = "uni" + dateAppendixOld + ".json";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode newData = mapper.readTree(new File(filePath+fileName));
        JsonNode oldData = mapper.readTree(new File(filePath+fileNameOld));
        Map<Integer, JsonNode> oldDataMap = universitySearchMap(oldData);

        if (!newData.equals(oldData)) {
            for (int i = 0; i < newData.size(); i++) {
                JsonNode newUni = newData.get(i);
                JsonNode newUniId = newUni.get("university_id");
                JsonNode oldUni = (newUniId != null) ? oldDataMap.get(newUniId.asInt()) : null;
                if (!newUni.equals(oldUni)) {
                    University uni = new University(newUni);
                    UniversityDAO uniDAO = UniversityMapper.INSTANCE.toDAO(uni);
                    universityService.save(uniDAO);
                }
            }
        }
    }
}

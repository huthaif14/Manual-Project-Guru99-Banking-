package Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReader {
    public static Map<String, String> readJsonFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("src/test/resources/TestDataFile/"+fileName), Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

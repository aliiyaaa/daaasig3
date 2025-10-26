package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

// Helper class for reading and writing JSON files
public class JsonProcessor {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    // Read input data from JSON file
    public static InputData readInputData(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), InputData.class);
    }
    
    // Write output data to JSON file
    public static void writeOutputData(OutputData outputData, String filePath) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), outputData);
    }
}

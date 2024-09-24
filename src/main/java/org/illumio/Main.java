package org.illumio;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        
        String lookUpFilePath = "/input/lookup_table.csv";
        String logsFilePath = "/input/logs.txt";

        
        File outputDir = new File("src/main/resources/output");
        if (!outputDir.exists()) {
            boolean dirCreated = outputDir.mkdirs();
            if (!dirCreated) {
                System.err.println("Failed to create output directory.");
                return;
            }
        }
 
        InputStream lookUpFileStream = Main.class.getResourceAsStream(lookUpFilePath);
        InputStream logsFileStream = Main.class.getResourceAsStream(logsFilePath);

        if (lookUpFileStream == null || logsFileStream == null) {
            System.err.println("Error: One or both resource files not found.");
            return;
        }

        Map<String, List<String>> lookUpMap = LookUpTable.parseLookupTable(lookUpFileStream);

        Map<String, Integer> tagCount = FlowLogProcessor.countTags(logsFileStream, lookUpMap);

        CSVWriter.writeCSV(tagCount, "src/main/resources/output/tag_counts.csv", List.of("Tag", "Count"));
 
        logsFileStream = Main.class.getResourceAsStream(logsFilePath);
 
        Map<String, Integer> portProtocolCount = FlowLogProcessor.countPortProtocolCombinations(logsFileStream);
 
        CSVWriter.writeCSV(portProtocolCount, "src/main/resources/output/port_protocol_combination_counts.csv", List.of("Port", "Protocol", "Count"));
    }
}

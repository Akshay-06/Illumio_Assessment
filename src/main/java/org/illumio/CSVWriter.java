package org.illumio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVWriter {

    public static void writeCSV(Map<String, Integer> dataMap, String outputFile, List<String> headers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
             
            writer.write(String.join(",", headers));
            writer.newLine();

             
            for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.illumio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LookUpTable {

    public static Map<String, List<String>> parseLookupTable(InputStream inputStream) {
        Map<String, List<String>> lookUpMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String port = values[0];
                String protocol = values[1].toLowerCase(); 
                String tag = values[2];

                String key = port + "," + protocol;
                lookUpMap.computeIfAbsent(key, k -> new ArrayList<>()).add(tag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lookUpMap;
    }
}

package org.illumio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowLogProcessor {

    public static Map<String, Integer> countTags(InputStream logsStream, Map<String, List<String>> lookUpMap) {
        Map<String, Integer> tagCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(logsStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\s+");
                String dstPort = fields[6];
                String protocolNumber = fields[7];

                String protocol = ProtocolConverter.convertProtocol(protocolNumber).toLowerCase();

                String key = dstPort + "," + protocol;
                List<String> tags = lookUpMap.getOrDefault(key, List.of("Untagged"));
                
                for (String tag : tags) {
                    tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tagCount;
    }

    public static Map<String, Integer> countPortProtocolCombinations(InputStream logsStream) {
        Map<String, Integer> portProtocolCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(logsStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\s+");
                String dstPort = fields[6];
                String protocolNumber = fields[7];

                String protocol = ProtocolConverter.convertProtocol(protocolNumber).toLowerCase();

                String key = dstPort + "," + protocol;
                portProtocolCount.put(key, portProtocolCount.getOrDefault(key, 0) + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return portProtocolCount;
    }
}

package org.illumio;

import java.util.HashMap;
import java.util.Map;

public class Protocol {

    private static final Map<String, String> protocolMap = new HashMap<>();

    static {
        protocolMap.put("1", "icmp");
        protocolMap.put("4", "ipv4");
        protocolMap.put("6", "tcp");
        protocolMap.put("17", "udp");
        protocolMap.put("35","idpr");
    }

    public static String convertProtocol(String protocolNumber) {
        return protocolMap.getOrDefault(protocolNumber, "unknown");
    }
}

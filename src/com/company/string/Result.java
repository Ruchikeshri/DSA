package com.company.string;

import java.util.*;

class Result {

    public static List<String> processLogs(List<String> logs, int threshold) {
        Map<String, Integer> transCount = new HashMap<>();

        for (String log : logs) {
            // Split log by space
            String[] parts = log.split(" ");
            String sender = parts[0];
            String receiver = parts[1];

            // Count sender
            transCount.put(sender, transCount.getOrDefault(sender, 0) + 1);

            // Count receiver (only if different from sender)
            if (!sender.equals(receiver)) {
                transCount.put(receiver, transCount.getOrDefault(receiver, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : transCount.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        // Sort result numerically
        Collections.sort(result, Comparator.comparingInt(Integer::parseInt));
        return result;
    }

    public static void main(String[] args) {
        // Sample input
        List<String> logs = Arrays.asList(
                "88 99 200",
                "88 88 500",
                "99 88 300",
                "99 70 250"
        );
        int threshold = 2;

        // Get result
        List<String> result = Result.processLogs(logs, threshold);

        // Print result
        for (String userId : result) {
            System.out.println(userId);
        }
    }
}
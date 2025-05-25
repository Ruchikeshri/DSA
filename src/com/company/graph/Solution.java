package com.company.graph;

import java.util.*;

public class Solution {

    public static int countGroups(List<String> related) {
        int n = related.size();
        boolean[] visited = new boolean[n];
        int groups = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(related, visited, i);
                groups++;
            }
        }
        return groups;
    }

    private static void dfs(List<String> related, boolean[] visited, int person) {
        visited[person] = true;
        String connections = related.get(person);

        for (int j = 0; j < connections.length(); j++) {
            if (connections.charAt(j) == '1' && !visited[j]) {
                dfs(related, visited, j);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        List<String> related = Arrays.asList(
            "110",
            "110",
            "001"
        );

        System.out.println(countGroups(related)); // Output: 2
    }
}

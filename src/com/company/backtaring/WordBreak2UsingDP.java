package com.company.backtaring;

import java.util.*;

public class WordBreak2UsingDP {
    private Map<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        // Step 1: Word Break I (DP array to check if s can be segmented)
        boolean[] dp = new boolean[s.length() + 1]; // dp[i] = true if s[0...i) can be segmented
        dp[0] = true; // base case: empty string is "segmentable"

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        if (!dp[s.length()]) return new ArrayList<>(); // can't split fully

        return dfs(s, 0, wordSet, dp); // Step 2: DFS + memo to build all valid sentences
    }

    private List<String> dfs(String s, int start, Set<String> wordSet, boolean[] dp) {
        if (memo.containsKey(start)) return memo.get(start);

        List<String> results = new ArrayList<>();

        if (start == s.length()) {
            results.add(""); // base case: empty suffix (end of string)
            return results;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word) && dp[end]) {
                List<String> suffixWays = dfs(s, end, wordSet, dp);
                for (String suffix : suffixWays) {
                    String space = suffix.isEmpty() ? "" : " ";
                    results.add(word + space + suffix);
                }
            }
        }

        memo.put(start, results);
        return results;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> sentences =new WordBreak2UsingDP().wordBreak(s,  wordDict);
        sentences.forEach(System.out::println);
    }
}

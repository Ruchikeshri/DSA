package com.company.backtaring;

import java.util.*;

public class WordBreakIIUsingDPArray {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // For each index, store all valid split points (previous indices)
        List<List<Integer>> splitPoints = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            splitPoints.add(new ArrayList<>());
        }

        // Build dp and splitPoints simultaneously
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    splitPoints.get(i).add(j);
                }
            }
        }

        List<String> results = new ArrayList<>();
        if (dp[n]) {
            backtrack(s, splitPoints, n, new LinkedList<>(), results);
        }

        return results;
    }

    private static void backtrack(String s, List<List<Integer>> splitPoints, int end, LinkedList<String> path, List<String> results) {
        if (end == 0) {
            results.add(String.join(" ", path));
            return;
        }

        for (Integer start : splitPoints.get(end)) {
            String word = s.substring(start, end);
            path.addFirst(word);
            backtrack(s, splitPoints, start, path, results);
            path.removeFirst();
        }
    }
    public static ArrayList<String> wordBreak2(String s, List<String> dictionary) {
            // Write your code here.

            return dfs(s,new HashSet<>(dictionary),new HashMap<>());
        }

        private static ArrayList<String> dfs(String s, HashSet<String> wordSet,
                                             HashMap<String,ArrayList<String>> memo){
            if(memo.containsKey(s)) return memo.get(s);
            ArrayList<String> res = new ArrayList<>();

            if(s.isEmpty()) {
                res.add("");
                return res;
            }

            for(String word : wordSet){
                if(s.startsWith(word)){
                    List<String> suffixWays = dfs(
                            s.substring(word.length()),
                            wordSet,memo);

                    for(String suffix : suffixWays){
                        res.add(word + (suffix.isEmpty() ? "": " ")
                                +suffix);
                    }
                }
            }

            memo.put(s,res);
            return res;
        }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> sentences = wordBreak(s,  wordDict);
        sentences.forEach(System.out::println);
    }
}

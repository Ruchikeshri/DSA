package com.company.DynamicProgramming;

import java.util.*;

public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        List<String>[] dp = new ArrayList[n + 1]; // DP array of lists

        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        
        dp[0].add(""); // Base case

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i); // Extract substring s[j...i-1]

                if (wordSet.contains(word) && !dp[j].isEmpty()) {
                    for (String sentence : dp[j]) {
                        dp[i].add(sentence.isEmpty() ? word : sentence + " " + word);
                    }
                }
            }
        }

        return dp[n];
    }

        public static List<String> wordBreak2(String s, List<String> wordDict) {
            Set<String> wordSet =  new HashSet<>(wordDict);

            int n = s.length();

            List<Integer> dp[] = new ArrayList[n+1];

            for(int i=0;i<=s.length();i++){
                dp[i] = new ArrayList<>();
            }

            dp[0].add(0);
            for(int i=1;i<=s.length();i++){

                for(int j=0;j<i;j++){
                    if(( !dp[j].isEmpty()) &&
                            wordSet.contains(s.substring(j,i))){
                        dp[i].add(j);
                    }
                }

            }

            List<String> result = new ArrayList<>();
            backtrack(s,n,dp,new ArrayList<>(),result);
            return result;
        }

        public static void backtrack(String s, int index, List<Integer>[] dp, List<String> path, List<String> result){


            if(index ==0){
                Collections.reverse(path);
                result.add(String.join(" ",path));
                Collections.reverse(path);
                return;
            }

            for(int prevI : dp[index]){
                path.add(s.substring(prevI,index));
                backtrack(s,prevI,dp,path,result);
                path.remove(path.size()-1);
            }

        }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result = wordBreak2(s, wordDict);
        System.out.println(result);
    }
}

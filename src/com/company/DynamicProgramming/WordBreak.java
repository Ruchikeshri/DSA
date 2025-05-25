package com.company.DynamicProgramming;

import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1]; // DP array of size `n + 1`
        dp[0] = true; // Base case

        Set<String> set = new HashSet<>(wordDict); // Convert wordDict to a HashSet for O(1) lookup

        // Iterate over the string
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n]; // Check if the entire string `s` can be segmented
    }


        public int minPathSum(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;

            int dp[][] = new int[m][n];
            dp[0][0] =1;
            int minSum = Integer.MAX_VALUE;

            for(int i=1;i<m;i++){
                dp[i][0] = 1;
            }

            for(int j=1;j<n;j++){
                dp[0][j] =1;
            }

            for(int i=1;i<m;i++){
                int currentSum=Integer.MAX_VALUE;
                for(int j=1;j<n;j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    currentSum = Math.min(currentSum,dp[i][j]);
                }
                minSum = Math.min(minSum,currentSum);
            }
            return minSum;
        }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println(new WordBreak().minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        }));
    }
}

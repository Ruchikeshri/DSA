package com.company.DynamicProgramming;

class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, word1.length(), word2.length());
    }

    private int helper(String word1, String word2, int i, int j) {
        // Base case: If word1 is empty, insert all remaining chars from word2
        if (i == 0) return j;

        // Base case: If word2 is empty, delete all remaining chars from word1
        if (j == 0) return i;

        // If last characters are same, move both pointers
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return helper(word1, word2, i - 1, j - 1);
        } else {
            // Try all three operations
            int insert = helper(word1, word2, i, j - 1);
            int delete = helper(word1, word2, i - 1, j);
            int replace = helper(word1, word2, i - 1, j - 1);
            return 1 + Math.min(insert, Math.min(delete, replace));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse","ros"));
    }
}

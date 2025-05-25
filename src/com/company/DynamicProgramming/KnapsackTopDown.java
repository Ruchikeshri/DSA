package com.company.DynamicProgramming;

import java.util.Arrays;

public class KnapsackTopDown {
    
    // Helper function to initialize DP table and call recursive function
    public static int knapsackHelper(int[] values, int[] weights, int W) {
        int n = values.length;
        int[][] dp = new int[n+1][W+1];

        // Fill DP table with -1 (indicating uncomputed states)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursion with memoization
        return knapsack(n, W, values, weights, dp);
    }

    // Recursive function with memoization
    private static int knapsack(int i, int w, int[] values, int[] weights, int[][] dp) {
        if (i == 0 || w == 0) return 0; // Base case: No items or no capacity

        if (dp[i][w] != -1) return dp[i][w]; // Return already computed result

        // If the item weight is more than the capacity, we can't include it
        if (weights[i - 1] > w) {
            return dp[i][w] = knapsack(i - 1, w, values, weights, dp);
        } else {
            // Include or exclude the current item
            int include = values[i - 1] + knapsack(i - 1, w - weights[i - 1], values, weights, dp);
            int exclude = knapsack(i - 1, w, values, weights, dp);
            return dp[i][w] = Math.max(include, exclude);
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] values = {10, 40, 30, 50}; // Values of items
        int[] weights = {5, 4, 6, 3};   // Weights of items
        int W = 10;  // Maximum capacity of knapsack

        int maxProfit = knapsackHelper(values, weights, W);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}

package com.company.twopointer;

import java.util.*;

public class UniquePairsSumDivisibleByK {
    public static Set<String> findUniquePairs(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePairs = new HashSet<>();

        for (int num : nums) {
            int rem = num % k;
            int complement = (rem == 0) ? 0 : k - rem;

            if (seen.contains(complement)) {
                // Create a unique representation of the pair
                int minNum = Math.min(num, complement);
                int maxNum = Math.max(num, complement);
                uniquePairs.add(minNum + "," + maxNum);
            }

            seen.add(rem); // Store remainder instead of number
        }

        return uniquePairs;
    }
// if we devide any num by k at max it can store only 0-k-1 right
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 4;
        Set<String> pairs = findUniquePairs(nums, k);

        for (String pair : pairs) {
            System.out.println(pair);
        }
    }
}

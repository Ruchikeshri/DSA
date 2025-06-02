package com.company.twopointer;

import java.util.*;

class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        long result = 0;

        for (int num : nums) {
            int rem = num % k;
            int gcdVal = gcd(rem, k);

            for (int key : count.keySet()) {
                if ((key * gcdVal) % k == 0) {
                    result += count.get(key);
                }
            }

            count.put(gcdVal, count.getOrDefault(gcdVal, 0) + 1);
        }

        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println(sol.countPairs(nums1, k1));
}
}

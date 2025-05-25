package com.company.greedy;

import java.util.*;

public class Solution {

    public int jump(int[] nums) {
        int jump = 0, farthest = 0, end = 0;

        // Important: loop until second last element
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == end) {
                jump++;
                end = farthest;
            }
        }

        return jump;
    }

    // Main method to test the jump function
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps for [2, 3, 1, 1, 4]: " + sol.jump(nums1));
        // Output: 2

        int[] nums2 = {2, 1};
        System.out.println("Minimum jumps for [2, 1]: " + sol.jump(nums2));
        // Output: 1

        int[] nums3 = {1, 1, 1, 1};
        System.out.println("Minimum jumps for [1, 1, 1, 1]: " + sol.jump(nums3));
        // Output: 3
    }
}

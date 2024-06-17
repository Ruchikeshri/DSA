package com.company.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        //  1,2,3,4 - 6
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                return new int[]{numsMap.get(complement), i};
            }
            numsMap.put(nums[i], i);
        }
//        throw new IllegalArgumentException("No two sum Solution");


            // Sort the input array
            Arrays.sort(nums);

            // Initialize pointers
            int left = 0;
            int right = nums.length - 1;

            // Two-pointer approach
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    // Found the pair, return their indices
                    return new int[] { left, right };
                } else if (sum < target) {
                    // Move left pointer to the right
                    left++;
                } else {
                    // Move right pointer to the left
                    right--;
                }
            }

            // No valid solution found
            throw new IllegalArgumentException("No two sum solution");
        }



public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{1,2,4}, 6)));
}
}

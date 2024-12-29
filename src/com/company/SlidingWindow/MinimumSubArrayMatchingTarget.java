package com.company.SlidingWindow;

import java.util.HashMap;

public class MinimumSubArrayMatchingTarget {

    public static int minLengthSubarray(int[] nums, int target) {

        int minLengthSubArray = Integer.MAX_VALUE;
        int currentSum = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            while(currentSum>=target){
                minLengthSubArray = Math.min(minLengthSubArray, i - j + 1);
                currentSum = currentSum - nums[i];
                j++;
            }

        }
        return minLengthSubArray == Integer.MAX_VALUE ? 0 : minLengthSubArray;

    }

    public static int minSubArrayLenHashMap(int[] nums, int target) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); // Base case

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // Check if there's a prefix sum that allows for a valid subarray
            if (prefixSumMap.containsKey(currentSum - target)) {


                int startIndex = prefixSumMap.get(currentSum - target);
                minLength = Math.min(minLength, i - startIndex);
            }

            // Store the prefix sum with the smallest index
            prefixSumMap.putIfAbsent(currentSum, i);
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
//        System.out.println(minSubArrayLenHashMap(new int[]{2, 3, 1, 2, 4, 3}, 7));
        System.out.println(minLengthSubarray(new int[]{2, 3, 1, 2, 4, 3}, 7));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;
            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];
                if (currentSum >= target) {
                    minLength = Math.min(minLength, end - start + 1);
                    break; // No need to check longer subarrays starting from `start`
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

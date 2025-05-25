package com.company.HashTable;

import java.util.*;

public class CountPairs {
    public static int countPairs(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = target - num;
            
            // If complement exists, add its frequency to count
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            // Add current number to the map (incrementing its count)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 7, -1, 5,5,1};
        int target = 6;
        System.out.println(countPairs(nums, target)); // Output: 3
    }
}

package com.company.HashTable;

import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutiveSequence(int[] nums) {
        // Step 1: Create a HashSet to store all the unique numbers from the array.
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestSequence = 0; // Step 2: Initialize a variable to track the longest sequence length found.
        List<Integer> currentSequence = new ArrayList<>();

        // Step 3: Iterate through each number in the array to find the start of sequences.
        for (int num : nums) {
            // Check if 'num' is the start of a sequence by ensuring the previous number is not in the set.
            if (!set.contains(num - 1)) {
                int currentNum = num; // This number is the start of a new sequence.
                int currentSequenceLength = 1; // Initialize the current sequence length to 1.
//                currentSequence.add(currentNum);
                // Step 4: Incrementally check the next numbers in the sequence.
                while (set.contains(currentNum + 1)) {
                    currentNum++; // Move to the next number in the sequence.
                    currentSequenceLength++; // Increase the length of the current sequence.
                    currentSequence.add(currentNum);
                }
                System.out.println(currentSequence);
                // Update the longest sequence found if the current one is longer.
                longestSequence = Math.max(longestSequence, currentSequenceLength);
            }

        }
        return longestSequence; // Return the length of the longest consecutive sequence.
    }
        public static int longestConsecutive(int[] nums) {

            HashMap<Integer,Integer> map = new HashMap<>();
            int longestLength =1;
            int currentLongest=1;

            Arrays.sort(nums);

            for(int i=1;i<nums.length;i++) {
                if (nums[i] != nums[i - 1]) {
                    if (nums[i] == nums[i - 1] + 1) {
                        currentLongest++;
                    } else {
                        longestLength = Math.max(currentLongest, longestLength);
                        currentLongest = 1;

                    }
                }
            }
            return Math.max(longestLength,currentLongest);
        }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive sequence: " + longestConsecutive(nums));
    }
}
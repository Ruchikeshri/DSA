package com.company.HashTable;

import java.util.Arrays;

public class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums); // Sort the array to bring duplicates together
        
        int j = 0;
        int duplicate = 0; // Variable to store the duplicate number
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                duplicate = nums[i]; // Found the duplicate
                break; // Exit the loop once a duplicate is found
            }
            j++; // Move j to the next position
        }
        
        return duplicate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = solution.findDuplicate(nums);
        System.out.println("Duplicate number: " + duplicate);
    }
}
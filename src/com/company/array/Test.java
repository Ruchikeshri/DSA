package com.company.array;

public class Test {
    public static int findDuplicate_mark(int[] nums) {
        for (int num : nums) {
            // Get the absolute value to ensure we always get a non-negative index
            int idx = Math.abs(num);
            
            // If the value at the index is already negative, we found our duplicate
            if (nums[idx] < 0) {
                return idx;  // Corrected to return nums[idx]
            }
            
            // Mark the value at this index as visited by making it negative
            nums[idx] = -nums[idx];
        }

        // This line is not supposed to be reached in a valid input
        return -1;
    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        int duplicate = findDuplicate(nums);
        System.out.println("Duplicate number: " + duplicate); // Output: 3
    }
}

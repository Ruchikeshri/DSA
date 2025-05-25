package com.company.array;

import java.util.Arrays;

public class CanJump {

    public static  boolean canJump(int nums[]){
        int farthest = 0;

        for(int i =0;i<nums.length;i++){

            if(i>farthest){
                return false;
            }
            farthest = Math.max(farthest,i+nums[i]);

            if(farthest>=nums.length-1){
                return  true;
            }
        }
        return false;
    }

    public static boolean canJumpbackTrack(int nums[]){
        int targetIndex = nums.length -1;
        for(int i= nums.length-2;i>=0;i--){
            if(targetIndex<=i+nums[i]){
                targetIndex = i;
            }
        }
        return  targetIndex ==0;
    }
    public static int jump(int[] nums) {
        // Create a memoization array to store the minimum jumps required from each position
        Integer[] memo = new Integer[nums.length];
        Arrays.fill(memo, -1);  // Initialize all values to -1 (indicating uncalculated)
        return jumpRecursive(nums, 0, memo); // Start recursion from the first index
    }

    // Recursive function with memoization
    private static int jumpRecursive(int[] nums, int position, Integer[] memo) {
        // Base case: If we are at or beyond the last index, no more jumps are needed
        if (position >= nums.length - 1) {
            return 0;
        }

        // If we have already computed the result for this position, return it
        if (memo[position] != -1) {
            return memo[position];
        }

        // Initialize minJumps to a large value to find the minimum jumps
        int minJumps = Integer.MAX_VALUE;

        // Try every jump from 1 up to nums[position] (the maximum jump length from the current index)
        for (int i = 1; i <= nums[position]; i++) {
            int nextPosition = position + i;

            // Ensure the next position is valid and within bounds
            if (nextPosition < nums.length) {
                int jumps = jumpRecursive(nums, nextPosition, memo);

                // If it's possible to reach the end from the next position, update minJumps
                if (jumps != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, 1 + jumps);
                }
            }
        }

        // Store the result in the memo array
        memo[position] = minJumps;
        return minJumps;
    }




    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        int nums1[] ={2,3,1,1,4};
        System.out.println(canJumpbackTrack(nums1));  // Output: false
        System.out.println(jump(new int[]{3, 2, 1, 0, 4}));

    }
}

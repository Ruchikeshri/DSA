package com.company.SlidingWindow;

public class LongestOnes {

    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, maxLength = 0,count=0;
        while (i < nums.length) {

            if (nums[i] == 0) {
                count++;
            }
            while (count> k) {
                if(nums[j] ==0) {
                    count--;
                }
                j++;
            }
            maxLength = Math.max(i-j+1, maxLength);
            i++;
        }


        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));

    }
}

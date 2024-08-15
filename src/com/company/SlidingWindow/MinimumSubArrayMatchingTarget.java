package com.company.SlidingWindow;

public class MinimumSubArrayMatchingTarget {

    public static int minLengthSubarray(int nums[], int target){

        int minLengthSubArray=Integer.MAX_VALUE;
        int currentSum=0,j=0;
        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];

            while(currentSum>=target){
                minLengthSubArray = Math.min(minLengthSubArray,i-j+1);
                currentSum= currentSum-nums[i];
                j++;
            }

        }
        return minLengthSubArray == Integer.MAX_VALUE ? 0 : minLengthSubArray;

    }

    public static void main(String[] args) {
        System.out.println(minLengthSubarray(new int[]{2,3,1,2,4,3},7));
    }
}

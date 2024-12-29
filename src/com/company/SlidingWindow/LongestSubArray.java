package com.company.SlidingWindow;

public class LongestSubArray {


        public static int longestSubarray(int[] nums) {

            int i=0,j=0, maxSubarrayLen =0,count =0;

            while(j< nums.length){

                if(nums[j] == 0){
                    count++;
                }

                while(count>1){
                    if(nums[i] ==0){
                        count--;
                    }
                    i++;
                }
                maxSubarrayLen = Math.max(maxSubarrayLen,j-i);
                j++;
            }
            return maxSubarrayLen;
        }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
    }
}

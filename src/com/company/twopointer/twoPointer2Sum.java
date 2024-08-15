package com.company.twopointer;

import java.util.Arrays;

public class twoPointer2Sum {

    public static int[] twoSumSorted(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            int sum = nums[left] + nums[right];
//            if (sum == target) {
//                return new int[]{left, right};
//            } else if (sum < target) {
//                left++;
//            } else {
//                right--;
//            }
//        }

        int left =0, right = nums.length -1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left, right};
            } else if(sum < target){
                left++;
            } else {
                right --;
            }
        }
        return new int[]{};
    }





    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumSorted(new int[]{1,2,4}, 6)));
    }
}
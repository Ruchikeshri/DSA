package com.company.array;

import java.util.Arrays;

public class SortColors {

    public static int[] sortColors(int[] nums) {


        int start =0, end = nums.length-1,current=0;
//        while (current <= end) {
//            if (nums[current] == 0) {
//                // Swap current element with start element
//                swap(nums, current, start);
//                start++;
//                current++;  // Move current pointer only if you swap with start
//            } else if (nums[current] == 2) {
//                // Swap current element with end element
//                swap(nums, current, end);
//                end--; // Decrease end because 2s are at the end
//            } else {
//                // If the current element is 1, just move current pointer
//                current++;
//            }
//        }
//        return nums;

        while(current<=end){
            if(nums[current] == 0){
                swap(nums,start,current);
                current++;
                start++;
            } else if(nums[current] ==2){
                swap(nums,current,end);
                end--;
            } else {
                current++;
            }
        }
        return nums;
    }

    public static void swap(int nums[],int start,int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2,0,2,1,1,0};
        int nums1[] = new int[]{2,0,1};

        System.out.println(Arrays.toString(sortColors(nums1)));
    }
}

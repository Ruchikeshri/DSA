package com.company.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MaxOfAllSubArrays {

    private static List<Integer> maxOfAllSubArraysK(int nums[], int k){
        if(k> nums.length){
            throw new IllegalArgumentException("Inavlid size");
        }
        int max =0;
        List<Integer> list = new ArrayList<>();
         int j=0;
          for(int i=0;i<nums.length;i++){

              for(int t=j;t<=i;t++){
                  max = Math.max(nums[t],max);
              }
              if(i-j+1 == k) {
                  list.add(max);
                  j++;
                  max=0;
            }

          }

        return  list;
    }

    public static List<Integer> maxOfAllSubArraysKsize(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("Invalid size");
        }
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i=0;i<=nums.length-k;i++){
            if(maxIndex<i){
                max = Integer.MIN_VALUE;
                for(int j=i;j<i+k;j++){
                    if(nums[j]>max) {
                        maxIndex = j;
                        max = nums[j];
                    }
                }
            } else if(nums[i+k-1]>max){
                maxIndex = i+k-1;
                max = nums[i+k-1];
            }
            result.add(max);
        }
//        return  result;


//        for (int i = 0; i <= nums.length - k; i++) {
//            // Update the maximum for the new window
//            if (maxIndex < i) {
//                // Max is out of the window, recalculate for the new window
//                max = Integer.MIN_VALUE;
//                for (int j = i; j < i + k; j++) {
//                    if (nums[j] > max) {
//                        max = nums[j];
//                        maxIndex = j;
//                    }
//                }
//            } else if (nums[i + k - 1] > max) {
//                // Check only the new element added to the window
//                max = nums[i + k - 1];
//                maxIndex = i + k - 1;
//            }
//            result.add(max);
//        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        List<Integer> result = maxOfAllSubArraysK(nums, k);
        List<Integer> res = maxOfAllSubArraysKsize(nums,k);
        System.out.println("Maximum of all subarrays of size " + k + ": " + result);
        System.out.println("Maximum of all subarrays of size " + k + ": " + res);

    }
}

package com.company.SlidingWindow;

import java.util.*;

public class MaxOfAllSubArrays {

    private static List<Integer> maxOfAllSubArraysK(int nums[], int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("Inavlid size");
        }
        int max = 0;
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int t = j; t <= i; t++) {
                max = Math.max(nums[t], max);
            }
            if (i - j + 1 == k) {
                list.add(max);
                j++;
                max = 0;
            }

        }

        return list;
    }

    public static List<Integer> maxOfAllSubArraysKsize(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("Invalid size");
        }
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i <= nums.length - k; i++) {
            if (maxIndex < i) {
                max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] > max) {
                        maxIndex = j;
                        max = nums[j];
                    }
                }
            } else if (nums[i + k - 1] > max) {
                maxIndex = i + k - 1;
                max = nums[i + k - 1];
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


    public static List<Integer> maxOfAllSubArraysDeque(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();


        for(int i=0;i<nums.length;i++){
            //checks if part of current window  i-k+1 i =4 k=3 4-3+1 2 and index at 0 needs to pppoed frommqueue no longer part of current?
           //i-k+1 -give sforst index, i mean last index
            if(!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }

            // in  this  valid wondow pop value which can not contrubute to the result
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i>= k-1){
                    result.add(nums[deque.peekFirst()] );
            }
        }

//        for (int i = 0; i < nums.length; i++) {
//            // Remove elements that are out of the current window
//            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
//                deque.pollFirst();
//            }
//
//            // Remove elements from the back of the deque if they are smaller than the current element
           //            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
//                deque.pollLast();
//            }
//
//            // Add the current element's index to the deque
//            deque.offerLast(i);
//
//            // Once the first k elements are processed, the front of the deque is the max of the current window
//            if (i >= k - 1) {
//                result.add(nums[deque.peekFirst()]);
//            }
//        }

        return result;
    }



    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
//        List<Integer> result = maxOfAllSubArraysK(nums, k);
//        List<Integer> res = maxOfAllSubArraysKsize(nums,k);
//        System.out.println("Maximum of all subarrays of size " + k + ": " + result);
//        System.out.println("Maximum of all subarrays of size " + k + ": " + res);
        List<Integer> result2 = maxOfAllSubArraysDeque(nums, k);
        System.out.println("Maximum of all subarrays of size " + k + ": " + result2);

    }
}

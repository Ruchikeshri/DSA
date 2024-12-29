package com.company.SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeNumberFromSubaarySizek {


    public static List<Integer> firstNegativeSubarrayK(int[] nums, int k) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while (j < nums.length) {
            if (nums[j] < 0) {
                list.add(j);
            }
            if (j - i + 1 == k) {
                if (!list.isEmpty()) {
                    result.add(nums[list.get(0)]);
                } else {
                    result.add(0);
                }
                if (!list.isEmpty() && list.get(0) == i) { // before sliding remove old which was after iteration wil not be part of current window
                    list.remove(0);
                }
                i++;
            }
            j++;
        }
        return result;
    }
    public static List<Integer> firstNegativeSubarrayKBruteForce(int[] nums, int k) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <= nums.length - k; i++) {
                boolean found = false;
//                for (int j = i; j < i + k; j++) {
//                    if (nums[j] < 0) {
//                        result.add(nums[j]);
//                        found = true;
//                        break;
//                    }
//                }
                for(int j =i;j<i+k;j++){
                    if(nums[j]< 0){
                        result.add(nums[j]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result.add(0);
                }
            }
            return result;
        }

        public static List<Integer> firstNegSlidingUsingQueueu(int[] nums, int k){

        Deque<Integer> deque = new LinkedList();
        List<Integer> result = new ArrayList<>();


        for(int i=0;i<nums.length;i++){

            if(!deque.isEmpty() && deque.peekFirst() <i-k+1){
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] >= 0){
                deque.pollLast();
            }

            deque.offerLast(i);
            if(i>=k-1){
                result.add(nums[deque.peekFirst()]);
            }
        }
        return result;
        }

        public static void main(String[] args) {
            int[] nums = {2, -1, 5, -6, 0, -9, 8, 3, -2};
            int k = 3;
            List<Integer> result = firstNegativeSubarrayK(nums, k);

//            System.out.println("First negative number in every subarray of size " + k + ": ");
//            for (int num : result) {
//                System.out.print(num + " ");
//            }

            System.out.println();
            List<Integer> res = firstNegativeSubarrayK(nums, k);
            System.out.println("result "+res);
            System.out.println(firstNegativeSubarrayKBruteForce(nums,k));

            System.out.println(firstNegSlidingUsingQueueu(nums,k));
        }
    }


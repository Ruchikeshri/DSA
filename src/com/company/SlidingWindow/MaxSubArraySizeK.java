        package com.company.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArraySizeK {


    public static int maxSumSubarraySizeK(int arr[], int k) {
        int size = arr.length;
        List<Integer> list = new ArrayList<>();
        if (k > size) {
            throw new IllegalArgumentException("Invalid window size");
        }
        int i = 0, j = 0;
        int sum  = 0, maxSum = 0, start =0,end =0;
        while (j < size) {
            sum += arr[j];
            if (j - i + 1 == k) {
                list.add(sum);
//                maxSum = Math.max(sum, maxSum);
                if(sum> maxSum){
                    maxSum = sum;
                    start =i;
                    end = j;
                }
                sum = sum - arr[i];

                System.out.println(start + " " +  end);
                i++;
            }
            j++;
        }
        System.out.println((list));
        return maxSum;
    }

    public static int maxSubarrayk(int num[], int k) {
        int maxSum = 0, windowSum = 0, start = 0, end = 0;

        if (k > num.length) {
            throw new IllegalArgumentException("Invalid window size");
        }

        for (int i = 0; i < k; i++) {
            windowSum += num[i];
        }
        maxSum = windowSum;
        for (int i = 0; i < num.length - k; i++) {
            windowSum = windowSum - num[i] + num[i + k];
            if (windowSum > maxSum) {
                maxSum = Math.max(windowSum, maxSum);
                start = i + 1;
                end =  i + k;
            }
        }
        for (int j = start; j <= end; j++) {
            System.out.print(num[j] + " ->");
        }
        System.out.println();
        return maxSum;
    }

    public static int maxSumSubarraySizeKBruteForce(int[] arr, int k) {
        int size = arr.length;
        if (k > size) {
            throw new IllegalArgumentException("Invalid window size");
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= size - k; i++) { // to keep windwo size of K and last valid window of subArray
            int currentSum = 0;
            for (int j = 0; j < k; j++) {
                currentSum += arr[i + j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int maxSumSubarraySizeKPrefixSum(int[] arr, int k) {
        int size = arr.length;
        if (k > size) {
            throw new IllegalArgumentException("Invalid window size");
        }

        // Create prefix sum array
        int[] prefixSum = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int maxSum = Integer.MIN_VALUE;

        // Calculate max sum using prefix sum array
        for (int i = k; i <= size; i++) {
            int currentSum = prefixSum[i] - prefixSum[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int maxSumSubarraySizeKSlidingWindow(int[] arr, int k) {
        if (k > arr.length) {
            throw new IllegalArgumentException("size not valid");
        }
        int windowSum=0,maxSum=0;
        for (int i = 0; i <k;i++) {
            windowSum+= arr[i];
        }
        maxSum =windowSum ;

        for(int i=k;i<arr.length;i++){
            windowSum += arr[i] -arr[i-k];
            maxSum = Math.max(windowSum,maxSum);

        }
        return maxSum;
    }
        public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;

        System.out.println(maxSumSubarraySizeK(nums, k));
        System.out.println(maxSumSubarraySizeKPrefixSum(nums, k)); // Output: 24 (7+8+9)
        System.out.println(maxSumSubarraySizeKBruteForce(nums,k));
        System.out.println(maxSubarrayk(nums,k));
    }
}

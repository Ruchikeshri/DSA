package com.company.searching;

public class LISBinarySearch {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];  // tails[i] = the smallest tail of all increasing subsequences with length i+1
        int length = 0;

        for (int num : nums) {
            int left = 0, right = length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            tails[left] = num;


            if (left == length) {
                length++;  // We've extended the size of LIS
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lisLength = lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);
    }
}

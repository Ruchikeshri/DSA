package com.company.searching;

public class ValidSplitArray {


    public static void main(String[] args) {
        ValidSplitArray sol = new ValidSplitArray();

        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        int result = sol.splitArray(nums, k);
        System.out.println("Minimum largest sum after splitting: " + result);
    }

    public int splitArray(int[] nums, int k) {
        int low = getMax(nums);  // Smallest possible max sum
        int high = getSum(nums); // Largest possible max sum

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canSplit(int[] nums, int k, int max) {
        int count = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num <= max) {
                sum += num;
            } else {
                count++;
                sum = num;
            }
        }

        return count <= k;
    }

    public int getMax(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(n, max);
        }
        return max;
    }

    public int getSum(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }
}

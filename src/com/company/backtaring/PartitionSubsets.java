package com.company.backtaring;

public class PartitionSubsets {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // If total sum can't be divided evenly, return false
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        int[] buckets = new int[k];

        return backtrack(nums, buckets, 0, target);
    }

    public static boolean backtrack(int[] nums, int[] buckets, int index, int target) {
        if (index == nums.length) {
            for (int bucket : buckets) {
                if (bucket != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + nums[index] > target) {
                continue;
            }

            buckets[i] += nums[index];

            // 🔁 This return is crucial for passing true up the call stack
            //it mean if I fiud asoution utinl here all the previoud cllaer has helped to reach until this and
            // a reuskt all of tehm are alos valid
            if (backtrack(nums, buckets, index + 1, target)) {
                return true;
            }

            buckets[i] -= nums[index];

            // ⚡️ Optimization: if this bucket was 0 and didn't work, no need to try other empty buckets
            if (buckets[i] == 0) {
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2}; // Example input
        int k = 2;

        boolean result = canPartitionKSubsets(nums, k);
        System.out.println("Can partition into " + k + " subsets with equal sum? " + result);
    }
}

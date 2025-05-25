package com.company.practise;

    import java.util.*;

    class Solution {
        public List<int[]> findUniquePairsWithSumMultipleOfK(int[] nums, int k) {
//            Set<Integer> seen = new HashSet<>();
            List<int[]> result = new ArrayList<>();
            Map<Integer, Integer> remainderCount = new HashMap<>();

            for (int num : nums) {
                int remainder = (num % k + k) % k;
                int complement = (k - remainder) % k;

                if (remainderCount.getOrDefault(complement, 0) > 0) {
                    result.add(new int[]{num, complement});
                } else {
                    remainderCount.put(remainder, remainderCount.getOrDefault(complement, 0) + 1);
                }

                // Store the remainder
            }

            return result;
        }
        public List<int[]> findPairsTwoPointers(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();

        int left = 0, right = nums.length - 1;
        while(left<right)

        {
            int sum = nums[left] + nums[right];

            if (sum % k == 0) {
                result.add(new int[]{nums[left], nums[right]});
                left++;
                right--;  // Ensure uniqueness
            } else if (sum % k > 0) {
                left++;  // Increase sum
            } else {
                right--; // Decrease sum
            }
        }

        return result;

    }
        public static void main(String[] args) {
            Solution sol = new Solution();
            int[] nums = {1, 2, 3, 4, 5, 10, 6,2};
            int k = 5;
            List<int[]> pairs = sol.findPairsTwoPointers(nums, k);

            for (int[] pair : pairs) {
                System.out.println(Arrays.toString(pair));
            }
        }
    }



package com.company.heap;

import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        // Pair nums1[i] with nums2[i] and store them
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }

        // Sort by nums2 in descending order (so that we always take the max nums2 first)
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // Min-heap for k largest nums1 values
        long sum = 0, maxScore = 0;

        // Add first k elements
        for (int i = 0; i < k; i++) {
            minHeap.offer(pairs[i][0]);
            sum += pairs[i][0];
        }

        // Compute initial score
        maxScore = sum * pairs[k - 1][1];

        // Try adding new elements while maintaining k elements
        for (int i = k; i < n; i++) {
            minHeap.offer(pairs[i][0]);
            sum += pairs[i][0];

            // Remove smallest element (to ensure only k elements remain)
            sum -= minHeap.poll();

            // Calculate score
            maxScore = Math.max(maxScore, sum * pairs[i][1]);
        }

        return maxScore;
    }

    public static void main(String[] args) {
//       int nums1 = [1,3,3,2], nums2 = [2,1,3,4], k =
        new Solution().maxScore(new int[]{1,3,3,3},new int[]{2,1,3,4},3);
    }
}

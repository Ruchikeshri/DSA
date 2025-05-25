package com.company.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MergeSorted2 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int result[] = new int[nums1.length];

        int i=0,j=0,k=0;

        while(i<m && j< n){

            if(nums1[i]<=nums2[j]){
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }

        }

        while(i<m){
            result[k++] = nums1[i++];
        }
        while(j<n){
            result[k++] = nums2[j++];
        }
        for(int arr:result){
            System.out.print(arr + " ");
        }
    }

    public void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        // Copy all elements of nums2 into nums1 starting at position m
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // Sort the nums1 array
        Arrays.sort(nums1);
    }

    public static void mergeInPlaceOptimal(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1;
        int q = n-1;
        int k = m + n- 1;

        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[k--] = nums1[p--];
            } else {
                nums1[k--] = nums2[q--];
            }
        }
        while (q >= 0) {
            nums1[k--] = nums2[q--];
        }
        System.out.println();
        for(int arr:nums1){
            System.out.print(arr + " ");
        }
    }

    public void mergeUsingStream(int[] nums1, int m, int[] nums2, int n) {
        // Create streams for nums1 and nums2, limiting nums1 to its first 'm' elements
        IntStream stream1 = Arrays.stream(nums1, 0, m);
        IntStream stream2 = Arrays.stream(nums2, 0, n);

        // Concatenate the two streams, sort, and collect them into nums1
        int[] mergedArray = IntStream.concat(stream1, stream2)
                .sorted()
                .toArray();

        // Copy the result back into nums1
        for (int i = 0; i < mergedArray.length; i++) {
            nums1[i] = mergedArray[i];
        }
    }

    public void mergeUsingQueue(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements of nums1 and nums2 to the heap
        for (int i = 0; i < m; i++) {
            pq.add(nums1[i]);
        }
        for (int j = 0; j < n; j++) {
            pq.add(nums2[j]);
        }

        // Extract the sorted elements from the heap and put them in nums1
        int index = 0;
        while (!pq.isEmpty()) {
            nums1[index++] = pq.poll();
        }
    }


    public static void mergeRecur(int[] nums1, int m, int[] nums2, int n) {
        mergeHelper(nums1, nums2, m, n, m + n - 1);
    }

    private static void mergeHelper(int[] nums1, int[] nums2, int i, int j, int k) {
        // Base cases
//        if (j == 0) return; // No more elements in nums2 to merge
//        if (i == 0) { // Copy remaining nums2 into nums1
//            for (int l = 0; l < j; l++) {
//                nums1[l] = nums2[l];
//            }
//            return;
//        }
//
//        // Merge the largest element at the end
//        if (nums1[i - 1] > nums2[j - 1]) {
//            nums1[k] = nums1[i - 1];
//            mergeHelper(nums1, nums2, i - 1, j, k - 1);
//        } else {
//            nums1[k] = nums2[j - 1];
//            mergeHelper(nums1, nums2, i, j - 1, k - 1);
//        }

        if(j ==0) return ;
        if(i==0){
            for(int l=0;l<j;l++){
                nums1[l] = nums2[l];
            }
            System.out.println();

            for(int res : nums1){
                System.out.print( res +  " ");
            }
            return;
        }

        if(nums1[i-1]>=nums2[j-1]){
            nums1[k] = nums1[i-1];
            mergeHelper(nums1,nums2,i-1,j,k-1);
        } else {
            nums1[k] = nums2[j-1];
            mergeHelper(nums1,nums2,i,j-1,k-1);
        }
    }

    public static void main(String[] args) {
      merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
      mergeInPlaceOptimal(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
      mergeRecur(new int[]{7,0,0,0,0,},1,new int[]{2,4,5,6},3);

    }
}

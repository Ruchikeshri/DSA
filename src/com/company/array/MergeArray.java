package com.company.array;

import java.util.Arrays;

public class MergeArray {

    public static void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        // Copy elements of nums2 into nums1 starting from index m
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // Sort the combined array
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {



//        if(nums1.length == 0 || nums1.length ==1) return false;
//        int j=0;
//        for(int i=0;i<nums1.length;i++){
//
//            if(nums1[i] ==0){
//                if(nums2[j]<nums1[i-1]){
//                    nums1[i] = nums2[j];
//                } else {
//                    int temp = nums1[i-1];
//                    nums1[i-1] = nums2[j];
//                    nums1[i] = temp;
//                }
//                j++;
//            }
//        }
//        for(int i: nums1)
//        return false;
//    }

            int p = m+n-1;

            int p1 = m-1;

            int p2 = n-1;

            while(p1>=0 &&  p2>=0){
                if(nums1[p1]> nums2[p2]){
                    nums1[p] = nums1[p1];
                    p1--;
                } else {
                    nums1[p] = nums2[p2];
                    p2--;
                }
                p--;
            }

            while(p2>=0){
                nums1[p] =nums2[p2];
                p2--;
                p--;
            }
            for(int i: nums1){
                System.out.print(i);
            }
        }

        public  static void mergeArrayUsingthreePointer(int[] nums1, int m, int[] nums2, int n){

        int aux[] = new int[m+n];

        int i=0,j=0,k=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                aux[k++] = nums1[i++];
            } else{
                aux[k++] = nums2[j++];
            }
        }

        while(i<m){
            aux[k++] = nums1[i++];
        }
        while ((j<n)){
            aux[k++] = nums2[j++];
        }

        for(int l=0;l<aux.length;l++){
            nums1[l] = aux[l];
        }
            System.out.println(Arrays.toString(nums1));
        }


    public static void mergeUsingInsertionSubOptimal(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int j = m - 1;
            // Find the correct position to insert nums2[i]
            while (j >= 0 && nums1[j] > nums2[i]) {
                nums1[j + 1] = nums1[j];
                j--;
            }
            nums1[j + 1] = nums2[i];
            m++;
        }
        System.out.println();
    }


    public static void main(String[] args) {
//        System.out.println(
        mergeUsingInsertionSubOptimal(new int[]{1, 2, 3, 0, 0, 0},3,new int[]{2,5,6},3);
//    );
    }
}

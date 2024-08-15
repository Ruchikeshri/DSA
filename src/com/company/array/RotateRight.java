package com.company.array;

import java.util.Arrays;

public class RotateRight {


        // WRITE THE ROTATE METHOD HERE //
        //                              //
        //                              //
        //                              //
        //                              //
        //////////////////////////////////

        public static void rotate(int nums[], int k){

            k = k% nums.length;
//            reverse(nums, 0, nums.length-1);
//        reverse(nums,0,k-1);
//        reverse(nums,k,nums.length-1);
            // for (int i = 0; i < k; i++) {
            //     int temp = nums[nums.length-1];
            //     for (int j =nums.length-1; j >0; j--) {
            //         nums[j] = nums[j - 1];
            //     }
            //     nums[0] = temp;
            // }
//            for (int i = 0; i < k; i++) {
//                int temp = nums[nums.length-1];
//                for (int j = nums.length-1; j>0 ;j--) {
//                    nums[j] = nums[j - 1];
//                }
//                nums[0] = temp;
//            }


            for ( int i =0; i<k;i++){
                int temp =nums[0] ;
                for(int j=1; j<nums.length; j++){
                    nums[j-1]=nums[j];
                }
                nums[nums.length-1]=temp;

            }



        }

    private static void reverse(int[] nums, int start, int end) {
            while (start<end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
            }

    }


    public static void main(String[] args) {
            int[] nums1 = {1, 2, 3, 4, 5};
            int k1 = 2;
            rotate(nums1, k1);
            System.out.println("Test case 1: Rotated array: " + Arrays.toString(nums1));  // prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"
// prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"

            int[] nums2 = {-1, -100, 3, 99};
            int k2 = 2;
            rotate(nums2, k2);
            System.out.println("Test case 2: Rotated array: " + Arrays.toString(nums2));  // prints "Rotated array: [3, 99, -1, -100]"

            int[] nums3 = {1, 2};
            int k3 = 3;
            rotate(nums3, k3);
            System.out.println("Test case 3: Rotated array: " + Arrays.toString(nums3));  // prints "Rotated array: [2, 1]"

            int[] nums4 = {1};
            int k4 = 0;
            rotate(nums4, k4);
            System.out.println("Test case 4: Rotated array: " + Arrays.toString(nums4));  // prints "Rotated array: [1]"

            int[] nums5 = {1, 2, 3, 4, 5, 6};
            int k5 = 6;
            rotate(nums5, k5);
            System.out.println("Test case 5: Rotated array: " + Arrays.toString(nums5));  // prints "Rotated array: [1, 2, 3, 4, 5, 6]"

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Rotated array: [5, 6, 7, 1, 2, 3, 4]
            Test case 2: Rotated array: [3, 99, -1, -100]
            Test case 3: Rotated array: [2, 1]
            Test case 4: Rotated array: [1]
            Test case 5: Rotated array: [1, 2, 3, 4, 5, 6]
        */

        }

    }

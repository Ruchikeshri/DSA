package com.company.DynamicProgramming;


public class MaxSubarray {


    public static int maxSubArray(int arr[]){
        int maxSoFar = arr[0];
        int currMax = arr[0];
        int k=0;
        int start = 0, end = 0; // Variables to track subarray indices

        for(int i=1;i<arr.length;i++){
            currMax = currMax + arr[i];
            if(currMax<arr[i]){
                currMax = arr[i];
                start = i; // Start of new subarray

            } if(maxSoFar<currMax){
                maxSoFar = currMax;
                end = i; // End of maximum subarray
            }
        }
        System.out.print("Subarray with Maximum Sum: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
//        System.out.println(Arrays.toString(result));
        return maxSoFar;
    }

    public class NaiveMaxSubarray {

        public static int maxSubArray(int[] nums) {
            int n = nums.length;
            int maxSum = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int currentSum = 0;
                for (int j = i; j < n; j++) {
                    currentSum += nums[j];
                    maxSum = Math.max(maxSum, currentSum);
                }
            }

            return maxSum;
        }


    }


    public static void main(String args[]){
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4
//                4,3,-2,6,-12,7,-1,6
        };
        System.out.println(maxSubArray(arr));
//        System.out.println(NaiveMaxSubarray.maxSubArray(arr));

    }
}

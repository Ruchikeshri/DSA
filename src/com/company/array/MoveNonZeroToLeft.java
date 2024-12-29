package com.company.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveNonZeroToLeft {

    //2 pointer
    public static void moveNonZeroesToLeft(int arr[]){
        int nonZeroIndex =0;
        for(int i=0;i< arr.length;i++){
            if(arr[i]!=0){
                arr[nonZeroIndex] = arr[i];
               nonZeroIndex++;
            }
        }

        int nonZeroCount = arr.length - nonZeroIndex;
        for (int j = arr.length -1; j > nonZeroCount ;j--){
            arr[j] =0;
        }


//        for(int i=nonZeroIndex;i< arr.length;i++){
//            arr[i] =0;
//        }

    }

    //2. Brute Force (Inefficient)
    public void moveZeroesB(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;

        // Copy all non-zero elements to the result array
        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        // Copy result back to the original array
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

//3. In-place Swap
    public void moveZeroes(int[] nums) {
    int lastNonZeroFoundAt = 0;

    // If the current element is non-zero, swap it with the last found zero
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            int temp = nums[lastNonZeroFoundAt];
            nums[lastNonZeroFoundAt] = nums[i];
            nums[i] = temp;
            lastNonZeroFoundAt++;
        }
    }
}
//4. Count Zeroes and Shift
    public void moveZeroesCount(int[] nums) {
        int count = 0; // Count of non-zero elements

        // Move all non-zero elements to the beginning of the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        // Fill the remaining part of the array with zeroes
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }
//5. Queue-based Approach
    public void moveZeroesQueue(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();

        // Add all non-zero elements to the queue
        for (int num : nums) {
            if (num != 0) {
                queue.offer(num);
            }
        }

        // Replace elements in the original array with non-zero elements from the queue
        int index = 0;
        while (!queue.isEmpty()) {
            nums[index++] = queue.poll();
        }

        // Fill the rest of the array with zeroes
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveNonZeroesToLeft(arr);
        System.out.println("Array after moving non-zero elements to the left: " + Arrays.toString(arr));
    }
    }


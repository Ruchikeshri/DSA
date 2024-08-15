package com.company.array;

public class RemoveDuplicates {

    public static int removeDuplicates(int nums[], int k){
        if(nums.length <=2) {
            return nums.length;
        }
        int slow =2;

        for(int fast = 2; fast < nums.length ; fast++){
            if(nums[fast] != nums[slow-2]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5};
        int k = 2;

        int newLength = removeDuplicates(nums, k);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i <= newLength-1; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}

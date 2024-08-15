package com.company.SlidingWindow;

import com.company.HashTable.Solution;

public class ContainsNearByDuplicate {

    public static boolean containsNearByDuplicate(int nums[],int k)
    {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+k&& j<nums.length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;


        System.out.println(containsNearByDuplicate(nums1, k1)); // Output: true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(containsNearByDuplicate(nums2, k2)); // Output: true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(containsNearByDuplicate(nums3, k3)); // Output: false
    }
}

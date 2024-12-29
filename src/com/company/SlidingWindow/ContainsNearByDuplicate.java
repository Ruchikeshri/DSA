package com.company.SlidingWindow;

import com.company.HashTable.Solution;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearByDuplicate {

    public static boolean containsNearByDuplicate(int nums[],int k)
    {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;
//                j<=i+k
//                    &&
            j<nums.length && j-i<=k;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }



        public static boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> window = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                // If the current element already exists in the set, we found a duplicate
                if (window.contains(nums[i])) {
                    return true;
                }

                // Add the current element to the sliding window set
                window.add(nums[i]);

                // Maintain the window size of at most k elements
                if (window.size() > k) {
                    window.remove(nums[i - k]); // Remove the element that is out of the window
                }
            }

            return false; // No duplicates found within the given range
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

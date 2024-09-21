package com.company.array;

import java.util.HashSet;
import java.util.Set;

class ContainsNearByDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(); //nums = 1,0,2,1 k=1

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true; // Found a duplicate within the window
            }

            set.add(nums[i]);

            // Maintain the window size to be exactly k
            if (set.size() > k) {
                set.remove(nums[i - k]); // Remove the oldest element in the window
            }
        }

        return false; // No duplicates found within the given window size

//        public boolean containsNearbyDuplicate(int[] nums, int k) {

//            int j=1;
//            for(int i=0;i<nums.length;i++){
//
//                while(j <= i + k && j <nums.length){
//                    if(nums[i] == nums[j] ){
//                       return true;
//                    }
//                    j++;
//
//                }
//
//            }
//co
//        return false;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(ContainsNearByDuplicate.containsNearbyDuplicate(nums1, k1)); // Output: true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(ContainsNearByDuplicate.containsNearbyDuplicate(nums2, k2)); // Output: true

        int[] nums3 ={1,2,3,1,2,3};
//                {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(ContainsNearByDuplicate.containsNearbyDuplicate(nums3, k3)); // Output: false
    }
}

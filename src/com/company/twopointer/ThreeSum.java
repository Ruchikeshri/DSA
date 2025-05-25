package com.company.twopointer;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
                int n = nums.length;
                for (int i = 0; i < n - 2; i++) {
                    for (int j = i + 1; j < n - 1; j++) {
                        for (int k = j + 1; k < n; k++) {
                            if (nums[i] + nums[j] + nums[k] == 0) {
                                List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                                Collections.sort(triplet); // Ensure uniqueness by sorting
                                set.add(triplet); // Avoid duplicates
                            }
                        }
                    }
                }
                result.addAll(set);
                return result;

        }

//        int i = 0, j = i + 1, k = j + 1;
//        int sum = 0;
//
//        while (i < j && j < k && k < nums.length) {
//            sum = nums[i] + nums[j] + nums[k];
//            if (sum == 0) {
//                result.add(Arrays.asList(nums[i],nums[j], nums[k]));
//            }
//            i++;
//            j++;
//            k++;
//
//        }
//        return result;

    public static List<List<Integer>> threeSumTwoPointer(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                     Skip duplicates for left and right pointers
                    // if current and next equal and j<k skip
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // if current and prev  equal and j<k skip
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumUsingSet(int nums[]){

        //;.imp note to take set as result and sort is imp
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int target = -nums[i];
            Set<Integer> seen = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int complement = target - nums[j];

                if(seen.contains(complement)){

                    result.add(Arrays.asList(nums[i],nums[j],complement));
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSumUsingHashMap(int nums[]){
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i< nums.length -2;i++){
            int target = -nums[i];
            Map<Integer,Integer> seen = new HashMap<>();
            for(int j=i+1;j<nums.length;j++){
                int complement = target-nums[j];

                if(seen.containsKey(complement)){
                    result.add(Arrays.asList(nums[i],nums[j],nums[seen.get(complement)]));
                }
                seen.put(nums[j],j);
            }
        }
        return  new ArrayList<>(result);
    }

    // withs storing completement withoutout use result as set
    public static List<List<Integer>> threeSumUsingHashMap2nd(int nums[]){

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for(int i=0;i<nums.length-2;i++){
//            if(i>0 && nums[i] == nums[i-1]);

            int target = -nums[i];
            Map<Integer,Integer> seen = new HashMap<>();

            for(int j=i+1;j<nums.length;j++){
                int complement = target-nums[j];
                if(seen.containsKey(nums[j])){
                    result.add(Arrays.asList(nums[i],nums[j],nums[seen.get(nums[j])]));
                    while (j+1<nums.length && nums[j]== nums[j+1]) j++;
                } else {
                    seen.put(complement, j);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSumUsingSet(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSumUsingHashMap(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println();
        System.out.println(threeSumUsingHashMap(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSumTwoPointer(new int[]{-2,0,0,2,2}));
        System.out.println(threeSumUsingHashMap2nd(new int[]{-1, 0, 1, 2, -1, -4}));


//                {-1, 0, 1, 2, -1, -4}));
    }
    //-4,-1,-1,0,1,2
}

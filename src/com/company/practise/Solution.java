package com.company.practise;

import java.util.*;

class Solution1 {
    public List<int[]> findPairsWithTargetSum(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

//        for (int num : nums) {
//            int complement = target - num;
//            if (map.containsKey(complement)) {
//                result.add(new int[]{complement, num});
//            }
//            map.put(num, 1); // Store the number in map
//        }
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;

            // If the complement is already seen, add the pair
            if (seen.contains(complement)) {
                result.add(new int[]{complement, num});
            }

            // Add the current number to the seen set
            seen.add(num);
        }

        return result;
    }

    public static List<int[]> findUniquePair(int nums[],int k){
        Map<Integer,Integer> map = new HashMap<>();

        Set<List<Integer>> uniquePairs = new HashSet<>();

        List<int[]> list = new ArrayList<>();

        for(int num : nums){
            int complement = k-num;

            if(map.containsKey(complement)){
                List<Integer> pair = Arrays.asList(
                        Math.min(num,complement),
                        Math.max(num,complement)
                );
                uniquePairs.add(pair);
             }
            List<int[]> result = new ArrayList<>();
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<int[]> result = new ArrayList<>();

        for(List<Integer> pair: uniquePairs){
             result.add(new int[]{pair.get(0),pair.get(1)});
        }
        return result;
    }

    public static List<int[]> findUniqueWith2Pointer(int nums[],int k){
        Arrays.sort(nums);
        int left =0, right = nums.length-1;
        List<int[]> result = new ArrayList<>();

        while(left<right){
           int sum = nums[left]+nums[right];

           if(sum == k){
               result.add(new int[]{nums[left],nums[right]});
               left++;
               right--;

               while(left<right && nums[left] == nums[left]+1) left++;
               while (left<right && nums[right] == nums[right+1]) right--;
           } else if(sum<k){
               left++;

           }else{
               right--;
           }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] nums = {2, 7, 4, 5, 1, 3, 8,2};
        int target = 9;
        List<int[]> pairs = findUniqueWith2Pointer(nums, target);
        
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }
}

 package com.company.array;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class ArraySumEqualsK {
    public static List<int[]> subarraySum(int[] nums, int k) {
        Map<Integer,List<Integer>> subArrayMap = new HashMap<>();
        int cumlSum = 0;
        List<int[]> result = new ArrayList<>();
        subArrayMap.put(0, new ArrayList<>());
        subArrayMap.get(0).add(-1);

        for(int i=0;i<nums.length;i++){

            cumlSum+= nums[i];

            int complementKey = cumlSum -k;
            if(subArrayMap.containsKey(complementKey)){
                List<Integer> startIndexes = subArrayMap.get(complementKey);
                for(int index: startIndexes){
                    result.add(new int[]{index+1,i});
                }

            }
            subArrayMap.putIfAbsent(cumlSum,new ArrayList<>());
            subArrayMap.get(cumlSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        List<int[]> subarrays = subarraySum(nums, k);

        // Print the count of subarrays
        System.out.println("Count of subarrays: " + subarrays.size());

        // Print the subarrays
//        for (int[] subarray : subarrays) {
//            int start = subarray[0];
//            int end = subarray[1];
//            System.out.print("Subarray: ");
//            for (int i = start; i <= end; i++) {
//                System.out.print(nums[i] + " ");
//            }
//            System.out.println();
//        }
        for(int[] subarray: subarrays){
            int start = subarray[0];
            int end = subarray[1];
            System.out.print("Subarray:");
            for(int i=start;i<=end;i++){
                System.out.print(nums[i]+ " ");
            }
            System.out.println();

        }
    }
}

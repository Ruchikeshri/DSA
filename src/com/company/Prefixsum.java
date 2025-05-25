package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Prefixsum {

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{5,0,0,0},3));
              List<int[]> result =  numOfSubarraysWithIndices(new int[]{1,3,5});
        String resultString = result.stream()
                .map(Arrays::toString)  // Convert each int[] to a string
                .collect(Collectors.joining(", ", "[", "]"));  // Join them with commas
        System.out.println( resultString);

    }

        public  static boolean checkSubarraySum(int[] nums, int k) {

            HashMap<Integer,Integer> map = new HashMap<>();
            int sum=0,count=0;
            map.put(0,-1);
            for(int i=0;i<nums.length;i++){
                sum+= nums[i];
                int candidate = sum%k;

                if (candidate < 0) {
                    candidate += k;
                }
                if(map.containsKey(candidate) && i - map.get(candidate) >= 2){
                    count++;
                } else{
                    map.putIfAbsent(candidate,i);
                }
            }
            return count !=0;
        }

        public static int numOfSubarrays(int[] arr) {

            Map<Integer,Integer> map = new HashMap<>();
            int sum=0,count=0;

            map.put(0,1);

            int result[] = new int[2];

            for(int i=0; i< arr.length;i++){
                sum += arr[i];
                int rem = sum%2;

                if (rem == 1) {
                    // Count how many times we encountered an even sum before this point
                    count = (count + map.getOrDefault(0, 0)) ;
                } else {
                    // If rem is even (0), we want to find how many times we had an odd sum before
                    count = (count + map.getOrDefault(1, 0)) ;
                }


                map.put(rem, map.getOrDefault(rem, 0) + 1);


            }
            return count;
        }
        public  static List<int[]> numOfSubarraysWithIndices(int[] arr) {

        int sum = 0;
        List<int[]> result = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

            // Initialize with even cumulative sum count at index -1 (before the start of the array)
            map.put(0, new ArrayList<>());
            map.get(0).add(-1);

            for(int i=0;i<arr.length;i++){
                sum += arr[i];
                int rem = sum%2;
                if(rem ==1){
                    List<Integer> evenInd = map.getOrDefault(0,new ArrayList<>());
                    for(int ind : evenInd){
                        result.add(new int[]{ind+1, i});
                    }
                } else {
                    List<Integer> oddInd = map.getOrDefault(1,new ArrayList<>());
                    for(int ind : oddInd){
                        result.add(new int[]{ind+1,i});
                    }
                }

                map.putIfAbsent(rem,new ArrayList<>());
                map.get(rem).add(i);
            }
            return result;

        }

}
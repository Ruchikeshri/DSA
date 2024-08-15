package com.company.HashTable;

import java.util.HashMap;
import java.util.Map;

public class SubArray {

    public static int subarraySums(int[] nums, int k) {

        int count = 0;

        Map <Integer, Integer> map = new HashMap <>();
//        int j=0;
//        for (int i = 0; i < nums.length; i++) {
//            j = (j >= nums.length) ? 0 : (j + 1);
//            if (j < nums.length) {
//                if (nums[i] + nums[j] == k)
//                    map.put(nums[i], 1);
//            }
//        }
//        count =  map.size();
//
//        return count;
//    }
        map.put(0,1);
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            if(map.containsKey(sum-k)){
                count+= map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
        }

    public static void main(String[] args) {
        SubArray sa = new SubArray();
        System.out.println();
        System.out.println("subarray count "+SubArray.subarraySums(new int[]{1,2,3},6));

    }
    }

package com.company.SlidingWindow;

import java.util.*;

public class SubarrayWithKDisticnt {

    public  static int subarraysWithKDistinct(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        int i=0,j =0,count=0;

        List<List<Integer>> result = new ArrayList<>();

        int start =0,end =0;

//        for(int l=0;l<nums.length;l++){
//            map.put(nums[l], map.getOrDefault(nums[l],0)+1);
//        }


        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);


            while(map.size() >k && (map.get(nums[i])!=0 || map.get(nums[j])!=0) ){


                map.put(nums[i], map.get(nums[i])-1);
                map.put(nums[j], map.get(nums[j])-1);

                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);

                } else if(map.get(nums[j]) ==0){
                    map.remove(nums[j]);
                }

                i++;
                j--;
            }
            if(map.size() == k) {
                result.add(Arrays.asList(i, j));
                System.out.println(result);
                count++;
            }
            j++;
        }
        return count;
    }
    public static int subarraysWithKDistinct2(int[] nums, int k) {
        // Subarrays with exactly k distinct = atMostK(nums, k) - atMostK(nums, k - 1)
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public  static int atMostK(int[] nums, int k) {
        int count =0;

        Map<Integer,Integer> map = new HashMap<>();

        int i=0,j=0;

        while (j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1 );

            while (map.size()>k){
                map.put(nums[i],map.get(nums[i])-1);

                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }

                count += j - i + 1;

            j++;
        }


        return count;
    }


    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct2(new int[]{1,2,1,2,3},2));
    }
}

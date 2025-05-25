package com.company.DynamicProgramming;

import java.util.*;

public class LIS {



    public static List<Integer> lengthOfLis(int nums[]){


        List<Integer> tails = new ArrayList<>();
        int n= nums.length;

        int parent[] = new int[n];
        int indicies[] = new int[n];

        Arrays.fill(parent,-1);
        for(int i=0;i<n;i++){
            int num = nums[i];

            int idx = Collections.binarySearch(tails,num);
            if(idx<0) idx=-(idx+1);

            if(idx == tails.size()){
                tails.add(num);
            } else {
                tails.set(idx,num);
            }
            indicies[idx]=i;
            if(idx>0) parent[i]=indicies[idx-1];
        }
        LinkedList<Integer> lis = new LinkedList<>();
        for(int i=indicies[tails.size()-1];i>=0;i=parent[i]){
                lis.addFirst(nums[i]);

        }
        return lis;
    }

    public static void main(String[] args) {
            System.out.println(lengthOfLis(new int[]{2, 3, 5, 7})); // Output: [2, 3, 5, 7]
            System.out.println(lengthOfLis(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // Output: [2, 3, 7, 18]
        }
}

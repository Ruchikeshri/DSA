package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        int currSum = 0;
        int start =0;
        List<Integer> list = new ArrayList<>();
        for(int end=0;end<arr.length;end++){
            currSum= currSum+ arr[end];

            while (currSum>s){
                currSum-= arr[start];
                start++;

            }
            if(currSum == s){
                list.add(start+1);
                list.add(end+1);
                return (ArrayList<Integer>) list;
            }
        }
        return (ArrayList<Integer>) list;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraySum(new int[]{1,2,3,7,5},5,12)
        );

    }
}
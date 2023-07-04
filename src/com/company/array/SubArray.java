package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class SubArray {

    public static int subarraySum(int[] nums, int k) {

        int count = 0;

        Map <Integer, Integer> map = new HashMap <>();
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            j = (j >= nums.length) ? 0 : (j + 1);
            if (j < nums.length) {
                if (nums[i] + nums[j] == k)
                    map.put(nums[i], 1);
            }
        }
        count =  map.size();

        return count;
    }
    }

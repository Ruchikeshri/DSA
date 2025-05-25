package com.company.array;

import java.util.Arrays;

public class ProductArryaExceptSelf {

        public static int[] productExceptSelf(int[] nums) {

            int[] result = new int[nums.length];
            int l=0;
                for(int i=0;i<nums.length;i++) {
                    int prod = 1;
                    for (int j = 0; j < nums.length; j++) {
                        if (j != i) {
                            prod *= nums[j];
                        }
                    }
                    result[l] = prod;
                    l++;
                }
            return result;
        }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}

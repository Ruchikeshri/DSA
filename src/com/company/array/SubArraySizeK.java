package com.company.array;

import java.util.Arrays;

public class SubArraySizeK {


    public  static void findAllKsubarray(int[] a, int k){

        for(int i=0;i<=a.length-k;i++){
            int[] result = new int[k];

            for (int j=0;j<k;j++){
                result[j] = a[i+j];
            }
            System.out.println(Arrays.toString(result));
        }


    }

    public static void main(String[] args){
    findAllKsubarray(new int[]{1,2,3,4,5},3);
    }
}

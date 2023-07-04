package com.company.array;

import java.util.Arrays;

public class ArraySorting {
    public static void sortAsc(int arr[]){

        int temp;
        for (int i=0;i<arr.length;i++){
        for (int j= i+1; j< arr.length; j++)
        {
            if(arr[i]>arr[j]){ // for desc use < comparison
                temp = arr[i];
                arr[i]= arr[j];
                arr[j]= temp;
            }
          }
        }
        System.out.println(Arrays.toString(arr));
    }

}

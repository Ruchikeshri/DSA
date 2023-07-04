package com.company.array;

public class MinArray {
    public int minArray( int arr[]){
        if(arr == null && arr.length ==0){
            throw new IllegalArgumentException("Invalid Input");
        }
        int min = arr[0];
        for(int i : arr){
            if(i<min){
                min = arr[i];
            }
        }
        return min;
    }
}


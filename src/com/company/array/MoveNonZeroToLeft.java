package com.company.array;

import java.util.Arrays;

public class MoveNonZeroToLeft {

    public static void moveNonZeroesToLeft(int arr[]){
        int nonZeroIndex =0;
        for(int i=0;i< arr.length;i++){
            if(arr[i]!=0){
                arr[nonZeroIndex] = arr[i];
               nonZeroIndex++;
            }
        }
        for(int i=nonZeroIndex;i< arr.length;i++){
            arr[i] =0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveNonZeroesToLeft(arr);
        System.out.println("Array after moving non-zero elements to the left: " + Arrays.toString(arr));
    }
    }


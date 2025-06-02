package com.company.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int arr[],int low, int high){
        if(low<high) {
            int partitionIndex = partitionUsingLastIndex(arr, low, high);
            quickSort(arr,low,partitionIndex-1);
            quickSort(arr,partitionIndex+1,high);
        }
    }

    private static int partitionUsingLastIndex(int[] arr, int low, int high) {
        int pivotIndex = high;
        int swapIndex = low-1;

        for(int i= low;i<high;i++){
            if(arr[i]<arr[pivotIndex]){
                swapIndex++;
                swap(arr,swapIndex,i);
            }
        }
        swap(arr,swapIndex+1, high);
        return swapIndex+1;
    }
//
//    private static int partition(int[] arr, int pivotIndex, int high) {
//        int swapIndex = pivotIndex;
//
//        for(int i=pivotIndex+1;i<= high;i++){
//            if(arr[i]<arr[pivotIndex]){
//                swapIndex++;
//                swap(arr,swapIndex,i);
//            }
//        }
//        swap(arr,pivotIndex,swapIndex);
//        return swapIndex;
//    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static void main(String[] args) {

        int myArray[] = {4,6,1,7,3,2,5};

//        int index = partition(myArray,0,myArray.length-1);
//        System.out.println(index);

        System.out.println(Arrays.toString(myArray));

        quickSort(myArray,0,myArray.length-1);

        System.out.println(Arrays.toString(myArray));


    }
}

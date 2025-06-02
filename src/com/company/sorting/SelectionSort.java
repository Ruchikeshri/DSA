package com.company.sorting;

public class SelectionSort {

    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minIndex =i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex =j;
                }
            }
            int temp = arr[i];
            arr[i] =arr[minIndex];
            arr[minIndex] = temp;
        }
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+ " ");
        }
    }

    public static void main(String[] args) {
       selectionSort(new int[]{4,2,6,5,1,3});
    }
}

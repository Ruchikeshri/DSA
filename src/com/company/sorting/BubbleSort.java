package com.company.sorting;

public class BubbleSort {

    public static void BubbleSort(int arr[]){

//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length-1-i;j++){
        for(int i= arr.length-1;i>=0;i--){
            for(int j =0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int k=0;k< arr.length;k++) {
            System.out.print(arr[k]+ " ");
        }
    }

    public static void main(String[] args) {
        BubbleSort(new int[]{2,5,4,1,0});
    }
}

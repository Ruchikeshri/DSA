package com.company.array;

public class ReverseArray {
    public static void reverseArray(int arr[],int start,int end){
        while (start<end){
            int temp = arr[start];
            arr[start]=arr[end];
             arr[end] = temp;
            start++;
            end--;

        }
        for (int i : arr){
            System.out.print( i+ " ");
        }


    }

    public static void reverse(int[] arr){
       int temp;
        for(int i =0;i< arr.length/2;i++){
           temp = arr[i];
           arr[i]= arr[arr.length-1-i];
           arr[arr.length-1-i] = temp;
        }

        for(int k:arr){
            System.out.print(k+" ");
        }
    }
}
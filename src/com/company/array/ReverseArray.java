package com.company.array;

import java.lang.reflect.Array;
import java.util.Arrays;

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

    public static <T> T[] reversArray(T[] array){
        for(int i=0, middle = array.length>>1, j=array.length-1 ; i<middle;i++,j--){
            T element = array[j];
            array[j] = array[i];
            array[i] = element;
        }
        return  array;
    }


    public static void reverse(int[] arr){
        System.out.println("Before Array"+ Arrays.toString(arr));
       int temp;
        for(int i =0;i< arr.length/2;i++){
           temp = arr[i];
           arr[i]= arr[arr.length-1-i];
           arr[arr.length-1-i] = temp;
        }
        System.out.println("reversed Array");

        for(int k:arr){
            System.out.print(k+" ");
        }
    }

    public boolean isPalin(String s){
        int start =0, end = s.length()-1;

        while (start< end){

            while(start<end && !Character.isAlphabetic(s.charAt(start))) start++;
            while(start<end && !Character.isAlphabetic(s.charAt(end))) end--;

            if(s.charAt(start)  != s.charAt(end)) return false;

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseArray().isPalin("MADA11M"));
    }
}

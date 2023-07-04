package com.company.array;

public class MissingNumber {

   public static int findMissingNumber(int arr[]){
       int sum=0;
       int n = arr.length+1;
       sum = n*(n+1)/2;
       for(int num: arr){
           sum = sum - num;
       }
       return sum;
   }
}

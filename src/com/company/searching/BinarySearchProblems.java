package com.company.searching;

public class BinarySearchProblems {

   public static int firstOccurence(int arr[], int target){
       int left =0,  right = arr.length-1;
       while (left<= right) {
           int mid = left + (right - left) / 2;

           if(arr[mid] == target){
               return mid;
           } else if(arr[mid]<target){
               left = mid +1;

           } else {
               right = mid-1;
           }
       }
        return -1;
   }
    public static void main(String[] args) {
        System.out.println(firstOccurence(new int[]{1,3,5,5,5,7,9},5));
    }
}

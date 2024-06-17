package com.company.DynamicProgramming;

public class FibTopDownApproach { //Optimal substructure - recursive with memoization

    public static int fib(int n,int arr[]){
        if(n<=1){
            return n;
        }
         if (arr[n]==0) {
             arr[n] = fib(n - 1, arr) +fib(n - 2, arr);
         }

         return arr[n];
    }


    public static void main(String[] args) {
        int n=5;
        int arr[]   = new int[n+1];
        System.out.println(fib(n,arr));

    }
}

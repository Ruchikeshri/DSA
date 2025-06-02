package com.company.DynamicProgramming;

import java.util.Arrays;

public class MCM {

    public  static  int matrixChain(int arr[],int i,int j){

        if(i == j) return 0;

        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int cost = arr[i-1]* arr[k]* arr[j] + matrixChain(arr, i, j)+
                    matrixChain(arr,k+1,j);
            min = Math.min(min,cost);
        }
        return min;
    }

    public  static int topDown(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return topDownMCM(arr,1,arr.length-1,dp);

    }
    public static  int topDownMCM(int arr[],int i, int j,int dp[][]){
        if(i==j) return  0;

        if(dp[i][j] !=-1) return  dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int cost = topDownMCM(arr,i,k,dp)
                    + topDownMCM(arr,k+1,j,dp)
                    + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min,cost);
        }
        return dp[i][j] = min;

    }

     public  static  int mcmTabulation(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        for(int len=2;len<n;len++){
            for(int i=1;i<n-len+1;i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    int cost = dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]* arr[j];
                    dp[i][j] = Math.min(dp[i][j],cost);
                }
            }
        }
        return dp[1][n-1];
     }
    public static void main(String[] args) {
        int arr[] ={10,20,30,40};
        System.out.println(mcmTabulation(arr));
    }
}

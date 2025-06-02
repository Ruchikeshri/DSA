package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnboundedKhapsack {

    public static int knapRecur(int weights[],int profit[], int n, int w){

        if(n==0 || w== 0) return 0;

        if(weights[n-1]<=w){
            return  Math.max(knapRecur(weights,profit,n-1,w),
                    profit[n-1]+knapRecur(weights,profit,n,w-weights[n-1]));
            } else {
              return   knapRecur(weights,profit,n-1,w);
            }
    }
    public static  int knapsack2D(int  weights[],int profit[], int n, int w){
        int dp[][] = new int[n+1][w+1];

        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return knapMemo2D(weights,profit,n,w,dp);
    }
    public static  int knapMemo2D( int weights[],int profit[], int n, int w,int dp[][]){
        if(n ==0 || w ==0) return 0;

        if(dp[n][w]!=-1) return dp[n][w];

        if(weights[n-1]<=w){
            return dp[n][w] = Math.max((profit[n-1]+ knapMemo2D(weights,profit,n,w-weights[n-1],dp)),
                    knapMemo2D(weights,profit,n-1,w,dp));
        }else{
           return dp[n][w] = knapMemo2D(weights,profit,n-1,w,dp);
        }
    }

    public static  int knapsackMap(int  weights[],int profit[], int n, int w){
        Map<String,Integer> map = new HashMap<>();
        return knapMemoMap(weights,profit,n,w,map);
    }
    public static  int knapMemoMap( int weights[],int profit[], int n, int w,Map<String,Integer> map){
        if(n ==0 || w ==0) return 0;

        String key = n + "|" + w;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int result;
        if(weights[n-1]<=w){
             result = Math.max((profit[n-1]+ knapMemoMap(weights,profit,n,w-weights[n-1],map)),
                    knapMemoMap(weights,profit,n-1,w,map));
        }else{
             result = knapMemoMap(weights,profit,n-1,w,map);
        }
        map.put(key,result);
        return result;
    }

    public static  int knapBottomUp( int  weights[],int profit[], int n, int w){
       int dp[][] = new int[n+1][w+1];

       for(int i=1;i<=n;i++){
           for(int j =1;j<=w;j++){
               if(weights[i-1]<=j){
                   dp[i][j] = Math.max(dp[i-1][j],profit[i-1]+dp[i][j-weights[i-1]]);
               } else {
                   dp[i][j] = dp[i-1][j];
               }
           }
       }
       return dp[n][w];
    }
    public static void main(String[] args) {
        int weights[] = {1,2,3,4};
        int profit[] = {2,5,7,8};

        int capacity = 5;
        System.out.println(knapRecur(weights,profit,weights.length,capacity));
        System.out.println(knapsack2D(weights,profit,weights.length,capacity));
        System.out.println(knapsackMap(weights,profit,weights.length,capacity));
        System.out.println(knapBottomUp(weights,profit,weights.length,capacity));

    }

}

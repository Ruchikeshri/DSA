package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinSubsetDiff {

    public  static int bruteForce(int nums[]){
        return minDifferenceRec(nums,nums.length,0,0);
    }

    public static int minDifferenceRec(int nums[], int n,int sum1,int sum2){
        if(n ==0 ){
            return Math.abs(sum1-sum2);
        }

        int incl = minDifferenceRec(nums,n-1,sum1+ nums[n-1],sum2);
        int excl = minDifferenceRec(nums,n-1,sum1,sum2+nums[n-1]);

        return Math.min(incl,excl);
    }


    public   int minDiff1(int nums[]){
        int totalSum=0;

        for(int num :nums){
            totalSum+= num;
        }

        int dp[][] = new int[nums.length+1][totalSum/2+1];

        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        int s1 = minDiffHelper(nums,nums.length,dp,totalSum/2);
        int s2 =  totalSum-s1;

        return Math.abs(s1-s2);
    }

    private  int minDiffHelper(int[] nums, int n, int[][] dp, int target) {
        if(n <=0 || target == 0 ) return 0;

        if(dp[n][target]!=-1) return dp[n][target];

        int excl = minDiffHelper(nums,n-1,dp,target);
        int incl =0;
        if(nums[n-1]<=target){
            incl = nums[n-1]+ minDiffHelper(nums,n-1,dp,target-nums[n-1]);
        }
        return  dp[n][target] = Math.max(excl,incl);
    }

    public static int minDiff2(List<Integer> nums){
        int totalSum = nums.stream().mapToInt(Integer::intValue).sum();

        int memo[][] = new int[nums.size()+1][totalSum+1];

        for(int row[] : memo){
            Arrays.fill(row,-1);
        }

        return minDiff2Helper(nums,nums.size(),0,totalSum,memo);
    }

    private static int minDiff2Helper(List<Integer> nums, int n, int sum1,int totalSum, int[][] memo) {
         if(n ==0){
             return Math.abs((totalSum-sum1)-sum1);
         }
        if (sum1 > totalSum) return Integer.MAX_VALUE;  // ✅ Prevent out-of-bounds access
        if(memo[n][sum1]!=-1) return memo[n][sum1];

         int incl = minDiff2Helper(nums,n-1,sum1+nums.get(n-1),totalSum,memo);

         int excl = minDiff2Helper(nums,n-1,sum1,totalSum,memo);
         return memo[n][sum1] = Math.min(incl,excl);
    }

     public static int minDiffMemo(int nums[]){
        return minDiffHelperMemo(nums,nums.length,0,0,new HashMap<>());
     }

    private static <K, V> int minDiffHelperMemo(int[] nums, int n, int sum1, int sum2, HashMap<String, Integer> map) {

        if( n== 0){
            return Math.abs(sum1-sum2);
        }

        String key = n + "|" + sum1;

        if(map.containsKey(key)) return (int) map.get(key);

        int incl = minDiffHelperMemo(nums,n-1,sum1+nums[n-1],sum2,map);
        int excl = minDiffHelperMemo(nums,n-1,sum1,sum2+ nums[n-1],map);

        int result = Math.min(incl,excl);
        map.put(key,result);

        return result;
    }

    public static int bottomup(int nums[]){
        int totalSum =0;

        for(int num: nums){
            totalSum+= num;
        }
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][totalSum/2+1];
        for(int i=0;i<=n;i++) dp[i][0] = true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=totalSum/2;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for(int s1 =0;s1<=totalSum/2;s1++){
            if(dp[n][s1]){
                int s2 = totalSum-s1;
                minDiff = Math.min(minDiff,s2-s1);
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int num[] = new int[]{1,6,11,5};
        System.out.println(bruteForce(num));
        System.out.println(new MinSubsetDiff().minDiff1(num));
        System.out.println(bottomup(num));
        System.out.println(minDiffMemo(num));
        System.out.println(minDiff2(Arrays.stream(num).boxed().toList()));


    }
   }

package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class LongestCommonSubSeq {

    public  static int lcsBrute(String s1,String s2, int i, int j){
        if(i==s1.length() || j == s2.length()) return 0;

        if(s1.charAt(i)== s2.charAt(j)){
            return 1+ lcsBrute(s1,s2,i+1,j+1);
        } else {
            return  Math.max(lcsBrute(s1,s2,i+1,j),
                    lcsBrute(s1,s2,i,j+1));
        }
    }

    public static int lcsTopDown2D(String s1,String s2, int i, int j){

        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }
        return lcsTopDown2DHelper(s1,s2,i,j,dp);

    }

    private static int lcsTopDown2DHelper(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length() || j == s2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1+ lcsTopDown2DHelper(s1,s2,i+1,j+1,dp);
        }else{
            return dp[i][j] = Math.max(lcsTopDown2DHelper(s1,s2,i+1,j,dp), lcsTopDown2DHelper(s1,s2,i,j+1,dp));
        }

    }

    public static int minDiffMemo(String s1,String s2, int i, int j) {
        HashMap<String,Integer> map = new HashMap<>();

        return minDiffMemoHelper(s1,s2,i,j,map);

    }

    private static int minDiffMemoHelper(String s1, String s2, int i, int j, HashMap<String, Integer> map) {
        if(i == s1.length() || j == s2.length()) return 0;
        String key = i + "|" +j;
        if(map.containsKey(key)) return map.get(key) ;
        int res;
        if(s1.charAt(i) == s2.charAt(j)){
            res=     1+ minDiffMemoHelper(s1,s2,i+1,j+1,map);
        }else{
            res = Math.max(minDiffMemoHelper(s1,s2,i+1,j,map), minDiffMemoHelper(s1,s2,i,j+1,map));
        }
        map.put(key,res);
        return res;
    }

    public static int lcsBottomUP(String s1, String s2, int i,int j){
        int dp [][] = new int[i+1][j+1];

        for(int m =i-1;m>=0;m--){
            for(int n = j-1;n>=0;n--){
                if(s1.charAt(m) == s2.charAt(n)){
                    dp[m][n] = 1+ dp[m+1][n+1];
                } else{
                    dp[m][n] = Math.max(dp[m+1][n],dp[m][n+1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(lcsBrute(s1,s2,0,0));

        System.out.println(lcsTopDown2D(s1,s2,0,0));

        System.out.println(minDiffMemo(s1,s2,0,0));

        System.out.println(lcsBottomUP(s1,s2,s1.length(),s2.length()));

    }
}

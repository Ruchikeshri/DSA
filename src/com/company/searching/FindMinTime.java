package com.company.searching;

import java.util.*;


public class FindMinTime {

    public  static  int findMinTime(String password,
                                    List<Integer> attackOrder,long m){


        int n = password.length();
        int low =1, high = n,answer =0;

        while (low<=high){
            int mid = (low+high)/2;


            boolean corrupted[] = new boolean[n];

            for(int i=0;i<mid;i++){
                corrupted[attackOrder.get(i)-1]= true;
            }

            long good =0;
            int i=0;
            while (i<n){
                if(corrupted[i]){
                    i++;
                    continue;
                }
                int j=i;
                while(j<n && !corrupted[j]) j++;

                int len = j-i;
                good+= (long) len*(len+1)/2;
                i =j;
            }

            long total = (long) n*(n+1)/2;

            long bad = total-good;

            if(bad>=m){
                answer= mid;
                high = mid-1;
            } else {
                low = mid+1;
            }


        }
        return answer;
    }

    public static void main(String[] args) {
        String password = "abcdefghi";
        List<Integer> attackOrder = Arrays.asList(3, 5, 1, 2, 9, 7, 8, 6, 4);
        long m = 15; // minimum bad substrings required

        int result = findMinTime(password, attackOrder, m);
        System.out.println("Minimum number of attacks needed: " + result);

        System.out.println(longestCommonPrefix(new String[]{"c","acc","ccc"}));
    }

    public  static String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        for(String str : strs){
            while (str.indexOf(prefix)==-1 && prefix.length()>=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }

            if(prefix.length() ==0) return "";
        }
        return prefix;
    }

}

package com.company.array;

import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FizzBuzz {

    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{100,200,2,1,3,4}));
      fizzBuzz(15);
    }

    public static void fizzBuzz(int n){

        List<Integer> div = new ArrayList<>();

        for(int i=2;i<n/2;i++){
            if(n%i == 0){
                div.add(i);
            }
        }

        Integer fizDiv = div.get(0);
        Integer buzDiv = div.get(1);

        for(int i=1;i<=n;i++){
            StringBuilder sb = new StringBuilder();
            if(fizDiv!= null && i%fizDiv ==0){
                sb.append("Fizz");
            }
            if(buzDiv!= null && i%buzDiv ==0){
                sb.append("Buzz");
            }
            System.out.println(sb.length()>0 ? sb : i );
        }
    }
        public static int longestConsecutive(int[] nums) {


            Set<Integer> set = new HashSet<>();
            int maxLength = 0;

            for(int num : nums){
                set.add(num);
            }


            for(int num : set){

                 if(!set.contains(num-1)) {
                   int currentNum = num;
                   int currentLength =1;

                     while(set.contains(currentNum+1)){
                         currentNum++;
                         currentLength++;
                     }
                     maxLength = Math.max(maxLength, currentLength);

                 }
            }
            return maxLength;
        }
    }


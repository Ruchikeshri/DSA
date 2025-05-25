package com.company.array;

import java.util.Arrays;

public class PairSongs {

        public int numPairsDivisibleBy60(int[] time) {
            int count =0;

            int remCount[] = new int[60];

            // for(int i=0;i<time.length;i++){

            //     int rem = time[i]%60;

            //     int complement =  (60-rem)%60;


            //     count+= remCount[complement];
            //     remCount[rem]++;

            // }
            Arrays.sort(time);
            int left =0,right = time.length-1;

            while(left<=right){
                int sum = (time[left] + time[right]);
                if(sum%60 ==0 ){
                    count++;
                    left++;
                    right--;
                } else if (sum%60 < 60){
                    left++;
                } else{
                    right--;
                }
            }

            return count;
        }

    public static void main(String[] args) {
        System.out.println(new PairSongs().numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }
    }


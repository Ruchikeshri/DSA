package com.company.array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    public static List<Boolean> kidsWithCandies(int candies[], int extraCandies){
        int maxCandies =0;
        List<Boolean> result = new ArrayList<>();
        for(int candy : candies){
            if(candy>maxCandies){
                maxCandies = candy;
            }
        }
        for(int i=0;i<candies.length;i++){
            result.add(candies[i]+extraCandies>=maxCandies);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{7,3,9,2,4},5));
    }
}

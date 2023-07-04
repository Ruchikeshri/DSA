package com.company.array;

public class CalculateFrequency {

    public static int countFreqCount(int n,int d){
        if(n==0) return 1;

        if(n<0) n=-n;

        int count=0;

        while(n != 0) {

                int dig = n%10;
                if(dig == d) count++;
                n=n/10;
            }
        return count;
    }

    public static void main(String[] args) {
       int n=  countFreqCount(67708,7);
        System.out.println(" The digit appears in "+ n +" times");
    }
}

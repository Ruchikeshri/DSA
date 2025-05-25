package com.company.SlidingWindow;

public class MaxAverage {

    public static double findMaxAvgBruteForce(int nums[], int k){
        double maxAvg =-Double.MAX_VALUE;
        for(int i=0;i<=nums.length-k;i++){
            double sum=0;
            for(int j=0;j<k;j++){
               sum+= nums[i+j];
            }
            double currentAvg= sum/k;
            maxAvg = Math.max(maxAvg,currentAvg);
        }
        return maxAvg;
    }

    public static double findMaxAverageSlidingWindow1(int[] nums, int k) {

        int j =0;
        double maxAvg=0,sum=0;
        for(int i=0;i<nums.length;i++){

            sum+= nums[i];
            if(i-j+1 == k){
                double currentAvg = sum/k;
                maxAvg = Math.max(maxAvg,currentAvg);
                sum= sum-nums[j];
                j++;
            }

        }
        return maxAvg;
    }


    public static  double maxAvgSlidingWindow2(int nums[], int k){
        double maxWindowAvg =Double.MIN_VALUE;
        double windowSum =0;
        for(int i =0;i<k;i++){
            windowSum+= nums[i];
        }
        double maxWindowSum = windowSum;
        // imp to ini here sum/ avg
        maxWindowAvg = windowSum/k;
        //first Approcah
        for(int i=0;i<nums.length-k;i++){
            windowSum= windowSum-nums[i] + nums[i+k];
            double currWindowAvg = windowSum/k;
            if(currWindowAvg >maxWindowAvg){
                maxWindowAvg = currWindowAvg;
            }
        }

        // second approach
//        for(int i=k;i<nums.length;i++){
//            windowSum = windowSum+nums[i]-nums[i-k];
//            double currWindowAvg = windowSum/k;
//            if(currWindowAvg>maxWindowAvg){
//                maxWindowAvg = currWindowAvg;
//            }
//            }
        return maxWindowAvg;
    }

    private static  double maxAvgUsingPrefix(int nums[], int k){
        double prefix[] = new double[nums.length+1];
        prefix[0] =0;
        double maxAvg =0;
        for(int i=1;i<=nums.length;i++){
            prefix[i] = prefix[i-1]+nums[i-1];
        }

        for(int i=0;i<=nums.length-k;i++){
            double currentAvg = (prefix[i+k] - prefix[i])/k;
            maxAvg = Math.max(currentAvg,maxAvg);
        }
        return  maxAvg;
    }
    public static void main(String[] args) {
//        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAvgBruteForce(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverageSlidingWindow1(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(maxAvgSlidingWindow2(new int[]{5},1));
        System.out.println(maxAvgUsingPrefix(new int[]{1,12,-5,-6,50,3},4));
    }
}

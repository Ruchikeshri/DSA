package com.company.array;

public class canCompleteCircuit {

    public static int canCompleteCircuitGreedy(int gas[], int cost[]){
        int totalGas=0,totalCost =0,currentGas=0,start=0;

        for(int i=0;i<gas.length;i++){
            totalCost+=cost[i];
            totalGas+=gas[i];
            currentGas+=gas[i] - cost[i];
           if(currentGas<0){
               start = i+1;
               currentGas =0;
           }
        }
        return totalGas>=totalCost ? start:-1;
    }


    public static int canCompleteBruteForce(int gas[], int cost[]){
        int n= gas.length;

        for(int start =0;start<n;start++){
            int currentGas=0;
            boolean canComplete = true;

            for(int i=0;i<n;i++){

                int index = (start+i)%n;

                currentGas+=gas[index];
                currentGas-=cost[index];

                if(currentGas<0){
                    canComplete = false;
                    break;
                }

            }
            if(canComplete){
                return start;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(canCompleteCircuitGreedy(new int[]
                {1,2,3,4,5},new int[]{
3,4,5,1,2}));
        System.out.println(canCompleteBruteForce(new int[]
                {1,2,3,4,5},new int[]{
                3,4,5,1,2}));
    }



}

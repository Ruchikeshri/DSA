package com.company.array;

public class FindSecondMax {

    public int findSecondMax(int arr[]){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i]>secondMax && arr[i]!=max){
                secondMax = arr[i];
            }
        }
    return secondMax;
    }

}

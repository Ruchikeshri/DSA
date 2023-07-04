package com.company.array;

public class RemoveEven {
    public  void removeEven(int[] arr){
        int ind =0;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] % 2 != 0) {
                ind++;
            }
        }
        int result[] = new int[ind];
//        for(int res : arr){
            int count=0;

            for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0) {
                result[count] = arr[i];
                count++;
            }
        }
            printArray(result);
        }

    public void printArray(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

}

package com.company.array;

public class NonRepatedElements {

public void nonRepatedElementArray(int arr[])
{
    for(int i =0;i<arr.length;i++){
        int count =0;
        for(int j=0;j< arr.length;j++){
            if(arr[i] == arr[j]){
                count++;
            }
        }
        if(count ==1){
            System.out.print(arr[i]+ " ");
        }
    }
}

    public void elementCountArray(int[] arr)
    {
        for(int i =0;i<arr.length;i++){
            int count =0;
            for(int j=0;j< arr.length;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
                else{
                    count =1;
                }
            }
//            if(count ==1){
                System.out.println(arr[i]+ " "+ " : " +count);
//            }
        }
    }
}

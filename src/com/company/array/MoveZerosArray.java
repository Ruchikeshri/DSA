package com.company.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveZerosArray {

    public void printArray(int arr[]){
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
    }
    public void moveZeros(int arr[]){
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 && arr[j]==0){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]= temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
//        for (int i=0;i<arr.length;i++)
            printArray(arr);
    }
//second approach
    public void moveZeros2(int arr[]) {
        LinkedList<Integer> list;
        Integer[] list1 = Arrays.stream(arr).boxed().toArray( Integer[]::new );
           LinkedList<Integer> list2 = Arrays.stream(list1)
                   .collect(Collectors.toCollection(LinkedList::new));
            int c=0;
        for(Integer val :new LinkedList<>(list2)) {
            if (val == 0) {
                c++;
                list2.remove(val);
                list2.addLast(0);
            }
        }
   Object[] movesZeroArr =list2.toArray();
        for(int i=0;i<movesZeroArr.length;i++){
            System.out.print(movesZeroArr[i]+ " ");
        }
        }
//    }
}

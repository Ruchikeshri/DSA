package com.company.array;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Scanner in = new Scanner(System.in);
//        int n= in.nextInt();
//        int[] arr = new int[n];
//
//        for(int i=0;i<n;i++){
//            arr[i]=in.nextInt();
//        }
        NonRepatedElements nonRepatedElements = new NonRepatedElements();
        nonRepatedElements.elementCountArray(new int[]{1,4,5,6,6,2,1,3,2});
        System.out.println("count example");
        nonRepatedElements.nonRepatedElementArray(new int[]{2,3,5,4,1,2,3});
        System.out.println();
        System.out.println("ASC");
        ArraySorting.sortAsc(new int[]{10,2,4,8,9,45});
        MoveZerosArray moveZerosArray = new MoveZerosArray();
        moveZerosArray.moveZeros(new int[]{1,6,0,1,0,0,1,0,1});
        System.out.println();
//        RemoveEven removeEven = new RemoveEven();
//        removeEven.removeEven(arr);
        FindSecondMax findSecondMax = new FindSecondMax();
//        System.out.print(findSecondMax.findSecondMax(arr));
        MinArray min = new MinArray();
//        System.out.println(min.minArray(new int[]{2, 4, 6, 8}));
        System.out.println();
        ReverseArray.reverseArray(new int[]{2,11,5,10,7,8},0,5);
        System.out.println();
        ReverseArray.reverse(new int[]{2,11,5,10,7,8});

        int[] originalArray = ResizeArray.resizeArray(new int[]{2,4,6,8},10);
//        System.out.println(originalArray.length);
        System.out.println();
        System.out.println(MissingNumber.findMissingNumber(new int[]{1,3,6,8,2,4,7}));
        ArrayChuncks arrayChuncks = new ArrayChuncks();
        List<int []> finalArray= arrayChuncks.divideArraySpecifiedSize(new int[]{1,2,3,4,5},2);
        finalArray.forEach(arrayChunck->System.out.print(Arrays.toString(arrayChunck)));
        SubArray sa = new SubArray();
        System.out.println();
        System.out.println(SubArray.subarraySum(new int[]{1,1,1},2));

    }

}

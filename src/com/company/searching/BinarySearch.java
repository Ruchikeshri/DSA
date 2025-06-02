package com.company.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static int binarySearch(int arr[],int target){
        int left=0,right = arr.length-1;

        while (left<=right){
            int mid = left+ (right-left)/2;

            if(arr[mid] == target) return mid;

            else if(arr[mid]<target){
                left = mid+1;
            } else {
                right =mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Object> arr = Arrays.asList(List.of(1, 2), 3, 4);
        List<List<Integer>> result = new ArrayList<>();

        for (Object i : arr) {
            if (i instanceof List) { // If it's already a List, cast safely
                result.add((List<Integer>) i);
            } else { // Otherwise, treat it as an Integer and wrap it in a list
                result.add(List.of((Integer) i));
            }
        }
        System.out.println(result.size());
        System.out.println(binarySearch(new int[]{1,2,3,5,6}, 5));
    }
}

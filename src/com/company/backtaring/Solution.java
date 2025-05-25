package com.company.backtaring;

import java.util.*;
public class Solution {
    public static List<List<Integer>> combSum(int[] ARR, int B) {
        // Write your code here.

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(ARR);

        backtrack1(ARR, 0, B, result, new ArrayList<>());

        return result;
    }

    public static void backtrack1(int arr[], int index, int b, List<List<Integer>> result,
                                  List<Integer> current) {

        if (b == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if ((i > 0 && arr[i] == arr[i - 1]) || arr[i] > b) continue;

            current.add(arr[i]);
            backtrack1(arr, i, b - arr[i], result, current);
            current.remove(current.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        //    Write your code here.

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.sort(arr);
        backtrack(arr, 0, n, target, result, new ArrayList<>());

        return result;
    }


    public static void backtrack(ArrayList<Integer> arr, int index, int n,
                                 int target, ArrayList<ArrayList<Integer>> result,
                                 ArrayList<Integer> current) {


        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < n; i++) {

            if (i > index && arr.get(i) == arr.get(i - 1)) continue;

            if (arr.get(i) > target) {
                break;
            }

            current.add(arr.get(i));
            backtrack(arr, i+ 1, n, target - arr.get(i), result, current);
            current.remove(current.size() - 1);

    }

}

    public static void main(String[] args) {
//        System.out.println(combSum(new int[]{2,3},5));
        System.out.println(combinationSum2(new ArrayList<Integer>(Arrays.asList(1,1,2)),3,3));
    }
}
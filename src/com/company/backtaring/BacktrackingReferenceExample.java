package com.company.backtaring;

import java.util.*;

public class BacktrackingReferenceExample {
//    public static void main(String[] args) {
//        List<Integer> path = new ArrayList<>();
//        backtrack(path, 1);
//    }

    private static void backtrack(List<Integer> path, int num) {
        if (num > 3) {
            System.out.println(path); // Print current path
            return;
        }

        path.add(num); // Modify list
        backtrack(path, num + 1); // Recursive call
        path.remove(path.size() - 1); // Backtrack (undo change)
    }


        private static Map<Integer, Integer> memo = new HashMap<>(); // Memoization table

        public static int fibonacci(int n) {
            if (n <= 1) return n; // Base case
            if (memo.containsKey(n)) return memo.get(n); // Use cached value

            // Recursively calculate and store result
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            memo.put(n, result);
            return result;
        }
        public static List<List<Integer>> combinationSum3(int k, int n) {

            List<List<Integer>> result = new ArrayList<>();

            backtrack(k,n,result,new ArrayList<>(),1);

            return result;
        }

        public static void backtrack(int k ,int n, List<List<Integer>> result,List<Integer>
                current,int index){


            if(n==0 && k==0){
                result.add(new ArrayList<>(current));
                return;
            }

            for(int i=index;i<=9;i++){
                current.add(i);
                backtrack(k-1,n-i,result,current,i+1);
                current.remove(current.size()-1);
            }
        }


        public static void main(String[] args) {
            System.out.println(combinationSum3(3,7)); // Output: 55
        }
    }



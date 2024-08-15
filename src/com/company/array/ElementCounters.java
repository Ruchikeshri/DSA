package com.company.array;

import java.util.Arrays;
//
//public class ElementCounter {
//    public static void main(String[] args) {
//        int[] array = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
//        Arrays.sort(array);  // Step 1: Sort the array
//
//        int count = 1;  // Step 2: Initialize count to 1 for the first element
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] == array[i - 1]) {  // Step 3: If the current element is the same as the previous one, increment count
//                count++;
//            } else {
//                System.out.println(array[i - 1] + ": " + count);  // Step 4: Print the count of the previous element
//                count = 1;  // Reset count for the new element
//            }
//        }
//        System.out.println(array[array.length - 1] + ": " + count);  // Step 5: Print the count of the last element
//    }


    public class ElementCounters {
        public static void main(String[] args) {
            int[] array = {2, 3, 3, 3, 2, 1, 4, 4, 4, 4};
            int n = array.length;

            for (int i = 0; i < n; i++) {
                array[array[i] % n] += n;
            }

            for (int i = 0; i < n; i++) {
                System.out.println(i + ": " + array[i] / n);
            }
        }
    }

//}

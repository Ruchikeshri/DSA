package com.company.array;

import java.sql.SQLOutput;
import java.util.Arrays;

public class PlusOne {

//
public static int[] plusOne(int[] digits) {
//    int len = digits.length - 1;
//
//    // Increment the last digit
//    digits[len] = digits[len] + 1;
//
//    // Handle carry from the last digit
//    for (int i = len; i >= 0; i--) {
//        if (digits[i] >9) { // If a digit becomes 10, handle carry
//            digits[i] = 0; // Set the current digit to 0
//            if (i - 1 >= 0) {
//                digits[i - 1] = digits[i - 1] + 1; // Increment the previous digit
//            }
//        }
//    }
//
//    // If the first digit is 0 and the carry resulted in needing an extra space
//    if (digits[0] == 0) {
//        // Create a new array with an extra leading 1 for cases like [9, 9, 9]
//        int[] result = new int[digits.length + 1];
//        result[0] = 1; // Set the first element to 1
//        return result;
//    }

    //BRUTE FORCE
            // Start from the last digit
            for (int i = digits.length - 1; i >= 0; i--) {
                // Increment the current digit by 1
                digits[i]++;

                // If the current digit is less than 10, no carry, return the array
                if (digits[i] < 10) {
                    return digits;
                }

                // If the current digit becomes 10, set it to 0 and continue the carry
                digits[i] = 0;
            }

            // If we reach here, it means all digits were 9 and have turned into 0.
            // We need to create a new array with an extra leading 1.
            int[] result = new int[digits.length + 1];
            result[0] = 1; // Set the leading digit to 1

            return result;
        }





public static int[] plusOneRecursive(int digits[], int index){
    if(index<0){
        int result[] = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
    if(digits[index]<9){
        digits[index]++;
        return digits;
    }
    digits[index] =0;
    return plusOneRecursive(digits,index-1);
}
//1. Best Approach (Iterative Backward with Carry Handling)
        public static int[] plusOneIterative(int[] digits){
       for(int i=digits.length-1;i>=0;i--) {
           digits[i]++;
           if (digits[i] <=9) {
               return digits;
           }
           digits[i] = 0;
       }
           int result[] = new int[digits.length+1];
           result[0] =1;

           return result;

}

    public static int[] plusOneManualCopy(int[] digits) {
        boolean needsExtraSpace = true;
        for (int digit : digits) {
            if (digit != 9) {
                needsExtraSpace = false;
                break;
            }
        }

        if (needsExtraSpace) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        return digits;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOneRecursive(new int[]{8, 9, 9, 9},3))); // Expected Output: [9, 0, 0, 0]
        System.out.println(Arrays.toString(plusOneRecursive(new int[]{9},0)));
        System.out.println(Arrays.toString(plusOne(new int[]{8, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOneIterative(new int[]{8, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOneManualCopy(new int[]{9})));
}


}

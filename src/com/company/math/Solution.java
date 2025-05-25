package com.company.math;

class Solution {
    public  static boolean isPalindrome(int x) {

        int rev = 0, n = x, rem = 0;

            while (n > 0) {
//                n = n/10;
                rem = n % 10;
                n  = n/10;
                rev = rev*10+rem;

            }



        if(rev == x){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));

    }
}
package com.company.string;




class SubSequence {

    public static boolean isSubsequence(String s, String t) {

        int start = 0;

        int i = 0;
        while(i<s.length() && start<t.length()) {
            if (s.charAt(i) == t.charAt(start)) {
                i++;
            }
            start++;
        }
        return i == s.length();


    }



    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequences("abc","ahbgdc"));
//        System.out.println(printNumbers(10));
        printNumbers(10);


    }

    public static int lengthOfLastWord(String s) {

        String splitStr[] = s.split("\\s+");


        String lastWord = splitStr[splitStr.length - 1];

        return lastWord.length();

    }





    public static boolean isSubsequences(String s, String t) {
        return isSubsequenceHelper(s,t,0,0);

    }

    public static boolean isSubsequenceHelper(String s, String t, int sIndex, int tIndex){
        if(sIndex == s.length()) return true;
        if(tIndex == t.length()) return false;

        if(s.charAt(sIndex) == t.charAt(tIndex)){
           return    isSubsequenceHelper(s,t,sIndex+1, tIndex+1);
        } else{
            return isSubsequenceHelper(s,t,sIndex,tIndex+1);
        }
    }
    public static void printNumbers(int n) {
        if (n == 0) return;  // Base case: stop when n reaches 0
        printNumbers(n - 1);  // Recursively print numbers from 1 to n-1
        System.out.println(n); // Print n after the recursive call
    }

}
package com.company.string;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PalindromeString palindromeString = new PalindromeString();
        System.out.println("str is plaindrome "+palindromeString.isPalindrome("madam"));
        System.out.println("string is palindrome: "+
                PalindromeString.removeSpecialChar("0p"));
        ReverseEachWord.reverseWordsString("This is Java");
        System.out.println();
      Anagram anagram = new Anagram();
        anagram.isAngaram2("book","boko");

//        anagram.anagram("keep","peek");
        ReverseString rs = new ReverseString();
        System.out.println(palindromeString.reverseWord("dcba"));
//
//        ValidSubsequence subsequence = new ValidSubsequence();
//        System.out.println(subsequence.isSubSeq("abcde","ace"));
//
//        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
//
//        System.out.println(FirstNonRepeatingCharacter.firstNonRepeatingCharacter("jjaava"));

//        System.out.println(FirstNonRepeatingCharacter.lengthOfLongestSubstring("jaavva"));
        System.out.println(FirstNonRepeatingCharacter.lengthOfLongestSubstring("pwwpkew"));

        CommonCharacter cmnCharacter = new CommonCharacter();
        Object[] cmnChar = cmnCharacter.commonCharacter("abcd", "bc").toArray();
        String s = Arrays.toString(cmnChar);
        System.out.println(s);
        System.out.println(cmnCharacter.cmnCharacter("abcd","bc"));
        System.out.println("Reversed String "+rs.reverseString("abcd"));
        System.out.println("Reverse String "+rs.reversedString("abcd"));
    }
}

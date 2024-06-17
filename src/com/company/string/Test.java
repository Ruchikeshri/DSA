package com.company.string;

import java.util.Arrays;

public class Test{
    public static void main(String[] args) {
        PalindromeString palindromeString = new PalindromeString();
        AddString.addString("11","123");
        LongestCommonPrefix cmn = new LongestCommonPrefix();
//        System.out.println(cmn.hasCommonPref(new String[]{"flow","flower","flew"}));
//         System.out.println("str is plaindrome "+palindromeString.isPalindrome("madam"));
        System.out.println("string is palindrome: "+
                PalindromeString.removeSpecialChar("0p"));
        ReverseEachWord.reverseWordsString("This is Java");
        System.out.println();
      Anagram anagram = new Anagram();
        anagram.anagram("book","boko");

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

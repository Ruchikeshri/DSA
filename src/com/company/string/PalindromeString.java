package com.company.string;

public class PalindromeString {

    public boolean isPalindrome(String str) {
        boolean isPalindrome = false;
        char[] c = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (c[start] != c[end]) {
                return false;

            }
            start++;
            end--;
        }
        return true;
    }

    public String reverseWord(String str) {
        String[] reverseStr = str.split(" ");
        String revWord = "";
        for (String splitWord : reverseStr) {
            for (int i = splitWord.length() - 1; i >= 0; i--) {
                revWord = revWord + splitWord.charAt(i);
            }
        }
        return revWord;
    }

    public static boolean isAlphaNumeric(char c){
        return c>= 'a' &&  c<='z' ||
                c>='A' && c<='Z' ||
                c>='0' && c<='9';
    }

    public static boolean removeSpecialChar(String str) {
        String s1 = str.replaceAll("\\s" ,"").toLowerCase();
        StringBuffer sb = new StringBuffer();
        char[] specialChar = new char[]{'@', '$', '&', '^', '#', '%', ':', ',','.','-','/','\"','[',']','{','}','\"','"'};
        String str1 = new String(specialChar);
        if(s1.length() <=1){
            return true;
        }
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(isAlphaNumeric(c)){
                sb.append(c);
            }

//            if (str1.indexOf(c) == -1) {
//               s1.replace(String.valueOf(c),"");
//                sb.append(c);
//                sb.deleteCharAt(i);
//            }
//            for(int j=0;j<specialChar.length; j++){
//                if(sb.charAt(i) == specialChar[j]){
//                    sb.deleteCharAt(i);
//                }
//            }
        }
        int start =0;
        int end = sb.length()-1;
        boolean flag =true;

        while (start< end){
            if(sb.charAt(start) != sb.charAt(end) ){
                flag = false;

            }
            start++;
            end--;
        }
        return flag;
    }

}


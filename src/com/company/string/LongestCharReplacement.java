package com.company.string;

public class LongestCharReplacement {

    public static int characterReplacement(String s, int k) {
        int lengthLongestsubstring = 0;
        int currentLength =1;
        int j =1;
        int replace = 0;
        if (j<=k){
        for(int i=1;i<s.length();i++) {

            if (s.charAt(i) != s.charAt(i - 1)) { //abab
                StringBuilder sb = new StringBuilder(s);
                while (replace < k && j < s.length()) {
                    if (sb.charAt(j) != sb.charAt(j - 1)) {
                        sb.setCharAt(j, sb.charAt(j - 1));
                        replace++;
                        currentLength++;
                    }
//                    currentLength++;
                    j++;
                }

            }else if(replace!=k){
                currentLength++;

        }
        }

        } else{
            currentLength = s.length();
        }
        lengthLongestsubstring = currentLength;

        return lengthLongestsubstring;

    }


//    public int  longestSubstring(String s){
//        int longestLength = 0;
//        int currenLength=1;
//        StringBuilder str =new StringBuilder();
//        for(int i=0; i< s.length()-1;i++){
//            if(s.charAt(i) == s.charAt(i+1)) {
//                currentlength++;
//            }else {
//                str.append(s.charAt(i));
//                longestLength = Math.max(longestLength,str.length());
//            }
//        }
//        return longestLength;
//    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AAAB",1));
    }
}

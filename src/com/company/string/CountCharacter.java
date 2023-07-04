package com.company.string;

public class CountCharacter {

    public  static int countChar(String str){
//        char c[] = str.toCharArray();
        int count =0;
//        for(int i=0;i<c.length;i++){
        //If space is there
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                count++;
            }
        }
//            count++;
//        }
//        return count;
       return str.length();
    }
    public static void main(String[] args) {
        System.out.println(countChar("Lordshiva"));
    }
}

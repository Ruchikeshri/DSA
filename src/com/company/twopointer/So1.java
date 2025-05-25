package com.company.twopointer;

class So1 {
    public static String convert(String s, int numRows) {
 
    int k=0;

    String str ="";

       while(k<=numRows){
       
        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            str+= c;


            
        }

       }
        return str;
    }

    public static void main(String[] args) {
        System.out.println( convert("PAYPALISHIRING",3));
    }
}
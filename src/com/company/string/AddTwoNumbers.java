package com.company.string;

public class AddTwoNumbers {
    public static  String addTwoStrings(String n1,String n2){
        int i = n1.length()-1;
        int j = n2.length() -1;
        int carry =0,sum=0;
        StringBuilder sb = new StringBuilder();

        while (i>=0 || j>=0){
            int dig1 = i>=0 ? n1.charAt(i) -'0' : 0;
            int dig2 = j>=0 ? n2.charAt(i)  -'0' : 0;
            sum = dig1+dig2+carry;
            carry = sum/10;
            sb.append(sum%10);
            i--;
            j--;
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(addTwoStrings("123", "456")); // Output: "579"
    }
}


package com.company.string;

public class GCDString {

    public static String gcdOfStrings(String str1, String str2) {

        if (!((str1 + str2).equals(str2 + str1))) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }
        public static int gcd(int length1, int length2){

            if(length2 ==0){
                return length1;
            }
            return gcd(length2, length1%length2);
        }


    public static void moveZeroes(int[] nums) {

        int index =0,count =0 ;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }

        for(int i=index;i< nums.length;i++){
            nums[i] =0;
        }
    for(int i=0;i<nums.length;i++){
        System.out.print(nums[i] + " ");
    }
    }
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB","ABAB"));
                moveZeroes(new int[]{0,1})
        ;
    }
}

package com.company.array;

import java.util.HashMap;

public class RomanToInt {
//1. Using HashMap and Single Pass (Current Approach)
    public static int romanToInt(String nums){


        HashMap<Character,Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum=0;
        for(int i=0;i<nums.length();i++){

            if(i<nums.length()-1 && map.get(nums.charAt(i))<map.get(nums.charAt(i+1))){
                sum-= map.get(nums.charAt(i));
            } else {
                sum+= map.get(nums.charAt(i));
            }
        }
        return  sum;
    }
//2. Using HashMap with Right-to-Left Traversal

        public static int romanToInt2nd(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int sum = map.get(s.charAt(s.length() - 1));  // Start with the last character
            for (int i = s.length() - 2; i >= 0; i--) {
                if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                    sum -= map.get(s.charAt(i));
                } else {
                    sum += map.get(s.charAt(i));
                }
            }
            return sum;
        }
//3. Using Switch-Case Without a Map
    public static int romanToInt3rd(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            if (i < s.length() - 1 && current < getValue(s.charAt(i + 1))) {
                sum -= current;
            } else {
                sum += current;
            }
        }
        return sum;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

//4. Using Arrays Instead of a Map
    public static int romanToIntUsingArray(String s) {
        char[] romanChars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = {1, 5, 10, 50, 100, 500, 1000};

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i), romanChars, values);
            if (i < s.length() - 1 && current < getValue(s.charAt(i + 1), romanChars, values)) {
                sum -= current;
            } else {
                sum += current;
            }
        }
        return sum;
    }

    private static int getValue(char c, char[] romanChars, int[] values) {
        for (int i = 0; i < romanChars.length; i++) {
            if (romanChars[i] == c) {
                return values[i];
            }
        }
        return 0;
    }
// 5. Using Two pointer
    public static int romanToInt2pointer(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int i = 0;

        while (i < s.length()) {
            int current = map.get(s.charAt(i));
            int next = i<s.length()-1 ? map.get(s.charAt(i + 1)):0;

            if (current < next) {
                sum += next - current;
                i+=2;
            } else {
                sum += current;
                i++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] testCases = {"III", "IV", "IX", "LVIII", "MCMXCIV", "MMXXIV", "CDXLIV"};

        // Iterate through each test case and print the result
        for (String s : testCases) {
            int result = romanToInt(s);
            int res = romanToInt2nd(s);
            int res2 = romanToInt3rd(s);
            int res3 = romanToIntUsingArray(s);
            int res4 = romanToInt2pointer(s);
//            System.out.println("Roman numeral: " + s + " -> Integer: " + result);
            System.out.println("Roman numeral: " + s + " -> Integer: " + res);
//            System.out.println("Roman numeral: " + s + " -> Integer: " + res2);
//            System.out.println("Roman numeral: " + s + " -> Integer: " + res3);
//            System.out.println("Roman numeral: " + s + " -> Integer: " + res4);


        }
    }
}

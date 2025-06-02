package com.company.string;

public class ZigZag {


    public String convert(String s, int numRows) {

        int currentRow = 0;
        boolean goingDown = false;

        if(numRows==1){
            return s;
        }

        StringBuilder rows[] = new StringBuilder[Math.min(numRows, s.length())];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            if (currentRow == 0 || currentRow == rows.length - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;

        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(new ZigZag().convert("PAYPALISHIRING",3));
    }
}

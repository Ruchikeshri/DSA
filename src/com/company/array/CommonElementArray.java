package com.company.array;

import java.util.*;

public class CommonElementArray {

    public static List<Integer> findCommonArray(int[] a, int[] b) {

        Set<Integer> commonElements = new HashSet<>();
        List<Integer> elem = new ArrayList<>();
        int res[] = new int[]{};
        for (int arr : a) {
            commonElements.add(arr);
        }
        for (int j = 0; j < b.length; j++) {
            boolean hs = commonElements.add(b[j]);
            if (hs == false) {
                elem.add(b[j]);
            }
        }
        return elem;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 5, 6};
        int b[] = {2, 4, 6};
        Object[] c = findCommonArray(a, b).toArray();

//       for(int r: c)
        System.out.print(Arrays.toString(c) + " ");
    }
}

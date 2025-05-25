package com.company.array;

import java.util.Arrays;

public class UnionTwoArray {

    public static int[] unionTwoArray(int arr1[], int arr2[]){
        int m = arr1.length;
        int n = arr2.length;

        int temp[] = new int[m+n];
        int i=0,j=0,k=0;

        while(i<m && j<n ){

            if(arr1[i]<arr2[j]){
                if(k ==0 || temp[k-1] != arr1[i]) {
                    temp[k] = arr1[i];
                }
                i++;
            } else if(arr1[i]> arr2[j]){
                if(k==0 || temp[k-1] != arr2[j]) {
                    temp[k] = arr2[j];
                }
                j++;
            }else{
                if(k ==0 || temp[k-1] != arr1[i]){
                    temp[k]= arr1[i];
                }
                i++;
                j++;

            }

            k++;
        }

        while(i<m){
            if(temp[k-1] != arr1[i]){
                temp[k++] = arr1[i++];
            }
        }

        while(j<n){
            if(temp[k-1] != arr2[j]){
                temp[k++] = arr2[j++];
            }
        }
//        return temp;
        return Arrays.copyOf(temp, k); // Resize to final size

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        int[] union = unionTwoArray(arr1, arr2);
        System.out.println(Arrays.toString(union)); // Output: [1, 2, 3, 4, 5, 6, 7]
    }
}

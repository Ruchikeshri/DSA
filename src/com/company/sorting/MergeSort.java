package com.company.sorting;

import java.util.Arrays;

import static com.company.sorting.MergeSort.sort2;

public class MergeSort {

    public static int[] mergeSort(int arr[]){

       if(arr.length == 1) return arr;
        int mid = arr.length/2;
        int left[] = Arrays.copyOfRange(arr,0,mid);
        int right[] = Arrays.copyOfRange(arr,mid,arr.length);


        left= mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);

    }

    private static int[] merge(int[] left, int[] right) {
      int[] result = new int[left.length+right.length];
      int i=0,j=0,k=0;
      while(i<left.length && j<right.length){
          if(left[i]<=right[j]) {
              result[k++] = left[i++];
          } else if(left[i]>right[j]){
              result[k++] = right[j++];
          }
      }
      while (i< left.length){
          result[k++] = left[i++];
      }

      while (j<right.length){
          result[k++] = right[j++];
      }
      return result;
    }


    public static void sort2(int arr[], int low, int high){
        int mid = low + (high-low)/2;

        if(low<high){
            sort2(arr,0,mid);
            sort2(arr,mid+1,high);
            merge2(arr,low,mid,high);
        }
    }

    private static void merge2(int[] arr, int low, int mid, int high) {
      int tem[] = new int[high-low+1];
      int i=low, j= mid+1,k=0;

      while (i<= mid && j<= high){
          if(arr[i]<arr[j]){
              tem[k++] = arr[i++];
          } else if(arr[i]>arr[j]){
              tem[k++] = arr[j++];
          }
      }
      while (i<=mid){
          tem[k++] = arr[i++];
      }

      for(int x=0;x<k;x++){
          arr[low+x] = tem[x];
      }
    }

    public static void main(String[] args) {

        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "Original Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );
          sort2(originalArray,0,originalArray.length-1);
        System.out.println( Arrays.toString(originalArray));
        /*
            EXPECTED OUTPUT:
            ----------------
            Original Array: [3, 1, 4, 2]

            Sorted Array: [1, 2, 3, 4]

         */

    }
}

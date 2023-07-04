package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayChuncks {

    public List<int[]> divideArraySpecifiedSize(int[] arr, int size){
      int len = arr.length;
      int k=0;
      List<int []> arrayChuncks = new ArrayList();
      int array[] = new int[]{};
      for(int i=0;i<arr.length;i++){
             if(k==0) {
                 array = new int[size];
             }
               array[k] = arr[i];
               k++;

          if(k>size-1) {
              k=0;
              arrayChuncks.add(array);
              len = len-size;
              if(len<size){
                  size = len;
              }
          }

      }

      return arrayChuncks;
    }

}

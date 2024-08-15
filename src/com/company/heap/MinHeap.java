package com.company.heap;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> minHeap;

    public MinHeap(){
        minHeap = new ArrayList<>();
    }

    private int leftIndex(int index){
        return 2*index+1;
    }

    private int rightIndex(int index){
      return 2*index+1;
    }

    private int parent(int index){
      return   (index-1)/2;
    }

    public void swap(int index1, int index2){
        int temp = minHeap.get(index1);
        minHeap.set(index1,minHeap.get(index2));
        minHeap.set(index2,temp);

    }

    public Integer remove(){
        if(minHeap.size() ==0) return  null;

        if(minHeap.size() ==1 ) return minHeap.remove(0);

        int heap = minHeap.get(0);
        minHeap.set(0,minHeap.remove(minHeap.size()-1));
        return heap;
    }

    public void sinkDown(int index) {

        int minIndex = index;

        while (true) {

            int leftIIndex = leftIndex(index);
            int rightIndex = rightIndex(index);

            if (leftIIndex < minHeap.size() && minHeap.get(leftIIndex)
                    < minHeap.get(index)) {
                minIndex = leftIIndex;
            }
            if (rightIndex < minHeap.size() && minHeap.get(rightIndex) <
                    minHeap.get(index)) {
                minIndex = rightIndex;
            }
            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;

            } else {
                return;
            }
        }

    }
    public void insert(int value){
        minHeap.add(value);

        int current = minHeap.size()-1;

        while(current>0 && minHeap.get(current)<minHeap.get(parent(current))){
            swap(current,parent(current));
            current = parent(current);
        }

    }


    private ArrayList<Integer> getHeap() {
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {


    MinHeap myHeap = new MinHeap();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);
        myHeap.insert(10);
        myHeap.insert(75);

        System.out.println(myHeap.getHeap());

    Integer removedValue1 = myHeap.remove();

        System.out.println("First Removed Value: " + removedValue1);
        System.out.println(myHeap.getHeap());

    Integer removedValue2 = myHeap.remove();

        System.out.println("Second Removed Value: " + removedValue2);
        System.out.println(myHeap.getHeap());

        /*
            EXPECTED OUTPUT:
            ----------------
            [10, 58, 72, 99, 61, 75]
            First Removed Value: 10
            [58, 61, 72, 99, 75]
            Second Removed Value: 58
            [61, 75, 72, 99]
        */

}


}

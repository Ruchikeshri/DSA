package com.company.heap;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a,b)-> b-a);
        rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        

        if(leftHeap.isEmpty() || num <=leftHeap.peek()){
            leftHeap.offer(num);
        } else{
            rightHeap.offer(num);
        }

        if(leftHeap.size() >rightHeap.size()+1){
            rightHeap.offer(leftHeap.poll());
        }else if(rightHeap.size()>leftHeap.size()){
            leftHeap.offer(rightHeap.poll());
        }
    }
    
    public double findMedian() {
        
        if(leftHeap.size() == rightHeap.size()){
            return (leftHeap.peek()+ rightHeap.peek())/2.0;
        } else{
            return leftHeap.peek();
        }
    }

    public  static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        System.out.println("Median after adding 1: " + medianFinder.findMedian()); // 1.0

        medianFinder.addNum(2);
        System.out.println("Median after adding 2: " + medianFinder.findMedian()); // 1.5

        medianFinder.addNum(3);
        System.out.println("Median after adding 3: " + medianFinder.findMedian()); // 2.0

        medianFinder.addNum(4);
        System.out.println("Median after adding 4: " + medianFinder.findMedian()); // 2.5

        medianFinder.addNum(5);
        System.out.println("Median after adding 5: " + medianFinder.findMedian()); // 3.0
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
package com.company.LinkedList;

import java.util.HashMap;
import java.util.Map;


/**
 * Definition for singly-linked list.
 **/
  public class ListNodeQuestions {
    private ListNode head;
    private int length;

     class ListNode{
        private ListNode next;
        private  int val;

        public ListNode(int val){
            this.val = val;
        }
    }

   public ListNodeQuestions(int val) {
        ListNode newNode = new ListNode(val);
        head = newNode;
        length=1;
    }




    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public  void append(int value){
        ListNode newNode = new ListNode(value);

        if(head == null){
            head = newNode;
        } else {
            ListNode current = head;
            while(current.next!= null){
                current = current.next;
            }
            current.next = newNode;
        }
        length++;



    }
    public ListNode oddEvenList(ListNode head) {
            ListNode dummyOdd = new ListNode(0);
           ListNode dummyEven = new ListNode(0);

            ListNode dummyOddPtr = dummyOdd;
            ListNode dummyEvenPtr = dummyEven;
             int index =1;

               while (head != null) {
                 if (index % 2 != 0) {
                     dummyOddPtr.next = head;
                     dummyOddPtr = dummyOddPtr.next;
                 } else {
                     dummyEvenPtr.next = head;
                     dummyEvenPtr = dummyEvenPtr.next;
                 }

                 head = head.next;
                 index++;
             }
                 // End the even list
             dummyEvenPtr.next = null;
             dummyOddPtr.next = dummyEven.next;
             return dummyOdd.next;

            // second approach without extra space
//            if (head == null) return null;
//            ListNode odd = head;
//            ListNode even = head.next;
//            ListNode evenHead = even;
//
//            while (even != null && even.next != null) {
//                odd.next = even.next;
//                odd = odd.next;
//                even.next = odd.next;
//                even = even.next;
//            }
//            odd.next = evenHead;
//            return head;
        }

        public ListNode deleteDuplicates(ListNode head) {


            ListNode current = head;

            if (head == null || head.next == null) {
                return head;
            }

            // Step 1: Count occurrences of each value
            Map<Integer, Integer> countMap = new HashMap<>();

            while (current != null) {
                countMap.put(current.val, countMap.getOrDefault(current.val, 0) + 1);
                current = current.next;
            }


            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;
            current = head;

            while(current!=null){

                while(current!=  null && countMap.get(current.val)>1){
                    current = current.next;
                }
                prev.next = current;
                if(current!= null) {
                    prev = prev.next;
                    current = current.next;
                }
            }
            return dummy.next;
        }
        public static void main(String[] args) {
            // Create the linked list 2 -> 1 -> 4 -> 3 -> 5
//            ListNodeQuestions node = new ListNodeQuestions(2);
//            node.append(1);
//            node.append(1);
//            node.append(4);
//            node.append(4);
////            head.next = new ListNode(1);
////            head.next.next = new ListNode(1);
//////            head.next.next.next = new ListNode(2);
////            head.next.next.next = new ListNode(5);
////            head.next.next.next.next = new ListNode(6);
//
//            // Instantiate the solution and call the oddEvenList method
//printList(node.head);
//            ListNode result = node.oddEvenList(node.head);
//            printList(result);
//
//            ListNode res = node.deleteDuplicates(node.head);
//
//            // Print the result
//            printList(res);

            ListNodeQuestions node = new ListNodeQuestions(2);
            node.append(1);
            node.append(1);
            node.append(4);
            node.append(4);

            System.out.println("Original List:");
            printList(node.head);

            // Call oddEvenList and print the result
//            ListNode oddEvenResult = node.oddEvenList(node.head);
//            System.out.println("Odd-Even Reordered List:");
//            printList(oddEvenResult);

            // Call deleteDuplicates and print the result
            ListNode noDuplicatesResult = node.deleteDuplicates(node.head);
            System.out.println("After Removing Duplicates:");
            printList(noDuplicatesResult);
        }

        // Helper method to print the linked list


}


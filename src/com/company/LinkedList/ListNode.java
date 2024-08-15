package com.company.LinkedList;

import static com.company.LinkedList.ListNode.printList;

/**
 * Definition for singly-linked list.
 **/
  public class ListNode {
    int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


    class Solution {
        public static  ListNode oddEvenList(ListNode head) {
            // ListNode dummyOdd = new ListNode(0);
            // ListNode dummyEven = new ListNode(0);

            // ListNode dummyOddPtr = dummyOdd;
            // ListNode dummyEvenPtr = dummyEven;
            // int index =1;

            //   while (head != null) {
            //     if (index % 2 != 0) {
            //         dummyOddPtr.next = head;
            //         dummyOddPtr = dummyOddPtr.next;
            //     } else {
            //         dummyEvenPtr.next = head;
            //         dummyEvenPtr = dummyEvenPtr.next;
            //     }

            //     head = head.next;
            //     index++;
            // }
            //     // End the even list
            // dummyEvenPtr.next = null;
            // dummyOddPtr.next = dummyEven.next;
            // return dummyOdd.next;

            // second approach without extra space
            if (head == null) return null;
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;

            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }

        public static void main(String[] args) {
            // Create the linked list 2 -> 1 -> 4 -> 3 -> 5
            ListNode head = new ListNode(2);
            head.next = new ListNode(1);
            head.next.next = new ListNode(4);
            head.next.next.next = new ListNode(3);
            head.next.next.next.next = new ListNode(5);

            // Instantiate the solution and call the oddEvenList method

            ListNode result = oddEvenList(head);

            // Print the result
            printList(result);
        }

        // Helper method to print the linked list


}
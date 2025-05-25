package com.company.LinkedList;

import org.w3c.dom.NodeList;

import java.util.List;

public class Solution {



//     * Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//        public ListNode reverseKGroup(ListNode head, int k) {
//
//            if(head == null) return null;
//
//            int length =0;
//
//            ListNode current = head;
//
//            while(current!= null){
//                current = current.next;
//                length++;
//            }
//
//            current = head;
//            int noOfRotations = length/k;
//            ListNode newHead = null;
//
//            ListNode nextNode = current.next;
//            ListNode prev = null;
//            ListNode after = null;
//            ListNode reversedGroup = null;
//            ListNode revRes= null;
//            ListNode rversedNode = null;
//            while(noOfRotations>0){
//
//                for(int i=0; i<k; i++){
//                    after = current.next;
//                    current.next = prev;
//                    prev = current;
//                    current = after;
//                }
//                noOfRotations--;
////                if(noOfRotations != 0) {
//                    reversedGroup = prev;
//                    rversedNode = prev;
//
////                }
//                while (rversedNode.next != null) {
//                    rversedNode = rversedNode.next;
//                }
//                if(noOfRotations==0) {
//                    while (revRes.next!= null) {
//                        revRes = revRes.next;
//                    }
//                    revRes.next = reversedGroup;
//
//                } else {
//                    revRes = prev;
//                }
//
//            }
//            return rversedNode;
//        }
//
//        public ListNode reverseList(ListNode head, int k){
//
//            ListNode prev = null;
//            ListNode after = null;
//            ListNode current = head;
//            int length =0;
//
//            for(int i=0; i<k; i++){
//                after = current.next;
//                current.next = prev;
//                prev = current;
//                current = after;
//            }
//            return prev;
//        }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Count the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Initialize variables for the reversing process
        current = head;
        ListNode newHead = null; // This will be the new head of the reversed list
        ListNode prevGroupEnd = null; // Tracks the end of the previous group
        int noOfRotations = length / k;

        while (noOfRotations > 0) {
            // Reverse the current group of size k
            ListNode groupStart = current; // Start of the group
            ListNode prev = null;
            ListNode next = null;

            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Now `prev` is the new head of the reversed group

            if (newHead == null) {
                // The first time, set newHead to the first reversed group
                newHead = prev;
            }

            if (prevGroupEnd != null) {
                // Connect the previous group's end to the current group's new head
                prevGroupEnd.next = prev;
            }

            // Move prevGroupEnd to the end of the current group
            prevGroupEnd = groupStart;

            noOfRotations--;
        }
        // Connect the last group to the remaining nodes (if there are any)
        prevGroupEnd.next = current;

        return newHead;
    }
    public static void main(String[] args) {
        Solution linkList = new Solution();
        ListNode node1 = linkList.new ListNode(1);
        ListNode node2 = linkList.new ListNode(2);
        ListNode node3 = linkList.new ListNode(3);
        ListNode node4 = linkList.new ListNode(4);
        ListNode node5 = linkList.new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        linkList.reverseKGroup(node1,2);


        Solution.ListNode newHead = linkList.reverseKGroup(node1, 2);

        // Print the reversed list
        Solution.ListNode current = newHead;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}


// 2-1-4-3-5
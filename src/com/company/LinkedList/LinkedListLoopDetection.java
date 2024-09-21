package com.company.LinkedList;

import java.util.HashSet;

class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListLoopDetection {

    // Method to detect a loop in the linked list
    public boolean hasLoop(Node head) {
        HashSet<Node> visitedNodes = new HashSet<>();
        Node current = head;

        while (current != null) {
            // If the current node is already in the set, a loop is detected
            if (visitedNodes.contains(current)) {
                return true;
            }
            // Add the current node to the set
            visitedNodes.add(current);
            current = current.next;
        }
        return false;
    }

    // Main method to test the hasLoop method
    public static void main(String[] args) {
        // Creating nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (loop back to 3)
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3; // Creating a loop back to node3

        // Creating an instance of the LinkedListLoopDetection class
        LinkedListLoopDetection list = new LinkedListLoopDetection();

        // Checking if the linked list has a loop
        // Creating an instance of the LinkedListLoopDetection class

        // Checking if the linked list has a loop
        if (list.hasLoop(node1)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
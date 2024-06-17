package com.company.LinkedList;

public class LinkedList {

    private Node head;
    private int length;

    public LinkedList(){

    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        length = 0;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // WRITE THE PARTITIONLIST METHOD HERE // 
    //                                     //
    //                                     //
    //                                     //
    //                                     //
    /////////////////////////////////////////
    
    public void partitionList(int x){
        Node lessDummy = new Node(0);
        Node greaterDummy = new Node(0);
        
        Node lessthanPtr = lessDummy;
        Node greaterthanPtr = greaterDummy;
        
        Node current = head;
        
        while(current!=null){
            if(current.value<x){
                lessthanPtr.next = current;
                lessthanPtr = lessthanPtr.next;
            } else {
                greaterthanPtr.next = current;
                greaterthanPtr = greaterthanPtr.next;
            }
            current = current.next;
        }
        greaterthanPtr.next = null;
        System.out.println("less than dummy");

        Node temp = greaterDummy;  // Start from the node after lessDummy
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        lessthanPtr.next = greaterDummy.next;

        head = lessDummy.next;
        
    }


    public static void main(String[] args) {

        // Create a new LinkedList and append values to it
        LinkedList ll = new LinkedList(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);

        // Print the list before partitioning
        System.out.println("LL before partitionList:");
        ll.printList(); // Output: 3 5 8 10 2 1

        // Call the partitionList method with x = 5
        ll.partitionList(5);

        // Print the list after partitioning
        System.out.println("LL after partitionList:");
        ll.printList(); // Output: 3 2 1 5 8 10

        /*
            EXPECTED OUTPUT:
            ----------------
            LL before partition_list:
            3
            5
            8
            10
            2
            1
            LL after partition_list:
            3
            2
            1
            5
            8
            10

        */

    }
}


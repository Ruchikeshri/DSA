package com.company.LinkedList;

public class LinkedListUsingUdemy {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedListUsingUdemy(int value) {
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
        if (length == 0) {
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

    // WRITE THE REVERSEBETWEEN METHOD HERE //
    //                                      //
    //                                      //
    //                                      //
    //                                      //
    //////////////////////////////////////////
    
    public void reverseBetween(int m, int n){
        
        // Node dummy = new Node(0);
        // dummy.next = head;
        // Node prevM = dummy;
        // Node temp = head;
        // Node start = temp;
        
        // if(head == null){
        //     return;
        // }
        // Node before = null;
        // Node after = null;
        // for(int i=0;i<m-1;i++){
        //     prevM = prevM.next;
        //     // temp = temp.next;
        // }
        // temp = prevM.next;
        // for(int i=m;i<=n;i++){
        //     after = temp.next;
        //     temp.next =before;
        //     before = temp;
        //     temp = after;
        // }
        //  prevM.next.next = temp;
        //  prevM.next=before;
          if (head == null || m >= n || m < 1) {
        return;
    }

    // Create a dummy node to handle edge cases
    Node dummy = new Node(0);
    dummy.next = head;
    Node prevM = dummy;

    // Move prevM to the node before position m
    for (int i = 1; i < m; i++) {
        if (prevM.next == null) {
            return; // Invalid position
        }
        prevM = prevM.next;
    }

    // Initialize pointers for reversing sublist
    Node current = prevM.next;
    Node prev = null;
    Node next = null;

    // Reverse the sublist from m to n
    for (int i = m; i <= n; i++) {
        if (current == null) {
            return; // Invalid position
        }
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    // Connect the reversed sublist back to the original list
    prevM.next.next = current; // Connect the end of reversed sublist to node after n
    prevM.next = prev; // Connect node before m to the start of reversed sublist

    if (m == 1) {
        head = prev; // Update head if reversing from the beginning
    }
               
    }
    public static void main(String[] args) {

        // Create a linked list with values 1, 2, 3, 4, and 5
        LinkedListUsingUdemy myLinkedList = new LinkedListUsingUdemy(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("Original linked list: ");
        myLinkedList.printList();

        // Reverse a sublist within the linked list
        myLinkedList.reverseBetween(1, 3);
        System.out.println("\nReversed sublist (1, 3): ");
        myLinkedList.printList();

        // Reverse another sublist within the linked list
        myLinkedList.reverseBetween(0, 4);
        System.out.println("\nReversed entire linked list: ");
        myLinkedList.printList();

        // Reverse a sublist of length 1 within the linked list
        myLinkedList.reverseBetween(2, 2);
        System.out.println("\nReversed sublist of length 1 (2, 2): ");
        myLinkedList.printList();

        // Reverse an empty linked list
        LinkedListUsingUdemy emptyList = new LinkedListUsingUdemy(0);
        emptyList.makeEmpty();
        emptyList.reverseBetween(0, 0);
        System.out.println("\nReversed empty linked list: ");
        emptyList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Original linked list:
            1
            2
            3
            4
            5

            Reversed sublist (1, 3):
            1
            4
            3
            2
            5

            Reversed entire linked list:
            5
            2
            3
            4
            1

            Reversed sublist of length 1 (2, 2):
            5
            2
            3
            4
            1

            Reversed empty linked list:

        */

    }

}
package com.company.LinkedList;

public class MergeTwoListNumbers {

    private Node head;
    private int length;

    public class Node{
        int value;
        Node next;

        public  Node(int value){
            this.value = value;
        }
    }
    public  MergeTwoListNumbers(){

    }
    public MergeTwoListNumbers(int value){
        Node newNode = new Node(value);
        head = newNode ;
        length =1;
    }


    public  Node MergeTwoListNumbers(Node a, Node b){
        Node dummy = new Node(0);
        Node tail = dummy;
        while(a!=null && b!=null) {
            if (a.value <= b.value) { // check if equals also
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
            if(a == null){
                tail.next = b;
            }else {
                tail.next = a;
            }
        }

        return dummy.next;

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

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeTwoListNumbers list1 = new MergeTwoListNumbers();
        list1.append(1);
        list1.append(3);
        list1.append(5);

        MergeTwoListNumbers list2 = new MergeTwoListNumbers();
        list2.append(2);
        list2.append(4);
        list2.append(6);

        System.out.println("List 1:");
        list1.printList();

        System.out.println("List 2:");
        list2.printList();

        MergeTwoListNumbers mergedList = new MergeTwoListNumbers();
        mergedList.head = mergedList.MergeTwoListNumbers(list1.head, list2.head);

        System.out.println("Merged List:");
        mergedList.printList();
    }
}


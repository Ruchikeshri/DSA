package com.company.LinkedList;

public class LinkedListForAddTwoNumbers {

    private Node head;
    private  int length;

    class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node addTwoNumbers(LinkedListForAddTwoNumbers l1,LinkedListForAddTwoNumbers l2 ){

        Node dummy = new Node(0);
        Node current = dummy;
        int carry =0;
        Node p = l1.head;
        Node q = l2.head;
        while(p!=null || q!=null){
            int x= p != null ? p.value : 0;
            int y = q !=null ? q.value :0;
            int dig = x+y+carry;
            carry = dig/10;
            current.next = new Node(dig%10);
            current = current.next;
             p = p != null ? p.next : null;
            q =  q!=null ? q.next : null;
        }
        if(carry>0){
            head.next = new Node(carry);
        }
        Node result = dummy.next;
        dummy.next=null;
        return  result;

    }
    public void addNode(int value) {
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

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListForAddTwoNumbers list1 = new LinkedListForAddTwoNumbers();
        LinkedListForAddTwoNumbers list2 = new LinkedListForAddTwoNumbers();

        // Adding nodes to the first list (e.g., 2 -> 4 -> 3 represents the number 342)
        list1.addNode(2);
        list1.addNode(4);
        list1.addNode(3);

        // Adding nodes to the second list (e.g., 5 -> 6 -> 4 represents the number 465)
        list2.addNode(5);
        list2.addNode(6);
        list2.addNode(4);

        // Adding the two numbers represented by the linked lists
        LinkedListForAddTwoNumbers result = new LinkedListForAddTwoNumbers();
        result.head = result.addTwoNumbers(list1, list2);

        // Printing the result (should represent the number 807, i.e., 7 -> 0 -> 8)
        result.printList();
    }
}


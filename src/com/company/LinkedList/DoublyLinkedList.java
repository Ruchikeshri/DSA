package com.company.LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode<T> {
        private T data;
        private ListNode previous;
        private ListNode next;

        public ListNode(T data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length =0;
    }

    public boolean isEmpty(){
        return length ==0;
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        } else{
            head.previous =newNode;
        }
        newNode.next= head;
        head = newNode;
    }
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        } else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public ListNode deleteFirst(){
        ListNode temp = head;

        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(head == tail){
            head = null;
        } else {
            head.next.previous =null;
        }

        head = head.next;
        temp.next = null;

        return temp;

    }
    public ListNode deleteLast(){
        ListNode temp = tail;
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(head == tail){
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
//      tail.next = null;
        temp.next = null;
        return temp;
    }

   public void displayForward(){
        ListNode temp = head;

        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
       System.out.print("null");
   }

   public void displayBackward(){
        ListNode temp = tail;

        while(temp!=null){
            System.out.print(temp.data+"--->");
            temp = temp.next;
        }
       System.out.print("null");
   }


    public static void main(String[] args) {
       DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
         doublyLinkedList.insertFirst(8);
         doublyLinkedList.insertFirst(9);
         doublyLinkedList.insertFirst(5);
         doublyLinkedList.insertFirst(2);
         doublyLinkedList.insertFirst(12);
         doublyLinkedList.insertLast(20);
         doublyLinkedList.insertLast(16);
         doublyLinkedList.insertLast(18);

//       doublyLinkedList
            doublyLinkedList.displayForward();
        System.out.println();
//      System.out.println(doublyLinkedList.deleteFirst().data);
        doublyLinkedList.displayForward();
        System.out.println();
        System.out.println(doublyLinkedList.deleteLast().data);

        doublyLinkedList.displayForward();

//            doublyLinkedList.d
    }
}

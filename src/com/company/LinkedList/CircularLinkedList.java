package com.company.LinkedList;

public class CircularLinkedList {

    public ListNode last;
    public int length;

    private class ListNode {
       private ListNode next;
       private int data;

       public ListNode(int data){
           this.data = data;
       }
    }
    public CircularLinkedList(){
        last = null;
        length=0;
    }
    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length ==0;
    }
    public void createCircularLinkedList(){
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;

        last = fourth;
    }
    public void circularStartingLinkedList(int node){
        ListNode temp = new ListNode(node);

//       if(last == null){
//
//        }


    }
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();
        cll.display();
    }

    public void display(){
        if(last==null){
            return;
        }
        ListNode first = last.next;
        ListNode temp =first;
        while (first!=last){
            System.out.print(first.data+"->");
            first = first.next;
        }
        System.out.print(first.data+"->"+temp.data);
    }


}

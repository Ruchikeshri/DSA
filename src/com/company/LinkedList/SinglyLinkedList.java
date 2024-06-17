package com.company.LinkedList;

public class SinglyLinkedList {

    private static ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
            return ;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }


       private void display() {
        ListNode current = head;

        while (current != null){
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

      private static void display(ListNode data) {
        ListNode current = data;

        while (current != null){
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.print("null");
    }

      public void insertAtPos(int position, int value){
        ListNode node = new ListNode(value);
        if(position ==1 ){
            node.next = head;
            head = node;
        }  else {
            ListNode previous = head;
            int count=1;

            while(count < position -1) {
              previous=previous.next;
              count++;
            }
            ListNode current = previous.next;
            node.next = current;
            previous.next = node;
        }
      }
      public  ListNode deleteLast(){
        if(head == null){
            return null;
        }
        ListNode node = head;
        ListNode prev = node.next;
        while (node.next !=null){
            prev = node;
            node = node.next;
        }
        prev.next = null;
        return node;
      }

      public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode node = head;
        head = head.next;
        node.next = null;
        return node;
      }

      public ListNode deleteAtPos(int position){
        if(position == 1){
            head.next = null;
            return null;
        } else {
            ListNode previous = head;
            int count =1;

            while(count <position-1) {
             previous = previous.next;
             count++;
            }
            ListNode current = previous.next;
            previous.next =current.next;
            current.next = null;
        }
            return null;
      }

      public void removeKey(int key){
      ListNode current = head;
      ListNode temp = null;
      while (current!=null && current.data!= key){
          temp = current;
          current = current.next;
      }
      if(current == null) return;
      temp.next = current.next;
      }

      public void insertInSortedList(int val){
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        ListNode temp = null;
        while(cur!= null && cur.data< newNode.data){
            temp = cur;
            cur = cur.next;
        }
        newNode.next = cur;
        temp.next = newNode;
      }

      public void removeDuplicateFromLl(){
        ListNode current = head;
        ListNode prev = null;
        while (current!=null && current.next!= null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
      }
      public boolean find(ListNode node,int searchKey){
        ListNode current =   node;
        while (current!= null){
          if(current.data == searchKey){
            return true;
        }
        current = current.next;
        }
        return false;
      }

      public ListNode reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current!= null){
         next = current.next;
         current.next = prev;
         prev = current;
         current = next;
      }
        return prev;
      }

      public ListNode rverseLinkList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        //1 2 3
//          null<-1<-2<-3

        while(current  != null){
            next = current.next;
            current.next =prev;
            prev = current;
            current = next;
          }

        return prev;
      }

     public ListNode findMiddleNode(){

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr!=null  && fastPtr.next!= null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode findNthNode(int n){
        int count=0;
        ListNode slowPtr = head;
        ListNode fasPtr = head;
        while(count<n) {
            slowPtr = slowPtr.next;
            count++;
        }
        while (slowPtr!=null){
            slowPtr = slowPtr.next;
            fasPtr = fasPtr.next;
        }
        return fasPtr;
    }

    public boolean detectLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while ( fastPtr !=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            boolean flag = false;

            if(slowPtr==fastPtr){
                ListNode startingNode = findStartingNode(slowPtr);
                ListNode removeStartingLoop = removeLoop(slowPtr);
                System.out.println();
//                display();
//                System.out.println();
                System.out.println(startingNode.data);
                return true;
            }
        }


        return  false;
    }

    private ListNode removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while (temp.next != slowPtr.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next= null;
        return temp;
    }

    private ListNode findStartingNode(ListNode slowPtr) {
        ListNode temp =head;
        while (temp!=slowPtr){
            temp = temp.next;
            slowPtr=slowPtr.next;
        }
        return temp;
    }


    public static ListNode mergeTwoList(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a!= null && b!=null){
            if(a.data<=b.data){
                tail.next =a;
                a = a.next;
            }else{
                tail.next=b;
                b=b.next;
            }
            tail = tail.next;
        }
        if(a==null){
            tail.next =b;
        } else {
            tail.next = a;
        }
        return dummy.next;
    }

    public  void insertNode(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        ListNode head = new ListNode(1);
//        ListNode second = new ListNode(2);
//        ListNode third = new ListNode(3);
//        ListNode fourth = new ListNode(4);
//        ListNode fifth = new ListNode(5);
//        ListNode sixth = new ListNode(6);
//
////        head = first;
//        head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;
//        fifth.next=sixth;
//        sixth.next=third;


        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(1);
        sll1.insertLast(4);
        sll1.insertLast(8);

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertLast(3);
        sll2.insertLast(6);
        sll2.insertLast(8);

        sll1.display();
        sll2.display();

        SinglyLinkedList result = new SinglyLinkedList();
//        result.head = mergeTwoList(sll1.head,sll2.head);
        result.display();

//        display();
//        display();

//        System.out.println(sll.detectLoop());
//        display();

//        sll.insertNode(14);
//        sll.insertLast(90);
//        sll.insertLast(12);
//        sll.insertNode(46);
//        sll.insertNode(80);
//        sll.insertAtPos(2,5);
//        sll.insertAtPos(2,6);
//        display();
//        System.out.println();
//        System.out.println("--------------------------------");
//
        ListNode middleNode = sll.findMiddleNode();
//        System.out.println(sll.detectLoop());
//        System.out.println(sll.findNthNode(2).data);
        display(middleNode);
//        System.out.println(middleNode.data);
//        System.out.println();
        sll.deleteLast();
        System.out.println();
//        System.out.println(sll.deleteFirst().data);
//        sll.deleteFirst();
//        display();
//        System.out.println();
////        sll.deleteAtPos(3);
//        display();
//        System.out.println();
//        sll.removeKey(20);
//        sll.insertInSortedList(14);
//        display();
//        sll.removeDuplicateFromLl();
//        System.out.println();
//        display();
//        sll.find(head,10);
//        System.out.println();
//        System.out.println(sll.findMiddleNode().data);
//
        System.out.println();
        ListNode reverseList = sll.reverseLinkedList(sll2.head);
        display(reverseList);
//        System.out.println();
    }


}

package com.company.LinkedList;


    public class LinkedListNode {

        private ListNode head;
       private int length;

        class ListNode {
            int value;
            ListNode next;

            ListNode(int value) {
                this.value = value;
            }

        }

        public LinkedListNode(int value) {
             head = new ListNode(value);
            length = 1;
        }

        public void append(int value) {
            ListNode newNode = new ListNode(value);

            if (length == 0) {
                head = newNode;
            } else {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;

            }
            length++;
        }

        private void printList() {
            ListNode current = head;
            while(current!=null){
                System.out.print(current.value+"->");
                current = current.next;
            }
            System.out.println();
        }
        public ListNode RotateList(ListNode head, int k) {

            if (head == null || k == 0 || head.next == null) {
                return head;
            }

            ListNode current = head;

            int length = 1;
            while (current.next != null) {
                current = current.next;
                length++;
            }

            k = k % length;
            if(k==0){
                return head;
            }
            ListNode newTail = head;
            for (int i = 1; i < length - k; i++) {
                newTail = newTail.next;
            }
            ListNode newHead = newTail.next;
            newTail.next = null;
            current.next = head;

            return newHead;


        }



        public static void main(String[] args) {
            LinkedListNode myLinkedList = new LinkedListNode(1);
            myLinkedList.append(2);
            myLinkedList.append(3);
            myLinkedList.append(4);
            myLinkedList.append(5);


            System.out.println("Before Rotate");
            myLinkedList.printList();

            System.out.println("After Rotate");
          myLinkedList.head =  myLinkedList.RotateList(myLinkedList.head,2);
            myLinkedList.printList();
        }


    }

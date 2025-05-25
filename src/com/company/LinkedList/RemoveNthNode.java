package com.company.LinkedList;



public class RemoveNthNode {
    private  ListNode head;
    private int length;
   
//     * Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {
              
          }
         public ListNode(int val) {
              this.val = val;
          }
          ListNode(int val, ListNode next) { 
              this.val = val; this.next = next;
          }
      }
      
      public void append(int val){
          ListNode node = new ListNode(val);
          if(head == null){
              head = node;
              length++;
          } else{
              ListNode current = head;
              while (current.next!=null){
                  current = current.next;
              }
              current.next = node;
              length++;
          }
      }

    public  void printList(ListNode head) {
       ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("null");
    }
     
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode fastPtr = head;

            ListNode slowPtr = head;
            ListNode after = null;

            int count =0;

            while(count<n){
                if(fastPtr== null) return null;
                fastPtr = fastPtr.next;
                count++;
            }
            if(fastPtr == null) return head.next;

            while(fastPtr != null){
                slowPtr = slowPtr.next;
                after = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            if(slowPtr!= null){
                slowPtr.next = after.next;
            }else {
                slowPtr = after;
            }

            return head;


        }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 using append method
       RemoveNthNode node = new RemoveNthNode();
        node.append(2);
//        node.append(3);
//        node.append(4);
//        node.append(5);

        // Set k
        int k = 1;

      ListNode res =   node.removeNthFromEnd(node.head, k);

        node.printList(res);

        // Rotate the list
    }
    }


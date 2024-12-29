package com.company.twopointer;


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next)
    { this.val = val; this.next = next; }

    // Append method to add a new node at the end
    public void append(int val) {
        ListNode end = new ListNode(val);
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
public class RotateList {

    public ListNode rotateListRight(ListNode head, int k){
        if(head == null || k == 0 || head.next ==null)
        {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        int length =1;
        // Step 1: Find the length of the list

        while(fast.next!=null){
            fast = fast.next;
            length++;
        }
        // Step 2: Normalize k

        k = k%length;
        if(k==0){
            return head;
        }
        // Step 3: Move fast pointer to the kth node from the end

        fast = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        // Step 4: Move both pointers until fast reaches the end

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // Step 5: Perform the rotation

        ListNode newHead = slow.next;// New head is next of slow
        slow.next = null;// Break the list
        fast.next = head;// Connect the end to the original head
        return newHead;
    }

    //EFFECTIVE ROATION WITH MODULO
    public ListNode rotateRight(ListNode head, int k) {
            if(head == null ) return null;

            ListNode current = head;
            int length=1;
        // Step 2: Calculate effective rotations
            while(current.next!= null){
                current = current.next;
                length++;
            }

            k = k%length;

            if(k ==0 ) return head;
//       -----------------------------------------------------------

        //when start with 0
//       ListNode currentNode = head;
//int length = 0;
//ListNode lastNode = null; // To store the last node before currentNode becomes null
//
//while (currentNode != null) {
//    lastNode = currentNode;  // Store the current node as the last node before moving forward
//    currentNode = currentNode.next; // Move to the next node
//    length++;  // Count each node, including the last one
//}
//
//// After the loop, currentNode is null and lastNode is the actual last node
//lastNode.next = head;  // Connect the last node back to the head to form the cycle
//
//       --------------------------------------------------------------

        // Connect the last node to the head to form a cycle

        // make cyclic list
            current.next = head;

        // Move to the node that will become the new tail
        current = head;


           for(int i=1;i<length-k;i++){
                current = current.next;
            }
        // Break the cycle and set the new head

           ListNode newHead = current.next;
           current.next = null;

           return newHead;

        }

        //Brute force
    public ListNode RotateRightBruteForce(ListNode head, int k){

        if(head == null || k ==0 || head.next== null) return null;

        ListNode current= head;
        int length=1;

        while (current.next!= null){
            current = current.next;
            length++;
        }

        for(int i=0;i<k;i++){

            ListNode fastPtr = head;

            ListNode prev = null;


            while (fastPtr.next!= null){
                prev =fastPtr;
                fastPtr = fastPtr.next;
            }

            prev.next = null;
            fastPtr.next = head;
            head = fastPtr;


        }


        return head;


    }
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 using append method
        ListNode head = new ListNode(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);

        // Set k
        int k = 2;

        // Rotate the list
        RotateList rotateList = new RotateList();
        ListNode newHead = rotateList.rotateListRight(head, k);
//        ListNode newH = rotateList.rotateRight(head,k);

//        ListNode res = rotateList.RotateRightBruteForce(head,k);
//
//        ListNode.printList(res);

        // Print the rotated list
        ListNode.printList(newHead);
//        ListNode.printList(newH);
    }

}

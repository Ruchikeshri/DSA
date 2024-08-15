package com.company.twopointer;


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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

        // Print the rotated list
        ListNode.printList(newHead);
    }

}

package com.company.LinkedList;

import com.sun.source.tree.Tree;

import javax.xml.transform.stax.StAXResult;
import java.util.Stack;

public class SolutionLinkedList {

    private TreeNode root;

    class TreeNode {
        TreeNode left;
        TreeNode right;
//        TreeNode prev;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }

//    public void convertBSTLinkedList(TreeNode root){
//
//        Stack<TreeNode> stack = new Stack<>();
//
//        TreeNode current = root;
//        TreeNode prevPtr = null;
//
//        while(!stack.isEmpty() || current!= null ) {
//
//            while(current!=null) {
//                stack.push(current);
//                current = current.left;
//            }
//            TreeNode curr = stack.pop();
//            if (curr != null) {
//                curr.left = null;
//            }
//            if (curr != null) {
//                curr.prev = prevPtr;
//                if(!stack.isEmpty()) {
//                    curr.right = stack.peek();
//                }
//            }
//            prevPtr = curr;
//
//
//            current = curr.right;
//
//        }
//    }
     TreeNode previous = null;
     TreeNode next = null;
     TreeNode head = null;
    public TreeNode convertBSTLinkedList(TreeNode root) {

        if(root == null) return  null;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        TreeNode prevPtr = null;
        TreeNode head = null;

        while(!stack.isEmpty() || current!= null){

            while (current!= null){
               stack.push(current);
               current = current.left;
            }
            TreeNode curr = stack.pop();

            if(head == null){
                head = curr;
            }

            if(prevPtr!=null){
                prevPtr.right = curr;
                curr.left = prevPtr;
            }
            prevPtr = curr;

            current = curr.right;

        }
        return head;

//        if (root == null) return null;
//
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root;
//        TreeNode prevPtr = null;
//        TreeNode head = null;  // To store the head of the linked list
//
//        while (!stack.isEmpty() || current != null) {
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//
//            TreeNode curr = stack.pop();
//
//            // Set head if it's the first node processed
//            if (head == null) {
//                head = curr;
//            }
//
//            // Set the previous pointer
//            curr.prev = prevPtr;
//
//            // Set the right pointer
//            if (prevPtr != null) {
//                prevPtr.right = curr;
//            }
//
//            // Move previous pointer forward
//            prevPtr = curr;
//
//            // Move to the right subtree
//            current = curr.right;
//        }
//
//        return head; // Return the leftmost node as the new head of the linked list
    }

    public void printTreeNode(TreeNode node) {
        TreeNode current = node;

        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.right;
        }
        System.out.println("null");
    }

    public TreeNode convertRecur(TreeNode root){
        if(root == null  ) return root;

        convertRecur(root.left);
        if(head == null){
            head = root;
        } else{

            previous.right = root;
            root.left = previous;
        }
        previous = root;
        convertRecur(root.right);
        return  head;
    }

    public static void main(String[] args) {
        SolutionLinkedList sol = new SolutionLinkedList();
        sol.root = sol.new TreeNode(1);
        sol.root.left = sol.new TreeNode(2);
        sol.root.right = sol.new TreeNode(3);
        sol.root.left.left = sol.new TreeNode(4);
        sol.previous = null;  // Reset previous pointer
        sol.head = null;
        // Get the head of the linked list
//        TreeNode head = sol.convertBSTLinkedList(sol.root);
        TreeNode head2 = sol.convertRecur(sol.root);


        // Print the linked list from the head
//        sol.printTreeNode(head);
        sol.printTreeNode(head2);

    }

    //1
//    /  \
//    2    3
//    /
//    4
}

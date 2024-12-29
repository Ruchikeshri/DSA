package com.company.tree;


import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
//        second.right = fifth;

    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public void preOrderIterative(){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.data);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left!= null){
                stack.push(temp.left);
            }
        }
    }

    public  void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(TreeNode root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");

    }

    public void inOrderIterative() {


        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }


        }
    }
        public void postOrderIterative(){
            TreeNode current = root;
            Stack<TreeNode> stack = new Stack<>();
                                                                                                                                             
            while (current != null || !stack.isEmpty()){
                if(current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    // right traversal
                    TreeNode temp = stack.peek().right;
                    if(temp == null){
                        temp = stack.pop();
                        System.out.println(temp.data);

                        // if parent.right == just popped right then pop parent
                        // for back traverse
                        while (!stack.isEmpty() && temp == stack.peek()
                                .right) {
                            temp = stack.pop();
                            System.out.println(temp.data);
                        }

                    } else {
                        // move temp = current for next node left and right traversal
                        current = temp;

                    }
                }
            }

        }

   public  boolean isValidBst(TreeNode node, long min,long max){
        if(root == null){
            return  true;
        }
        if(node.data<= min || node.data>=max){
            return false;
        }
        boolean left = isValidBst(node.left,min,node.data);
        if(left){
            boolean right = isValidBst(node.right,node.data,max);
                return right;
            }

        return false;
   }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.preOrder(bt.root);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
        bt.preOrderIterative();

        bt.inOrder(bt.root);
        bt.inOrderIterative();

        bt.postOrder(bt.root);
        bt.postOrderIterative();

        boolean isValid = bt.isValidBst(bt.root, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("Is Valid BST: " + isValid);
    }


}

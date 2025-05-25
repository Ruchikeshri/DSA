package com.company.tree;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeQuestions {

    private TreeNode root;
    private Integer prev = null;
    private int count =0;
    boolean found = false;
    private int result =-1;

    private int max = Integer.MIN_VALUE;

    private class TreeNode{
      private TreeNode left;
      private TreeNode right;
      private int val;

      TreeNode(int val){
          this.val = val;
      }
    }

    private int getMinDifference(TreeNode root){
        TreeNode current = root;
        int minDiff = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;

        while (!stack.isEmpty() || current!= null){
            while (current!= null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(prev!= null){
                minDiff = Math.min(minDiff,current.val- prev);
            }
            prev = current.val;
            current = current.right;
        }

        return minDiff;
    }

    public int getMinDiffRecursive(TreeNode root){
         prev = null;
         int minDiff = Integer.MAX_VALUE;

         minDiff =inorder(root,minDiff);
         return minDiff;
    }

    private int inorder(TreeNode node,int minDiff) {

        if(node == null) return minDiff;

        minDiff = inorder(node.left,minDiff);

        if(prev!= null){
            minDiff = Math.min(minDiff,node.val-prev);
        }
        prev = node.val;
       return  inorder(node.right,minDiff);
    }

    public  int kthSmallestRecursive(TreeNode root, int k){
        count=0;
        result = -1;
        inorderKthSmall(root,k);
        return result;
    }

    private void inorderKthSmall(TreeNode node, int k) {
        if(node == null || found) return;

        inorderKthSmall(node.left,k);
        if(found) return;
        count++;

        if(count == k){
            result = node.val;
            found=true;
            return;
        }
        inorderKthSmall(node.right,k);
    }

    public int inorderKthSmallIterative(TreeNode node, int k){
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = node;

        while (current!= null || !stack.isEmpty()){
            while (current!= null){
                stack.push(current);
                current = current.left;
            }
           current= stack.pop();
            k--;
            if(k ==0){
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }

    public  boolean hasPathSum(TreeNode root, int targetSum){
        if(root == null) return false;

        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        int newSum = targetSum- root.val;
        return hasPathSum(root.left,newSum) || hasPathSum(root.right,newSum);
    }

    public int maxPathSumTree(TreeNode root){
        maxPathSum(root);
        return max;
    }
    public int maxPathSum(TreeNode root) {



        if (root == null) return 0;

        // Recursive computation embedded here.
        int leftSum = Math.max(maxPathSum(root.left), 0);
        int rightSum = Math.max(maxPathSum(root.right), 0);

        int localMax = root.val + leftSum + rightSum;
        max = Math.max(max, localMax);

        // Return the maximum path sum including the current node for one side.
        return root.val + Math.max(leftSum, rightSum);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length ==0 || postorder.length ==0) return null;

        Stack<TreeNode> stack = new Stack();
        int postIndex = postorder.length-1 ;
        TreeNode root = new TreeNode(postorder[postIndex]);
        Map<Integer,Integer> index = new HashMap<>();


        stack.push(root);

        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }

        postIndex--;
        while(postIndex>=0){
            TreeNode node = new TreeNode(postorder[postIndex]);
            TreeNode peekN = stack.peek();

            if(index.get(node.val)>index.get(peekN.val)){
                peekN.right = node;
            }else {

                while(!stack.isEmpty() && index.get(node.val) < index.get(stack.peek().val) ){
                    peekN = stack.pop();
                }
                peekN.left = node;
            }

            stack.push(node);
            postIndex--;

        }

        return root;

    }


    public TreeNode buildTreeItr(int[] inorder, int[] postorder){
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
            return null;
        }

        Map<Integer,Integer> inorderIndex = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inorderIndex.put(inorder[i],i);
        }

        return buildTreeHelper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inorderIndex);
    }

    private TreeNode buildTreeHelper(int[] postorder, int postStart,
                                     int postEnd, int[] inorder,
                                     int inStart, int inEnd, Map<Integer, Integer> inorderIndex) {

     if(postStart>postEnd || inStart>inEnd){
         return null;
     }
     int rootValue = postorder[postEnd];
     TreeNode roott = new TreeNode(rootValue);
     int rootIndex = inorderIndex.get(rootValue);

     int leftSize = rootIndex- inStart;

     roott.left = buildTreeHelper(postorder,postStart,postStart+leftSize-1,
             inorder, inStart,rootIndex-1,inorderIndex);

     roott.right = buildTreeHelper(postorder,postStart+leftSize,postEnd-1,
             inorder,rootIndex+1,inEnd,inorderIndex
              );

     return  roott;
    }

    public List<Integer> levelOrder(TreeNode node){
        List<Integer> result = new ArrayList<>();
        if(node == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current != null) {
                result.add(current.val);
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                result.add(null);
            }
        }
        return result;
    }
//                 1
//                / \
//                2   5
//                / \    \
//                3   4    6


    public void flatten(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();


            if(root == null) return;
            TreeNode prev = null;

            stack.push(root);

            while(!stack.isEmpty()){

                TreeNode current = stack.pop();

                if(prev != null){
                    prev.left = null;
                    prev.right = current;
                }


                if(current.right!= null){
                    stack.push(current.right);
                }

                if(current.left!= null){
                    stack.push(current.left);
                }

                prev = current;


            }



            // flatten(root.left);

            // root

            // flatten(root.right);

        }

 public List<Integer> preOrder(TreeNode node){
     List<Integer> result = new ArrayList<>();
     if(node == null) return result;
     result.add(node.val);
     result.addAll(preOrder(node.left)); // Add the values from the left subtree
     result.addAll(preOrder(node.right));
//     preOrder(node.left);
//     preOrder(node.right);
    return result;

 }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        zigzagHelper(root,result,0,true);

        return result;

    }


    public void zigzagHelper(TreeNode root, List<List<Integer>> result,int depth,boolean isLeftFirst){

        if(root == null) return;


        if(depth == result.size()){
            result.add(new LinkedList<>());
        }
        LinkedList<Integer> level = (LinkedList<Integer>) result.get(depth); // Cast to LinkedList

        if(isLeftFirst){
            level.addLast(root.val);
        } else {
            level.addFirst(root.val);
        }

        zigzagHelper(root.left,result,depth+1,!isLeftFirst);
        zigzagHelper(root.right,result,depth+1,!isLeftFirst);
    }

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int pathRoot = pathSumHelper(root, targetSum);
        int leftPath = pathSum2(root.left, targetSum);
        int rightPath = pathSum2(root.right, targetSum);

        return pathRoot + leftPath + rightPath;
    }

    public int pathSumHelper(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == targetSum) {
            count++;
        }

        count += pathSumHelper(node.left, targetSum - node.val);
        count += pathSumHelper(node.right, targetSum - node.val);

        return count;
    }

    // Main method
    public static void main(String[] args) {
        BinaryTreeQuestions btq = new BinaryTreeQuestions();

        // Construct the tree
        TreeNode root = btq.new TreeNode(1000000000);
        root.left = btq.new TreeNode(1000000000);
        root.left.left = btq.new TreeNode(294967296);
        root.left.left.left = btq.new TreeNode(1000000000);
        root.left.left.left.left = btq.new TreeNode(1000000000);
        root.left.left.left.left.left = btq.new TreeNode(1000000000);

        // Target sum
        int targetSum = 0;

        // Create Solution instance and call pathSum
//        Solution solution = new Solution();
        int result = btq.pathSum2(root, targetSum);

        // Output the result
        System.out.println("Number of paths with sum " + targetSum + ": " + result);

//        TreeNode root = btq.new TreeNode(1);
//        root.left = btq.new TreeNode(2);
//        root.right = btq.new TreeNode(3);
//        root.left.left = btq.new TreeNode(4);
//        root.left.right = btq.new TreeNode(5);
//        root.right.left =btq. new TreeNode(6);
//        root.right.right = btq.new TreeNode(7);

//        Solution solution = new Solution();
//        List<List<Integer>> result = btq.zigzagLevelOrder(root);

        // Print the result
//        for (List<Integer> level : result) {
//            System.out.println(level);
//        }

        // Manually create a sample binary search tree
//        btq.root = btq.new TreeNode(4);
//        btq.root.left = btq.new TreeNode(2);
//        btq.root.right = btq.new TreeNode(6);
//        btq.root.left.left = btq.new TreeNode(1);
//        btq.root.left.right = btq.new TreeNode(3);

//        TreeNode root = btq.new TreeNode(3);
//        root.left = btq.new TreeNode(2);
//        root.right = btq.new TreeNode(5);
//        root.left.left = btq.new TreeNode(1);
//        root.left.right = btq.new TreeNode(4);
//        root.right.right = btq.new TreeNode(6);
 ////               BST
//        TreeNode root = btq.new TreeNode(3);
//        root.left = btq.new TreeNode(2);
//        root.right = btq.new TreeNode(5);
//        root.left.left = btq.new TreeNode(1);
//        root.right.left = btq.new TreeNode(4);
//        root.right.right = btq.new TreeNode(6);
//
//        TreeNode root = btq.new TreeNode(1);
//        root.left = btq.new TreeNode(2);
//        root.right = btq.new TreeNode(3);
//        btq.root = root;
//
//        System.out.println(btq.maxPathSumTree(btq.root));
//
//        TreeNode root = btq.new TreeNode(5);
//        root.left = btq.new TreeNode(4);
//        root.right = btq.new TreeNode(8);
//        root.left.left = btq.new TreeNode(11);
//        root.right.left = btq.new TreeNode(13);
//        root.right.right = btq.new TreeNode(4);
//        root.left.left.left = btq.new TreeNode(7);
//        root.left.left.right = btq.new TreeNode(2);

        btq.root = root;

        // Call the iterative method
        int iterativeResult = btq.getMinDifference(btq.root);
        System.out.println("Minimum Absolute Difference (Iterative): " + iterativeResult);

        // Call the recursive method
        int recursiveResult = btq.getMinDiffRecursive(btq.root);
        System.out.println("Minimum Absolute Difference (Recursive): " + recursiveResult);
        System.out.println(btq.kthSmallestRecursive(btq.root,2));
        System.out.println(btq.inorderKthSmallIterative(btq.root,2));

        TreeNode node = btq.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

        System.out.println(btq.levelOrder(node));

        System.out.println(btq.hasPathSum(btq.root,22));


        TreeNode node1 = btq.buildTreeItr(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

        System.out.println(btq.levelOrder(node1));

//         [1,2,5,3,4,null,6]
        System.out.println(btq.preOrder(root));
        btq.flatten(root);  // Pass the correct root
        System.out.println(btq.preOrder(root));


    }
}

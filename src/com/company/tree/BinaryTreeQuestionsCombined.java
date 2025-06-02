package com.company.tree;


import java.util.Stack;
import java.util.*;



public class BinaryTreeQuestionsCombined {
    private TreeNode root;


    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

//post - since move left right then add root
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthRecursive(root.left),
                maxDepthRecursive(root.right));
    }
// pre - root-left-right
    public int maxDepthIterative(TreeNode root) {

        if (root == null) return 0;

        int maxDepth = 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode curr = current.getFirst();
            int depth = current.getSecond();

            maxDepth = Math.max(maxDepth, depth);

            if (curr.right != null) {
                stack.push(new Pair<>(curr.right, depth + 1));
            }
            if (curr.left != null) {
                stack.push(new Pair<>(curr.left, depth + 1));
            }
        }
        return maxDepth;

    }


    public boolean isLeafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        collectLeaf(root1,leaves1);
        collectLeaf(root2,leaves2);

        return leaves1.equals(leaves2);
    }
    public boolean isLeafSimilarItr(TreeNode root1, TreeNode root2){
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

//        getLeavesPreorder(root1,leaves1);

        return getLeavesPostOrder(root1).equals(getLeavesPostOrder(root2));
    }

    private void collectLeaf(TreeNode root1, List<Integer> leaves) {

        if(root1 == null) return;

        if(root1.left == null && root1.right == null){
            leaves.add(root1.data);
        }
        collectLeaf(root1.left,leaves);
        collectLeaf(root1.right,leaves);
    }


    public List<Integer> getLeavesPreorder(TreeNode root){
       List<Integer> leaves = new ArrayList<>();
       if(root == null) return leaves;

       Stack<TreeNode> stack = new Stack<>();
       stack.push(root);

       while (!stack.isEmpty()){
           TreeNode node = stack.pop();

           if(node.left == null && node.right == null){
               leaves.add(node.data);
           }

           if(node.right!= null) stack.push(node.right);
           if(node.left != null) stack.push(node.left);

       }
        return leaves;
    }

    public List<Integer> getLeaveInOrder(TreeNode node){
        List<Integer> leaves = new ArrayList<>();

        if(root == null) return leaves;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current!= null) {

            while (current!= null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.left == null && current.right == null) {
                leaves.add(current.data);
            }
            current = current.right;
        }
        return leaves;
    }

    public List<Integer> getLeavesPostOrder(TreeNode root){
        List<Integer> leaves = new ArrayList<>();
        if(root == null) return leaves;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();

            stack2.push(node);
            if(node.left != null) stack1.push(node.left);
            if(node.right!= null) stack1.push(node.right);

        }

        while (!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            if(node.left!= null && node.right == null){
                leaves.add(node.data);
            }
        }
        return leaves;
    }



    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

//        TreeNode current = root;
//
//        TreeNode temp = current.left;
//        current.left = current.right;
//        current.right = temp;
//
//        invertTree(current.left);
//        invertTree(current.right);

//        return current;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public TreeNode invertTreeItr(TreeNode root){
        if(root == null) return  null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right =temp;

            if(node.right!= null){
                stack.push(node.right);
            }
            if(node.left!= null){
                stack.push(node.left);
            }
        }
        return root;
    }
    public void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println(); // Move to next level
        }
    }
    //    public int pathSum(TreeNode root, int targetSum){
//        if(root == null) return 0;
//
//        return pathSumFrom(root,targetSum) +
//                pathSumFrom(root,targetSum)
//    }


    public int goodNodes(TreeNode root) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, root.data));

//         int maxVal = Integer.MIN_VALUE;
        int count = 0;

        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> current = stack.pop();

            TreeNode curr = current.getFirst();

            Integer maxInPath = current.getSecond();

            if (curr.data >= maxInPath) {
                count++;
            }

            int maxVal = Math.max(curr.data, maxInPath);

            if (curr.right != null) {
                stack.push(new Pair<>(curr.right,maxVal ));
            }

            if (curr.left != null) {
                stack.push(new Pair<>(curr.left, maxVal));
            }
        }

        return count;
    }


    boolean found = false;
    public int kthSmallest(TreeNode root, int k) {

        int result =0;

        return kthSmallestHelper(root,k,result);

        // return result;

    }

    public int kthSmallestHelper(TreeNode node,int k,int count){
        if(node == null || found ) return count ;

       count  =  kthSmallestHelper(node.left,k,count);


         count++;

        if(count ==k){
        found = true;
        return node.data;
    }

    return kthSmallestHelper(node.right,k,count);


}

    public static void main(String[] args) {
        // Construct example trees
        BinaryTreeQuestionsCombined btq = new BinaryTreeQuestionsCombined();
//        TreeNode root1 = btqc.new TreeNode(1);
//        root1.left = btqc.new TreeNode(2);
//        root1.right = btqc.new TreeNode(3);
//        root1.right.left = btqc.new TreeNode(4);
//        root1.right.right = btqc.new TreeNode(5);

                TreeNode root = btq.new TreeNode(5);
        root.left = btq.new TreeNode(4);
        root.right = btq.new TreeNode(9);
        root.left.left = btq.new TreeNode(3);
        root.right.right = btq.new TreeNode(6);

        System.out.println(btq.kthSmallest(root,2));

        // Constructing the tree manually based on the given input
//        TreeNode root1 = btqc.new TreeNode(5);
//        root1.left = btqc.new TreeNode(9);
//        root1.right = btqc.new TreeNode(6);
//        root1.right.left = btqc.new TreeNode(5);
//        root1.right.right = btqc.new TreeNode(8);
//
//
//        // Creating an instance of the solution and calling goodNodes
////        Solution solution = new Solution();
//        int result = btqc.goodNodes(root1);
//
//        // Printing the result
//        System.out.println("Number of good nodes: " + result);
//
//
//
//        TreeNode root2 = btqc.new TreeNode(1);
//        root2.left = btqc.new TreeNode(2);
//        root2.right = btqc.new TreeNode(3);
//
//        // Test Max Depth
//        System.out.println("Max Depth (Recursive): " + btqc.maxDepthRecursive(root1));
//        System.out.println("Max Depth (Iterative): " + btqc.maxDepthIterative(root1));
//        System.out.println("leaf Similar trees:" + btqc.isLeafSimilar(root1,root2));
//        System.out.println("leaf Similar trees: " + btqc.isLeafSimilarItr(root1,root2));
//        btqc.printTree(root1);
//        System.out.println("Invert trees:" + btqc.invertTree(root1));
        btq.printTree(root);
//


    }
}
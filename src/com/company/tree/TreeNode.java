package com.company.tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>(); // ✅ Return empty list instead of null

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // Step 1: Build parent references using BFS
        queue.add(root);
        parentMap.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }

        // Step 2: BFS from target to find nodes at distance K
        queue.clear();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int dist = 0;

        while (!queue.isEmpty()) {
            if (dist == k) {
                List<Integer> ans = new ArrayList<>();
                for (TreeNode node : queue) {
                    ans.add(node.val); // ✅ Collect all nodes at distance k
                }
                return ans; // ✅ Return list at correct point
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && visited.add(curr.left)) {
                    queue.add(curr.left);
                }
                if (curr.right != null && visited.add(curr.right)) {
                    queue.add(curr.right);
                }
                if (parentMap.containsKey(curr) && visited.add(parentMap.get(curr))) {
                    queue.add(parentMap.get(curr));
                }
            }
            dist++;
        }

        return new ArrayList<>(); // ✅ Return empty list if no nodes at distance k
    }

    private TreeNode findNode(TreeNode root, int targetVal) {
        if (root == null) return null;
        if (root.val == targetVal) return root;
        TreeNode left = findNode(root.left, targetVal);
        return (left != null) ? left : findNode(root.right, targetVal);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();


        TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);

    // Find the target node with value 5
    TreeNode target = sol.findNode(root, 5);

    int K = 2;
    List<Integer> result = sol.distanceK(root, target, K);

        System.out.println("Nodes at distance " + K + " from target " + target.val + ": " + result);
     }
}

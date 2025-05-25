package com.company.tree;


import java.util.*;

public class BinarySearchTreeSummary {
    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }
        public Node getRoot() {
            return root;
        }

        public static void main(String[] args) {
            BinarySearchTreeSummary myBST = new BinarySearchTreeSummary();


            myBST.insert(47);
////          myBST.insert(18);
//            myBST.insert(21);
//            myBST.insert(76);
//            myBST.insert(27);
//            myBST.insert(52);
//            myBST.insert(82);


//            System.out.println("BST Contains 27:");
//            System.out.println(myBST.contains(27));
//
//            System.out.println("\nBST Contains 17:");
//            System.out.println(myBST.contains(17));



//            myBST.rInsert(2);
//            myBST.rInsert(1);
//            myBST.rInsert(3);

//            myBST.rInsert(47);
//            myBST.rInsert(21);
//            myBST.rInsert(20);
//
//        /*
//               2
//              / \
//             1   3
//        */
//
//            System.out.println( "Root: " + myBST.getRoot().value );
//            System.out.println( "Root->Left: " + myBST.getRoot().left.value );
//            System.out.println( "Root->Right: " + myBST.getRoot().left.left.value );


//            myBST.deleteNode(21);

        /*
               3
              / \
             1  null
        */


//            System.out.println( "\nRoot: " + myBST.getRoot().value );
//            System.out.println( "Root->Left: " + myBST.getRoot().left.value );
//            System.out.println( "Root->Right: " + myBST.getRoot().right );


        /*
            EXPECTED OUTPUT:
            ----------------
			Root: 2
			Root->Left: 1
			Root->Right: 3

			Root: 3
			Root->Left: 1
			Root->Right: null

        */
            myBST.insert(47);
            myBST.insert(21);
            myBST.insert(76);
            myBST.insert(18);
            myBST.insert(27);
            myBST.insert(52);
            myBST.insert(82);

            System.out.println("Breadth First Search:");
            System.out.println( myBST.bfsTraverse() );

            System.out.println("DFS PreOrder:");
            System.out.println( myBST.dfsPreOrder());


            System.out.println("DFS PostOrder:");
            System.out.println( myBST.dfsPostOrder() );

            System.out.println("DFS PostOrder:");
            System.out.println( myBST.dfsIneOrder() );
        }

        public boolean insert(int value) {
            Node newNode = new Node(value);

            if (root == null) {
                root = newNode;
                return true;
            }

            Node temp = root;
            while (true) {
                if (newNode.value == temp.value) return false;
                if (newNode.value < temp.value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return true;
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return true;
                    }
                    temp = temp.right;
                }
            }
        }
        public boolean contains(int value) {
            if (root == null) return false;

            Node temp = root;

//            while (temp != null) {
//                if (value < temp.value) {
//                    temp = temp.left;
//                } else if (value > temp.value) {
//                    temp = temp.right;
//                } else {
//                    return true;
//                }
//            }
            while (temp!= null){
                if(value< temp.value){
                    temp = temp.left;
                } else if(value> temp.value){
                    temp = temp.right;
                } else{
                    return true;
                }
            }
            return false;
        }

        private boolean rContains(int value){
        return rContains(root,value);
        }
        private boolean rContains(Node current,int value){
        if(current == null) return  false;

        if(current.value == value ) return true;

        if(value< current.value) {
           return rContains(current.left,value);
        } else{
           return rContains(current.right,value);
        }
        }

        private Node rInsert(Node currentNode, int value){
        if(currentNode == null) return new Node(value);

        if(value<currentNode.value){
            currentNode.left = rInsert(currentNode.left,value);
        } else if(value > currentNode.value){
            currentNode.right = rInsert(currentNode.right,value);
        }
        return currentNode;
    }

        public void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root,value);
        }

        public Node deleteNode(Node currentNode, int value){

        if(currentNode == null) return null;

        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left,value);
        } else if(value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right,value);
        } else {

            if(currentNode.left == null && currentNode.right == null){
                return null;
            } else if(currentNode.left == null){
                currentNode = currentNode.right;
            } else if(currentNode.right == null){
                currentNode = currentNode.left;
            } else {
                int subtreeMin = minValue(currentNode.right);
                currentNode.value = subtreeMin;
                currentNode.right = deleteNode(currentNode.right,subtreeMin);
            }

        }

        return currentNode;
    }

    public void deleteNode(int value){
        root = deleteNode(root,value);
    }

    private int minValue(Node currentNode) {

        while (currentNode.left!=null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

 public List<Integer> bfsTraverse(){
        Node current = root;
     Queue<Node> queue = new LinkedList<>();
     List<Integer> result = new ArrayList<>();
     queue.add(current);

     while(!queue.isEmpty()){

         current = queue.remove();
         result.add(current.value);
         if(current.left!=null){
             queue.add(current.left);
         }
         if(current.right !=null){
             queue.add(current.right);
         }
     }
     return result;
 }



    public ArrayList<Integer> dfsPreOrder(){

        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                result.add(currentNode.value);
                if(currentNode.left!=null){
                    new Traverse(currentNode.left);
                }
                if(currentNode.right!=null){
                    new Traverse(currentNode.right);
                }

            }
        }
        new Traverse(root);
        return result;
 }


 public ArrayList<Integer> dfsPostOrder(){

     ArrayList<Integer> result = new ArrayList<>();

     class Traverse{
         Traverse(Node currentNode){

             if(currentNode.left !=null){
                 new Traverse(currentNode.left);
             }

             if(currentNode.right !=null){
                 new Traverse(currentNode.right);
             }

             result.add(currentNode.value);

         }
     }
     new Traverse(root);
return result;

 }

 public ArrayList<Integer> dfsIneOrder(){

        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{

            Traverse(Node currentNode){
                if(currentNode.left!=null){
                    new Traverse(currentNode.left);
                }
                result.add(currentNode.value);
                if(currentNode.right !=null){
                    new Traverse(currentNode.right);
                }
            }

        }
        new Traverse(root);
        return result;
 }

}


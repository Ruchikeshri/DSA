package com.company.graph;

import java.util.*;

public class Graph {

    private int vertices;
    private List<List<Integer>> adjList;


    public Graph(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>();

        for(int i=0;i<vertices;i++){
            adjList.add(new ArrayList<>());

        }
    }


    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

      public void printGraph(){
        for(int i=0;i<vertices;i++){
            System.out.print("vertex"+ i + "->");
            for(int neigbour : adjList.get(i)){
                System.out.print(neigbour + " ");
            }
            System.out.println();
        }
}

    public void dfsIterative(int start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {

                System.out.print(node+ " ");
                visited.add(node);
               List<Integer> neigbours =  adjList.get(node);
               Collections.reverse(neigbours);
                for (int neighbour :neigbours ) {

                    if(!visited.contains(neighbour)){
                        stack.push(neighbour);
                    }
                }
            }
        }
    }
        public void dfsPre(int node,Set<Integer> visited){
            if(visited.contains(node)) return;
            System.out.print( node + " ");

            visited.add(node);
            for(int neighbour : adjList.get(node)){
                if(!visited.contains(neighbour)) {
                    dfsPre(neighbour, visited);
                }
            }
        }

        public void startDfspre(int start){
        Set<Integer> visted = new HashSet<>();
            System.out.println("DFS Recursive");
            dfsPre(start,visted);
            System.out.println();
        }
    public void startDfspost(int start){
        Set<Integer> visted = new HashSet<>();
        System.out.println("DFS Recursive post");
        dfsPost(start,visted);
        System.out.println();
    }

        public void dfsPost(int node,Set<Integer> visited){
        if(visited.contains(node)) return;

        visited.add(node);
        for(int neigbhour : adjList.get(node)){
            if(!visited.contains(neigbhour)) {
                dfsPost(neigbhour, visited);
            }
        }
            System.out.print(node + " ");
        }

        public void bfs(int start){
           Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
           queue.offer(start);
           visited.add(start);

           while (!queue.isEmpty()){
               int node = queue.poll();
               System.out.print(node+ " ");

               for(int neigbhor : adjList.get(node)){
                   if(!visited.contains(neigbhor)){
                       queue.offer(neigbhor);
                       visited.add(neigbhor);
                   }
               }
           }
            System.out.println();
        }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
//        g.printGraph();
        g.startDfspre(0);
        g.startDfspost(0);
        g.dfsIterative(0);
        System.out.println();
        g.bfs(0);
           }
}


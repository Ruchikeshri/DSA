package com.company.graph;

import java.util.*;

public class GraphSummary {


    public static  Map<Integer, List<Integer>> buildGraph(int n, int edges[][]){
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int edge[] : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static int[][] buildAdjMatrix(int n, int edges[][]){
        int mat[][] = new int[n][n];

        for(int edge[] : edges){
            int u= edge[0];
            int v = edge[1];

            mat[u][v]=1;
            mat[v][u]=1;
        }
        return mat;
    }

    public static void printGraph(Map<Integer,List<Integer>> graph){
        for(int node : graph.keySet()){
            System.out.println(node + "->" + graph.get(node));
        }
    }

    public static void adjacnecyMat(int mat[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j< mat[i].length;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(Map<Integer,List<Integer>> graph,int n, int start){
        boolean visited[] = new boolean[n];
        dfsRec(graph,start,visited);
    }

    private static void dfsRec(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {

        visited[node] = true;

        System.out.print(node+ " ");
        for(int neigh:graph.get(node)){
            if(!visited[neigh]) {
                dfsRec(graph, neigh, visited);
            }
        }
    }

    private static void dfsIterative(Map<Integer, List<Integer>> graph,int start,int n){
        boolean visited[] = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()){
            int node = stack.pop();

            if(!visited[node]){
                visited[node]=true;
                System.out.print(node + " ");

                List<Integer> neighs = graph.get(node);
                Collections.reverse(neighs);// just to maintain order
                for(int neigh : neighs){
                    if(!visited[neigh]) {
                        stack.push(neigh);
                    }
                }
            }
        }
    }

    public static void bfsIterative(Map<Integer, List<Integer>> graph,int n, int start){
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node +" ");
            for(int neigh : graph.get(node)){
                if(!visited[neigh]){
                    queue.offer(neigh);
                    visited[neigh]=true;
                }
            }
        }


    }

    public static void main(String[] args) {
        int n=7;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 5},
                {5, 6}
        };
        Map<Integer, List<Integer>> graph = buildGraph(n, edges);

        System.out.println("Adjacency List:");
        printGraph(graph);

        System.out.println("\nAdjacency Matrix:");
        int[][] adjMatrix = buildAdjMatrix(n, edges);
        adjacnecyMat(adjMatrix);

        System.out.println("\nDFS Recursive:");
        dfs(graph, n, 0);

        System.out.println("\n\nDFS Iterative:");
        dfsIterative(graph,  0,n);

        System.out.println("\n\nBFS Traversal:");
        bfsIterative(graph, n, 0);
    }
}

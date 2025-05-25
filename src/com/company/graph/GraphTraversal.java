package com.company.graph;

import java.util.*;
public class GraphTraversal {


    public static void bfs(Map<Integer, List<Integer> >graph,
                           int start){
         Queue<Integer> queue = new LinkedList<>();
         Set<Integer> visited = new HashSet<>();

         queue.add(start);
         visited.add(start);

         while(!queue.isEmpty()){
             int node = queue.poll();
             System.out.print(node + " ");

             for(int neigbhour:graph.getOrDefault(node,new ArrayList<>()) ){
                 if(!visited.contains(neigbhour)){
                     queue.add(neigbhour);
                     visited.add(neigbhour);
                 }
             }

         }
//
//         while(!queue.isEmpty()){
//             int node = queue.poll();
//             System.out.print(node + " ");
//
//             for(int neighbor : graph.getOrDefault(node,new ArrayList<>())){
//                 if(!visited.contains(neighbor)){
//                        queue.add(neighbor);
//                        visited.add(neighbor);
//                 }
//
//             }
//         }


    }

    public static void dfsIterative(Map<Integer,List<Integer>> graph ,int start){
      Stack<Integer> stack = new Stack<>();
      Set<Integer> visited = new HashSet<>();

      stack.push(start);

      while(!stack.isEmpty()){
          int node = stack.pop();
          if(!visited.contains(node)){

              System.out.print(node + " ");
              visited.add(node);

              List<Integer> neigbors = graph.getOrDefault(node,new ArrayList<>());
              Collections.reverse(neigbors);
              for(int neigh : neigbors){
                  if(!visited.contains(neigh)){
                      stack.push(neigh);
                  }
              }

          }
      }
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(1, 2, 5));
        graph.put(5, Arrays.asList(3, 4));

        System.out.println("BFS Traversal starting from node 0:");
//        bfs(graph, 0);
        System.out.println("DFS Iterative Traversal starting from node 0:");
        dfsIterative(graph, 0);
    }
}

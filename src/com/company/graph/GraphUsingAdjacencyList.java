package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphUsingAdjacencyList {

    private HashMap<String, ArrayList<String>> adjList = new HashMap();

    public HashMap<String, ArrayList<String>> getAdjList(){
        return adjList;
    }

    public void printGraph(){
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex){
        if(!adjList.containsKey(vertex)){
            adjList.put(vertex,new ArrayList<>());
            return  true;
        }
        return false;
    }

    public boolean addEdge(String vertex1,String vertex2){
    if(adjList.get(vertex1)!= null && adjList.get(vertex2)!=null){
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
        return  true;
    }
    return false;
    }

    public boolean removeEdge(String vertex1,String vertex2){

        if(adjList.get(vertex1)!=null && adjList.get(vertex2)!=null){
             adjList.get(vertex1).remove(vertex2);
             adjList.get(vertex2).remove(vertex1);
             return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex1){
        if(adjList.get(vertex1) ==null ) return false;
            for(String vertex: adjList.get(vertex1) ){
                adjList.get(vertex).remove(vertex1);
            }
            adjList.remove(vertex1);
            return  true;
//        }


    }

    public static void main(String[] args) {
        GraphUsingAdjacencyList myGraph = new GraphUsingAdjacencyList();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");


        myGraph.printGraph();

        myGraph.addEdge("A","B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");
        myGraph.addEdge("C", "D");

        myGraph.printGraph();

        myGraph.removeEdge("A", "B");

        myGraph.printGraph();

        myGraph.removeVertex("D");


        myGraph.printGraph();
    }



}

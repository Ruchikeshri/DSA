package com.company.graph;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GraphUsingAdjacencyMatrix {

  private   int adjMatrix[][];
    private int V;
    private int E;

    public GraphUsingAdjacencyMatrix(int nodes){
        this.E=0;
        this.V=nodes;
       this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v){
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] =1;
        E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, "+ E+ " edges "+ "\n");
        for(int v =0; v<V;v++){
            sb.append(v  + ":");
            for(int w : adjMatrix[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        for(int arr[] : adjMatrix){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        return sb.toString();
    }
    public static void main(String[] args) {
        GraphUsingAdjacencyMatrix graphUsingAdjacencyMatrix = new GraphUsingAdjacencyMatrix(4);

        graphUsingAdjacencyMatrix.addEdge(0,1);
        graphUsingAdjacencyMatrix.addEdge(1,2);
        graphUsingAdjacencyMatrix.addEdge(2,3);
        graphUsingAdjacencyMatrix.addEdge(3,0);
        System.out.println(graphUsingAdjacencyMatrix);

    }

}

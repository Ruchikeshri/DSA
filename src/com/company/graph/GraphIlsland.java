package com.company.graph;

public class GraphIlsland {

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length ==0) return 0;

        int count =0;

        int rows = grid.length,cols = grid[0].length;


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] =='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char grid[][],int i,int j){
        if(i<0 || j<0 || i>=grid.length|| j>=grid[0].length|| grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0'},
                {'0', '0', '0', '1', '0'}
        };

        GraphIlsland solution = new GraphIlsland();
        int result = solution.numIslands(grid);
        System.out.println("Number of islands: " + result);
    }
}

package com.company.graph;

public class WordSearch {
        public boolean exist(char[][] board, String word) {


            int row = board.length;
            int col = board[0].length;

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(board[i][j] == word.charAt(0) &&
                            dfs(board,word,i,j,0)){
                        return true;
                    }
                }

            }
            return false;

        }

        private boolean dfs(char[][] board,String word,int row,int col,int index){
            if(index == word.length()){
                return true;
            }

            if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col] !=word.charAt(index))    {
                return false;
            }

            char temp = board[row][col];
            board[row][col]= '*';

            boolean found =   dfs(board,word,row-1,col,index+1) ||
                    dfs(board,word,row+1,col,index+1) ||
                    dfs(board,word,row,col-1,index+1) ||
                    dfs(board,word,row,col+1,index+1) ;

            board[row][col] =temp;



            return found;
        }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        WordSearch solution = new WordSearch();
        String word1 = "ABCCED";  // Should return true
        System.out.println(solution.exist(board,word1));
    }
    }




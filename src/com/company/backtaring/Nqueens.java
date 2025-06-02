package com.company.backtaring;

import java.util.*;
import java.util.ArrayList;

class Nqueens {
    public List<List<String>> totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char board[][] = new char[n][n];

        for(char row[] : board){
            Arrays.fill(row,'.');
        }

        backtrack(board,0, result);

        return result;
    }

    public void backtrack(char board[][], int row, List<List<String>> result){
        int n = board.length;

        if(row == board.length){
            result.add(construct(board));
            return;
        }

        for(int col =0;col<n;col++){
            if(isValid(board,row,col)){
                board[row][col] = 'Q';
                backtrack(board,row+1,result);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char board[][],int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }

        }

        for(int i = row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public List<String> construct(char[][] board){
     
     List<String> sol = new ArrayList<>();

        for(char res[] : board){
            sol.add(new String(res));
        }

        return sol;
    }

    public static void main(String[] args) {
        System.out.println(new Nqueens().totalNQueens(4));
    }
}
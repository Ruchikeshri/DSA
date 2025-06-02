package com.company.graph;

public class SurroundedRegionsSolver {

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        System.out.println("Original Board:");
        printBoard(board);

        Solution solution = new Solution();
        solution.solve(board);

        System.out.println("\nSolved Board:");
        printBoard(board);
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;

            int m = board.length, n = board[0].length;

            // Step 1: Mark safe 'O's connected to borders with 'S'
            for (int i = 0; i < m; i++) {
                dfs(board, i, 0);       // First column
                dfs(board, i, n - 1);   // Last column
            }
            for (int j = 0; j < n; j++) {
                dfs(board, 0, j);       // First row
                dfs(board, m - 1, j);   // Last row
            }

            // Step 2: Convert all remaining 'O' to 'X', and 'S' back to 'O'
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == 'S') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
                return;
            }

            board[i][j] = 'S'; // Mark as safe
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
}

package com.company.backtaring;

public class WordSearchSolver {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS if the first character matches
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        // Base case: if all characters matched
        if (index == word.length()) return true;

        // Boundary check and character match check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Store the current character and mark the cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all four directions
        boolean found = dfs(board, word, index + 1, i + 1, j) || // Down
                        dfs(board, word, index + 1, i - 1, j) || // Up
                        dfs(board, word, index + 1, i, j + 1) || // Right
                        dfs(board, word, index + 1, i, j - 1);   // Left

        // Backtrack: Restore the original character
        board[i][j] = temp;

        return found;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        WordSearchSolver solver = new WordSearchSolver();

        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

//        String word1 = "ABCCED"; // Should return true
        String word2 = "SEE";    // Should return true
        String word3 = "ABCB";   // Should return false

//        System.out.println("Word '" + word1 + "' found? " + solver.exist(board, word1));
        System.out.println("Word '" + word2 + "' found? " + solver.exist(board, word2));
        System.out.println("Word '" + word3 + "' found? " + solver.exist(board, word3));
    }
}

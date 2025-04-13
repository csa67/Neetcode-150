package Recursion;

/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
class Solution {
    /*
     * Start when there is a match for start character and check if the word can be present using dfs.
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /*
     * For backtracking, what is changing, base case./
     */
    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // Base case: entire word is matched
        if (index == word.length()) return true;

        // Boundary check and character mismatch
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore in all 4 directions
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (backtrack(board, word, newRow, newCol, index + 1)) {
                return true;
            }
        }

        // Restore the original character (backtrack)
        board[row][col] = temp;
        return false;
    }
}


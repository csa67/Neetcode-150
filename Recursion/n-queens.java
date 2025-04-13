package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for(char[] row:board){
            Arrays.fill(row,'.');
        }

        backtrack(0,n,board);
        return res;
    }

    private void backtrack(int row, int n, char[][] board){
        if(row==n){
            List<String> rowRes = new ArrayList<>();
            for(char[] rowArray:board){
                rowRes.add(new String(rowArray));
                res.add(rowRes);
            }

            return;
        }

        for(int i=0; i<n;i++){
            if(isValidPos(row,i,n,board)){
                board[row][i] = 'Q';
                backtrack(row+1, n, board);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValidPos(int row, int col, int n, char[][] board){
        for(int r=0; r<row;r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }

        for(int i=1;row-i>=0 && col-i>=0;i++){
            if(board[row-i][col-i] == 'Q') return false;
        }

        for(int i=1;row-i>=0 && col+i<n;i++){
            if(board[row-i][col+i] == 'Q') return false;
        }

        return true;
    }
}

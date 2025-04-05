/*
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Only validate the partially filled, not solvability.
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * 
     * Bruteforce check each row, column, box.
     */
    public boolean isValidSudoku(char[][] board) {
        // Row check
        for (int i = 0; i < 9; i++) {
            Set<Character> numberSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                else if (numberSet.contains(board[i][j]))
                    return false;
                numberSet.add(board[i][j]);
            }
        }

        // Column check
        for (int i = 0; i < 9; i++) {
            Set<Character> numberSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                else if (numberSet.contains(board[j][i]))
                    return false;
                numberSet.add(board[j][i]);
            }
        }

        // Box check
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                Set<Character> numberSet = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[boxRow * 3 + i][boxCol * 3 + j];
                        if (current == '.')
                            continue;
                        if (numberSet.contains(current))
                            return false;
                        numberSet.add(current);
                    }
                }
            }
        }

        return true; 
    }

    /*
     * TC, SC- O(N^2)
     * We can also do this with bitmasking. This brings down the SC to O(N)
     */

     public boolean isValidSudoku2(char[][] board){

        //binaryNumbers to record previous occurences
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for(int r=0; r<9;r++){
            for(int c=0;c<9;c++){

                if(board[r][c] == '.') continue;

                int val = board[r][c];
                int pos = 1<<(val-1);

                //Check rows
                if((rows[r] & pos) > 0) return false;
                rows[r] |= pos;

                //Check cols
                if((cols[c] & pos) >0) return false;
                cols[c] |= pos;

                int idx=(r/3)*3+(c/3);
                if((boxes[idx] & pos)>0) return false;
                boxes[idx] |= pos;
            }
        }

        return true;
     }

     /*
      * You can also do something with string manipulation and sets.
      */
     public boolean isValidSudoku3(char[][] board){
        Set<String> ust = new HashSet<>();

        for(int r=0; r<9;r++){
            for(int c=0; c<9;c++){

                if(board[r][c] == '.') continue;

                String row = board[r][c]+"ROW"+r;
                String col = board[r][c]+"COL"+c;
                String box = board[r][c]+"BOX"+r/3+c/3;

                if(ust.contains(row) || ust.contains(box) || ust.contains(col)){
                    return false;
                }

                ust.add(row);
                ust.add(col);
                ust.add(box);
            }
        }

        return true;
     }

}

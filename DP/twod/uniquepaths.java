package DP.twod;

import java.util.Arrays;

public class uniquepaths {
    int numRows;
    int numCols;
    private int getNumPaths(int[][] grid){
        numRows = grid.length;
        numCols = grid[0].length;
        
        int[] prev = new int[numCols];
        

        for(int i=0; i<numCols;i++){
            prev[i] = 1;
        }

        for(int i=1; i<numRows;i++){
            int[] curr = new int[numCols];
            for(int j=1; j<numCols;j++){
                curr[j] = prev[j] + curr[j-1];
            }
            prev = curr;
        }

       return prev[numCols-1];
    }
}

//TC - O(m*n), SC-O(n)

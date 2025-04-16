package graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * DFS - TC-O(m*n) SC-O(m*n)
 * BFS - TC-O(n*m) SC-O(min(n*m))
 */
class Islands {
    int[][] grid;
    int rows;
    int cols;

    Islands(int[][] grid){
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public int getIslands(int[][] grid){
        boolean[][] visited = new boolean[rows][cols];

        int cnt=0;
        for(int i=0;i<rows;i++){
            for(int j=0; j<cols;j++){
                if(!visited[i][j]){
                    dfs(i,j,visited);
                    cnt++;
                }
            }
        }
        return cnt;

    }

    private void dfs(int row, int col, boolean[][] visited){
        if(row < 0 || row>=grid.length || col<0 || col>=grid[0].length
        || visited[row][col] || grid[row][col] == '0' ){
            return;
        }

        visited[row][col] = true;

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir:dirs){
            dfs(row+dir[0],col+dir[1],visited);
        }
    }
}

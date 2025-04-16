package graphs;

class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n=grid[0].length;
        int maxArea = Integer.MIN_VALUE;

        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = getAreaOfIsland(i,j,grid,visited);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }

        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private int getAreaOfIsland(int i, int j, int[][] grid, boolean[][] visited){

        int cnt=1;
        visited[i][j] = true;

        for(int[] dir: dirs){
            int newX = i+dir[0];
            int newY = j+dir[1];

            if(newX < 0 || newX >= grid.length
                || newY<0 || newY>=grid[0].length||
                visited[newX][newY] || grid[newX][newY] == 0
            ){
                continue;
            }

            cnt += getAreaOfIsland(newX,newY,grid,visited);

        }
        return cnt;
    }
}
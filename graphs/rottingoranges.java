package graphs;

import java.util.LinkedList;
import java.util.Queue;

class Solution{
    public int orangesRotting(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int rottenOrangesCnt = 0;
        int freshOrangesCnt=0;

        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == 2){
                    rottenOrangesCnt++;
                    q.offer(new Pair(i,j));
                }

                else if(grid[i][j] == 1){
                    freshOrangesCnt++;
                }
            }
        }

        if(rottenOrangesCnt == 0) return -1;
        if(freshOrangesCnt == 0) return 0;

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean hasFreshOranges = false;

            for(int i=0; i<size;i++){
                
                Pair curr = q.poll();

                for(int[] dir:directions){
                    int x=curr.row+dir[0];
                    int y=curr.col+dir[1];
                    
                    if(x < 0 || x>=m || y<0 || y>=n || grid[x][y] != 1) continue;

                    hasFreshOranges = true;

                    grid[x][y] = 2;
                    freshOrangesCnt--;
                    q.offer(new Pair(x,y));

                }

                
            }

            if(hasFreshOranges) minutes++;

        }

        return freshOrangesCnt >0 ? -1 : minutes;
    }
}
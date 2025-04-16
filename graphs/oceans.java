package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n=heights[0].length;
        if(m == 0 || n==0) return new ArrayList<>();

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for(int i=0; i<m;i++){
            pacificQueue.offer(new int[]{i,0});
            atlanticQueue.offer(new int[]{i,n-1});
        }

        for(int i=0; i<n;i++){
            pacificQueue.offer(new int[]{0,i});
            atlanticQueue.offer(new int[]{m-1,i});
        }

        boolean[][] pacificReachable = bfs(pacificQueue,m,n,heights);
        boolean[][] atlanticReachable = bfs(atlanticQueue,m,n,heights);

         List<List<Integer>> commonCells = new ArrayList<>();

         for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(pacificReachable[i][j] && atlanticReachable[i][j]) commonCells.add(List.of(i,j));
            }
         }
        return commonCells;
    }

    private boolean[][] bfs(Queue<int[]> queue, int m, int n,int[][] heights){
        boolean[][] reachable = new boolean[m][n];

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x= curr[0];
            int y=curr[1];
            reachable[x][y] = true;
            for(int[] dir:directions){
                int nx = x+dir[0];
                int ny = y+dir[1];

                if(nx < 0 || nx>=m
                ||ny<0 || ny>=n ||reachable[nx][ny]

                || heights[nx][ny] < heights[x][y]
                ) continue;

                queue.offer(new int[]{nx,ny});
            }
        }

        return reachable;
    }
}

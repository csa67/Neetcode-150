package DP.twod;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int m, n;
    int[][] memo;
    int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};

    //TC - O(mn) SC-O(mn)
    public int getLongestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];

        int maxLength = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(i, j, matrix));
            }
        }

        return maxLength;
    }

    private int dfs(int r, int c, int[][] matrix) {
        if (memo[r][c] != 0) return memo[r][c];

        int maxPath = 1;

        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                int pathLen = 1 + dfs(nr, nc, matrix);
                maxPath = Math.max(maxPath, pathLen);
            }
        }

        memo[r][c] = maxPath;
        return maxPath;
    }

    /*
     * Treat each cell as a node and do topological sorting. 
     * Each node which is less than its neighboring node has an edge towards its neighbor. (directed edge)
     * indegree = No:of incoming edges.
     * BFS layer by layer to get the max path length.
     */
    public int getLongestIncreasingPath2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] inDegree = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Calculate in-degrees
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : DIRECTIONS) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                        inDegree[ni][nj]++;
                    }
                }
            }
        }

        // Step 2: Add all 0 in-degree cells to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (inDegree[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Step 3: BFS layer-by-layer
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++; // each level is a path length
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                for (int[] dir : DIRECTIONS) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                        inDegree[nr][nc]--;
                        if (inDegree[nr][nc] == 0) {
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return pathLength;
    }
}

package graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Multi source BFS
 * 
 * TC - O(mn) SC-O(mn)
 */
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) {
                    q.offer(new Pair<>(r, c));
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
        
                Pair<Integer, Integer> curr = q.poll();

                for (int[] dir : directions) {

                    int newX = curr.getKey() + dir[0];
                    int newY = curr.getValue() + dir[1];

                    System.out.println(newX + " " + newY);
                    if (newX < 0 || newX >= m || newY < 0
                            || newY >= n || rooms[newX][newY] != Integer.MAX_VALUE)
                        continue;

                    int currVal = rooms[newX][newY];
                    rooms[newX][newY] = rooms[curr.getKey()][curr.getValue()] + 1;
                    q.offer(new Pair<>(newX,newY));
                }
            }
        }
}

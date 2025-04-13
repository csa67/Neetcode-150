package Queues;

import java.util.*;

/*
 * point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return distance(b) - distance(a); 
        });

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1]; 
    }
}

package graphs.advanced;

import java.util.PriorityQueue;


class Solution {
    /*
     * Prim's algorithm, TC - O(n^2logN) SC-O(N^2), all the edges are store in the queue.
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a,b) -> (a.getKey() - b.getKey()));

        boolean[] mst = new boolean[n];

        heap.add(new Pair(0,0));
        int mstCost = 0;
        int edgesUsed = 0;

        while(edgesUsed < n){
            Pair<Integer, Integer> top = heap.poll();

            int wt = top.getKey();
            int node = top.getValue();

            if(mst[node]) continue;

            mst[node] = true;
            mstCost += wt;
            edgesUsed++;

            for(int next=0; next<n;next++){
                if(!mst[next]){
                    int nextwt = 
                    Math.abs(points[node][0] - points[next][0])+Math.abs(points[node][1] - points[next][1]);
                    heap.add(new Pair(nextwt, next));
                }
            }
        }

        return mstCost;
    }

    //Prim's optimized - O(n2) SC-O(n)
        public int minCostConnectPoints2(int[][] points) {
            int n = points.length;
    
            boolean[] mst = new boolean[n];
            int[] minDist = new int[n];
            minDist[0] = 0;
            int mstCost = 0;
            int edgesUsed = 0;
    
            for(int i=1; i<n;i++){
                minDist[i] = Integer.MAX_VALUE;
            }
    
            while(edgesUsed < n){
                int minedge = Integer.MAX_VALUE;
                int currnode = -1;
    
                for(int node=0; node<n;node++){
                    if(!mst[node] && minedge> minDist[node]){
                        minedge = minDist[node];
                        currnode = node;
                    }
                }
    
                mst[currnode] = true;
                mstCost += minedge;
                edgesUsed++;
    
                for(int next=0; next<n;next++){
                    if(!mst[next]){
                        int nextwt = 
                        Math.abs(points[currnode][0] - points[next][0])+Math.abs(points[currnode][1] - points[next][1]);
                         if(!mst[next] && minDist[next] > nextwt){
                       minDist[next] = nextwt;
                    }
                    }
                }
            }
    
            return mstCost;
        }
    
}


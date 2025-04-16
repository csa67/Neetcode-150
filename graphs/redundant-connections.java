package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * We know that with the one extra edge, a cycle is formed. we are trying to find the cycle and the last edge in all edges to get the redundant edge.
 * TC- O(N),
 * SC-O(N)
 * 
 * We can also use a disjoint set union for when the graph grows denser, if we are trying to add an edge to already connected component, we can return it.
 */
class Solution {
    int cycleStart = -1;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

       boolean[] visited = new boolean[n];
       int[] parent = new int[n];
       Arrays.fill(parent,-1);

       List<Integer>[] adjList = new ArrayList[n];
       
       for(int i=0; i<n;i++){
        adjList[i] = new ArrayList<>();
       }

       for(int[] edge:edges){
        int u=edge[0];
        int v= edge[1];

        adjList[u-1].add(v-1);
        adjList[v-1].add(u-1);
       }

       dfs(0,visited,adjList,parent);
       
        Map<Integer, Integer> cycleNodes = new HashMap<>();
        int node = cycleStart;

        do{
            cycleNodes.put(node,1);
            node = parent[node];
        }while(node!=cycleStart);

        for(int i=edges.length-1; i>=0;i--){
            if(cycleNodes.containsKey(edges[i][0] - 1) && cycleNodes.containsKey(edges[i][1] - 1)){
                return edges[i];
            }
        }

        return new int[]{};

    }

    private void dfs(int src, boolean[] visited, List<Integer>[] adjList, int[] parent){
        visited[src] = true;

        for(int adj:adjList[src]){
            if(!visited[adj]){
                parent[adj] = src;
                dfs(adj,visited,adjList,parent);
            }else if(adj != parent[src] && cycleStart == -1){
                cycleStart = adj;
                parent[adj] = src;
            }
        }
    }
}
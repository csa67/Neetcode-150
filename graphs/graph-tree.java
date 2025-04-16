package graphs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //If there is a cycle, then it is not a tree.
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n;i++){
            adjList.add(new ArrayList<>());
        }


        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        
        if(!dfs(0,-1,visited,adjList)) return false;

        for(int i=0; i<n;i++){
            if(!visited[i]) return false;
        }

        return true;

    }

    private boolean dfs(int n, int parent,boolean[] visited, List<List<Integer>> adjList){

        visited[n] = true;
        for(int adj:adjList.get(n)){
            if(parent == adj) continue;

            if(visited[adj]) return false;

            if(!dfs(adj,n,visited,adjList)) return false;
        }

        return true;
    }
}

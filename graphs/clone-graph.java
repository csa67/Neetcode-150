package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        HashMap<Node,Node> visited = new HashMap<>();
        
        Queue<Node> queue = new LinkedList<>();
        visited.put(node,new Node(node.val));

        queue.offer(node);

        while(!queue.isEmpty()){

            Node curr = queue.poll();

            for(Node neighbor:curr.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val));
                    queue.add(neighbor);
                }
                
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}
package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size;i++){
                TreeNode current = queue.poll();
                if(i==size-1) res.add(current.val);

                if(current.left != null) queue.offer(current.left);
                if(current.right !=null) queue.offer(current.right);
            }
        }

        return res;
    }
}


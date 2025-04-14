package Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

class Solution{
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<Integer>();
            for(int i=0; i<size;i++){
                TreeNode currentNode = q.poll();
                currentLevel.add(currentNode.val);

                if(currentNode.left!=null) q.offer(currentNode.left);
                if(currentNode.right!=null) q.offer(currentNode.right);
            }
            res.add(currentLevel);
        }

        return res;

    }
}
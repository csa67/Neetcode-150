package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given the root of a binary tree, invert the tree, and return its root.
 */
class Solution {
    /*
     * Approach 1: Recursive solution
     */
    public TreeNode invertBinaryTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode left = invertBinaryTree(root.left);
        TreeNode right = invertBinaryTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
    /*
     * Approach 2: Iterative
     */
    public TreeNode invertBinaryTree2(TreeNode root){
        if(root == null){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left!=null)q.offer(curr.left);
            if(curr.right!=null)q.offer(curr.right);
        }
        return root;
    }

}

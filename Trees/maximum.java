package Trees;

/*
 * Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
class Solution{
    public int maximumDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = maximumDepth(root.left);
        int right = maximumDepth(root.right);

        return Math.max(left,right)+1;
    } 
}

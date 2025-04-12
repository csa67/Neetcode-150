package Trees;

/*
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer max, Integer min){
        if(root == null) return true;

        if(min!=null &&root.val <= min || max!=null && root.val >= max) return false;

        return helper(root.left,root.val,min) && helper(root.right,max,root.val);
    }
}
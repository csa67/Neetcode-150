package Trees;

/*
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root,Integer.MIN_VALUE);
    }

    private int helper(TreeNode root, int max){
        if(root==null) return 0;

        int count=0;
        if(root.val >= max){
            count++;
        }

        max=Math.max(max,root.val);
        return count+helper(root.left,max)+helper(root.right,max);
    }
}
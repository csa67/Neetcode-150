package Trees;

/*
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
class Solution {
    /*
     * check if the current path has maximum sum and then return the max side possible,since there's a possibility of having negative nodes
     * and you don't need to conisder them, make sure you check that for each left and right sums.
     */
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculateSum(root);
        return maxsum;
    }

    private int calculateSum(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftSum = Math.max(0,calculateSum(root.left));
        int rightsum = Math.max(0,calculateSum(root.right));

        maxsum = Math.max(leftSum+rightsum+root.val,maxsum);
        return Math.max(leftSum,rightsum)+root.val;
    }
}
package Trees;

/*
 * Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */
class Solution {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }

        calculateHeight(root);
        return maxDiameter;    
    }

    private int calculateHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);

        maxDiameter = Math.max(maxDiameter, left+right);

        return Math.max(left, right)+1;   
    }
}

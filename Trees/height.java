package Trees;

/*
 * Given a binary tree, determine if it is height-balanced.
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return getHeight(root)!= -1;
        
    }

    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = getHeight(root.left);
        if(lh == -1) return -1;

        int rh = getHeight(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh-rh) >= 2) return -1;

        return Math.max(lh,rh)+1;
    }
}

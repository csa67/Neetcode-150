package Trees;

import java.util.LinkedList;

/*
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
class Solution {
    /*
     * Inorder traversal of a BST gives sorted order, so go indorder and get kth element.
     */
    public int kthSmallest(TreeNode root, int k) {
       LinkedList<TreeNode> stack = new LinkedList<>();

       while(true){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }

        k=k-1;
        root = stack.pop();
        
        if(k==0) return root.val;
        root = root.right;
       }
    }
}
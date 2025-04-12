package Trees;

import java.util.HashMap;

/*
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();

        for(int i=0; i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }

        return helper(preorder,0,preorder.length-1,
        inorder,0,inorder.length-1,indexMap);
    }

    public TreeNode helper(int[] preorder, int prestart, int preend,
    int[] inorder, int instart, int inend,HashMap<Integer,Integer> indexMap){
        if(prestart > preend || instart > inend){
            return null;
        }  

        TreeNode root = new TreeNode(preorder[prestart]);
        int idx = indexMap.get(root.val);
        int len=idx-instart;
        root.left = helper(preorder,prestart+1,prestart+len,inorder,
            instart,idx-1,indexMap);
        root.right = helper(preorder,prestart+len+1,preend,inorder,idx+1,inend,indexMap);

        return root;

    }
}

package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class Codec {

    // Encodes a tree to a single string using level-order traversal
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                res.append("#,");
            } else {
                res.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (!nodes[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                current.left = left;
                queue.offer(left);
            }
            i++;

            if (!nodes[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                current.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
    }
}

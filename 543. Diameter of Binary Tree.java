/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;

        int cross = depth(root.left) + depth(root.right) + 2;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        return Math.max(cross, Math.max(left, right));
    }

    public int depth(TreeNode root) {
        if(root == null)return -1;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

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
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }
    private boolean symmetric(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)return true;
        if(root1 == null || root2 == null)return false;
        return (root1.val == root2.val) && symmetric(root1.left, root2.right) && symmetric(root1.right, root2.left);
    }
}

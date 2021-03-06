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
    public void flatten(TreeNode root) {
        if(root == null)return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);
        root.right = left;
        root.left = null;

        TreeNode temp = root;
        while(temp.right != null)temp = temp.right;
        temp.right = right;
    }
}

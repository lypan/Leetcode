/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int result = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        // root
        if(root == null) return false;
        // leaf
        if(root.left == null && root.right == null && sum - root.val == 0)return true;

        if(hasPathSum(root.left, sum - root.val))return true;
        if(hasPathSum(root.right, sum - root.val))return true;

        return false;
    }
}

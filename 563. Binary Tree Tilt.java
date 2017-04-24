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
    int tilt = 0;
    public int findTilt(TreeNode root) {
        calAcculumatedSum(root);
        return tilt;
    }
    public int calAcculumatedSum(TreeNode root) {
        if(root == null)return 0;

        int leftSum = calAcculumatedSum(root.left);
        int rightSum = calAcculumatedSum(root.right);

        tilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + root.val;
    }
}

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
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return count;
    }
    int helper(TreeNode root, int k) {
        if(root == null)return 0;
        int leftCount = helper(root.left, k);
        if(leftCount + 1== k)count = root.val;
        int rightCount = helper(root.right, k - (leftCount + 1));
        return leftCount + rightCount + 1;
    }
}

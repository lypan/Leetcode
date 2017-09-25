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
    public boolean isValidBST(TreeNode root) {
        // must pass max min for or using field as global parameter
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if(root == null)return true;
        if(root.val < min || root.val > max)return false;

        // bst must has distinct value, it cannot have duplicate
        return isValidBSTHelper(root.left, min, (long)root.val - 1) && isValidBSTHelper(root.right, (long)root.val + 1, max);
    }
}

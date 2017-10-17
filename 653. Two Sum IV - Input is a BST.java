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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return dfs(root, k, set);
    }
    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return (dfs(root.left, k, set) || dfs(root.right, k, set));
    }
}

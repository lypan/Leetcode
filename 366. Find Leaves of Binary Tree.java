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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        height(root, result);
        return result;
    }

    public int height(TreeNode root, List<List<Integer>> result) {
        if(root == null)return -1;

        int level = 1 + Math.max(height(root.left, result), height(root.right, result));
        if(result.size() < level + 1)result.add(new ArrayList<Integer>());
        result.get(level).add(root.val);

        return level;
    }
}

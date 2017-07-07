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
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode root) {
        if(root == null)return;
        convert(root.right);
        root.val += sum;
        sum = root.val;
        convert(root.left);
    }
}

// sol2
// public TreeNode convertBST(TreeNode root) {
//     dfs(root, 0);
//     return root;
// }
// public int dfs(TreeNode root, int val) {
//     if(root == null) return val;
//     int right = dfs(root.right, val);
//     int left = dfs(root.left, root.val + right);
//     root.val = root.val + right;
//     return left;
// }

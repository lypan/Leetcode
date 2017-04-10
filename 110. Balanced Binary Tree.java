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
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        else return dfs(root) != -1;
    }

    // if not balanced, return -1; else return height
    // optimize the original method because it won't calculate height for every node
    // (when get value is -1, we will immediately return, so we prune the tree nodes and not calculate height)
    public int dfs(TreeNode root) {
        if(root == null)return 0;

        int leftHeight = dfs(root.left);
        // skip so we won't calculate height
        if(leftHeight == -1)return -1;
        int rightHeight = dfs(root.right);
        // skip so we won't calculate height
        if(rightHeight == -1)return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)return -1;
        else return Math.max(leftHeight, rightHeight) + 1;

    }
}


// sol2
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// public class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if(root == null)return true;
//
//         boolean leftIsBalanced = isBalanced(root.left);
//         boolean rightIsBalanced = isBalanced(root.right);
//
//         int leftHeight = getHeight(root.left);
//         int rightHeight = getHeight(root.right);
//
//         if(leftIsBalanced && rightIsBalanced && Math.abs(leftHeight - rightHeight) <= 1)return true;
//         else return false;
//     }
//
//     public int getHeight(TreeNode root) {
//         if(root == null)return 0;
//
//         int leftHeight = getHeight(root.left);
//         int rightHeight = getHeight(root.right);
//
//         return Math.max(leftHeight, rightHeight) + 1;
//     }
// }

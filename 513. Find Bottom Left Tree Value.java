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
    private Queue<TreeNode> q;
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        q = new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            result = node.val;
            if(node.right != null)q.add(node.right);
            if(node.left != null)q.add(node.left);
        }

        return result;
    }
}

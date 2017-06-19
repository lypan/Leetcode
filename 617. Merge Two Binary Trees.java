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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)return null;
        
        int rootVal = 0;
        if(t1 != null)rootVal += t1.val;
        if(t2 != null)rootVal += t2.val;
        TreeNode root = new TreeNode(rootVal);
        
        TreeNode left = null;
        TreeNode right = null;

        if(t1 != null && t2 != null) {
            left = mergeTrees(t1.left, t2.left);
            right = mergeTrees(t1.right, t2.right);
        }
        else if(t1 == null && t2 != null) {
            left = mergeTrees(null, t2.left);
            right = mergeTrees(null, t2.right);            
        }
        else if(t1 != null && t2 == null) {
            left = mergeTrees(t1.left, null);
            right = mergeTrees(t1.right, null);            
        }
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}

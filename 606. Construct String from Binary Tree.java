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
    public String tree2str(TreeNode t) {
        if(t == null)return "";
        
        String leftStr = tree2str(t.left);
        String rightStr = tree2str(t.right);
        
        String resultStr = Integer.toString(t.val);
        
        
        if(t.left == null && t.right != null)resultStr += "()";

        if(t.left != null)resultStr += "(" + leftStr + ")";
        if(t.right != null)resultStr += "(" + rightStr + ")";
        
        return resultStr;
    }
}

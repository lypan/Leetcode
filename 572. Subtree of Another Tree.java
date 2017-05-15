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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sstr = traverse(s);
        String tstr = traverse(t);
        System.out.println(sstr);
        System.out.println(tstr);
        return sstr.contains(tstr);
    }

    String traverse(TreeNode root) {
        if(root == null)return "null";
        String str = "#" + String.valueOf(root.val);
        String left = traverse(root.left);
        String right = traverse(root.right);
        return str + left + right;
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
//     public boolean isSubtree(TreeNode s, TreeNode t) {
//         return traverse(s, t);
//     }
//
//     boolean traverse(TreeNode root1, TreeNode root2) {
//         if(root1 == null)return false;
//         if(subTreeEqual(root1, root2))return true;
//         return traverse(root1.left, root2) || traverse(root1.right, root2);
//     }
//
//     boolean subTreeEqual(TreeNode s, TreeNode t) {
//         if(s == null && t == null)return true;
//         if(s == null || t == null)return false;
//         return (s.val == t.val) && subTreeEqual(s.left, t.left) && subTreeEqual(s.right, t.right);
//     }
// }

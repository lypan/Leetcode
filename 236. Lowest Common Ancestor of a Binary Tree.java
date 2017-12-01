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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)return root;
        else if(left != null)return left;
        else if(right != null)return right;
        return null;

    }
}


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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parents.put(root, null);
        stack.push(root);

        // store each node's parent by preorder
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode node = stack.pop();
            if(node.right != null) {
                parents.put(node.right, node);
                stack.push(node.right);
            }
            if(node.left != null) {
                parents.put(node.left, node);
                stack.push(node.left);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while(p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }
        while(q != null) {
            if(ancestors.contains(q))break;
            q = parents.get(q);
        }

        return q;
    }
}


Node LCA(Node  n1, Node n2)
{
    Set<Node> set = new HashSet<>();
    while(n1 != null) {
        set.add(n1);
        n1 = n1.parent;
    }
    while(n2 != null) {
        if(set.contains(n2))return n2;
        set.add(n2);
        n2 = n2.parent;
    }
    return null;
}

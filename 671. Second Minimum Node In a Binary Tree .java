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
    public int findSecondMinimumValue(TreeNode root) {
        // base case is 0 or 2 children for a node
        if(root == null)return -1;
        if(root.left == null && root.right == null)return -1;

        int left = root.left.val;
        int right = root.right.val;

        // if left/right value is the same, then the left/right's value is not second minimum
        // has to recursively found its children
        // then compare it with another left/right which is not the same value as root
        // if left
        if(root.val == left)left = findSecondMinimumValue(root.left);
        if(root.val == right)right = findSecondMinimumValue(root.right);

        if(left == -1)return right;
        if(right == -1)return left;

        return Math.min(left, right);
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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)return -1;
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int value) {
        if(root == null)return -1;
        // since other will larger then root
        if(root.val > value)return root.val;
        if(root.left == null && root.right == null)return -1;

        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);

        if(left == -1)return right;
        if(right == -1)return left;

        return Math.min(left, right);
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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int first = root.val;
        int second = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.val != first)second = Math.min(second, node.val);

            if(node.left != null)queue.offer(node.left);
            if(node.right != null)queue.offer(node.right);
        }
        if(second == Integer.MAX_VALUE)return -1;
        return second;
    }
}

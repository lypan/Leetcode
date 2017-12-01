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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;

        queue.offer(root);

        int level = 0;
        while(!queue.isEmpty()) {
            result.add(new ArrayList<>());

            int size = queue.size();

            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                result.get(level).add(node.val);
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }

            level ++;
        }

        return result;
    }
}

//DFS
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null)return;
        if(level >= result.size())result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;

        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();

            int size = queue.size();

            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
            result.add(0, tempList);
        }

        return result;
    }
}

// DFS
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null)return;
        if(level >= result.size())result.add(0, new ArrayList<>());
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
        // ex: 3 levels from 0 ~ 2, result size should have 3 for 3 levels
        result.get((result.size() - 1) - level).add(root.val);
    }
}

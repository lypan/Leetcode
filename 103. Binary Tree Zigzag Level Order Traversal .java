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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if(root == null)return;

        if(result.size() <= level) {
            List<Integer> tempList = new ArrayList<>();
            result.add(tempList);
        }

        List<Integer> levelList  = result.get(level);
        if(level % 2 == 0) levelList.add(root.val);
        else levelList.add(0, root.val);

        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if(reverse) tempList.add(0, node.val);
                else tempList.add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(tempList);
            reverse = !reverse;
        }

        return result;
    }

}

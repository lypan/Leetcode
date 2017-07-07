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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)return result;
        bfs(root, result);

        return result;
    }

    public void bfs(TreeNode root, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(queue.size() != 0) {
            int nodesInCurrentLevel = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i = 0; i < nodesInCurrentLevel; i ++) {
                TreeNode node = queue.poll();
                maxValue = node.val > maxValue ? node.val : maxValue;

                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);

            }
            result.add(maxValue);
        }
    }
}

// sol2
// public class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//
//         if(root == null)return result;
//         dfs(root, result, 0);
//
//         return result;
//     }
//
//     public void dfs(TreeNode root, List<Integer> result, int height) {
//         if(root == null)return;
//
//         if(height == result.size())result.add(root.val);
//         else result.set(height, Math.max(result.get(height), root.val));
//
//         dfs(root.left, result, height + 1);
//         dfs(root.right, result, height + 1);
//
//     }
// }

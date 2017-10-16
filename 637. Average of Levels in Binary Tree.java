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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)return result;

        queue.offer(root);

        while(queue.size() != 0) {
            int size = queue.size();
            double sum = 0;
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
                sum += node.val;
            }
            sum /= size;
            result.add(sum);
        }
        return result;
    }
}


// DFS
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public List<Double> averageOfLevels(TreeNode root) {
//         List<Double> result = new ArrayList<>();
//         List <Integer> count = new ArrayList<>();
//         List <Double> sum = new ArrayList<>();
//         if (root == null) return result;
//         dfs(root, sum, count, 0);
//
//         for (int i = 0; i < sum.size(); i++)
//             result.add(i, sum.get(i) / count.get(i));
//
//         return result;
//     }
//
//     private void dfs(TreeNode root, List<Double> sum, List <Integer> count, int level) {
//         if (root == null)return;
//         // indicates the level already has some numbers
//         if (level < sum.size()) {
//             sum.set(level, sum.get(level) + root.val);
//             count.set(level, count.get(level) + 1);
//         } else {
//             // the first number in the level
//             sum.add(1.0 * root.val);
//             count.add(1);
//         }
//         dfs(root.left, sum, count, level + 1);
//         dfs(root.right, sum, count, level + 1);
//     }
// }

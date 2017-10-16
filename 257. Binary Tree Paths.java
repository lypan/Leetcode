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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null)return result;
        dfs(root, result, "");
        return result;
    }
    private void dfs(TreeNode root, List<String> result, String path) {
        if(root.left == null && root.right == null)result.add(path + root.val);
        if(root.left != null)dfs(root.left, result, path + root.val + "->");
        if(root.right != null)dfs(root.right, result, path + root.val + "->");
    }
}

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
//     public List<String> binaryTreePaths(TreeNode root) {
//         List<String> resultList = new ArrayList<String>();
//
//         if(root == null)return resultList;
//         else dfs(root, "", resultList);
//
//         return resultList;
//     }
//
//     public void dfs(TreeNode root, String str, List<String> resultList) {
//         if(root == null)return;
//
//         // leaf node
//         if(root.left == null && root.right == null) {
//             str = str.concat(String.valueOf(root.val));
//             resultList.add(str);
//             return;
//         }
//         else {
//             str = str.concat(String.valueOf(root.val));
//             str = str.concat("->");
//         }
//         dfs(root.left, str, resultList);
//         dfs(root.right, str, resultList);
//     }
//
// }



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
//     public List<String> binaryTreePaths(TreeNode root) {
//         List<String> resultList = new ArrayList<String>();
//         // check if root is null or not
//         if(root == null)return resultList;
//
//         String resultStr = String.valueOf(root.val);
//         // check if only root or not
//         if(root.left == null && root.right == null) {
//             resultList.add(resultStr);
//             return resultList;
//         }
//
//         dfs(root.left, resultStr, resultList);
//         dfs(root.right, resultStr, resultList);
//         return resultList;
//     }
//     public void dfs(TreeNode root, String str, List<String> resultList) {
//         if(root == null)return;
//
//         str = str.concat("->");
//         str = str.concat(String.valueOf(root.val));
//         // leaf node
//         if(root.left == null && root.right == null) {
//             // System.out.println(str);
//             resultList.add(str);
//             return;
//         }
//         dfs(root.left, str, resultList);
//         dfs(root.right, str, resultList);
//     }
//
// }

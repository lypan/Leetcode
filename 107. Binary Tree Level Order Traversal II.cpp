/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        int height = getTreeHeight(root);
        vector<vector<int>> result(height + 1, vector<int>{});

        reverseLevelOrder(result, root, height);

        return result;
    }
    // just walk the normal level order but store the index in reverse order
    void reverseLevelOrder(vector<vector<int>> & result, TreeNode* root, int height) {
        if(root == NULL)return;

        result[height].push_back(root->val);

        reverseLevelOrder(result, root->left, height - 1);
        reverseLevelOrder(result, root->right, height - 1);
    }

    int getTreeHeight(TreeNode* root) {
        if(root == NULL)return -1;

        int leftHeight = getTreeHeight(root->left);
        int rightHeight = getTreeHeight(root->right);

        return max(leftHeight, rightHeight) + 1;
    }
};

// reference:http://www.geeksforgeeks.org/level-order-tree-traversal/
// reference:http://www.geeksforgeeks.org/reverse-level-order-traversal/

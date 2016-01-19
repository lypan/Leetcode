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
    int maxDepth(TreeNode* root) {
    	if(root == NULL)return 0;
        int len_left = maxDepth(root->left);
        int len_right = maxDepth(root->right);
        return max(len_left, len_right) + 1;
    }
};
// traverse tree fully and return length
// using preorder
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
    int countNodes(TreeNode* root) {
        if(root == NULL)return 0;
        else if(root->left == NULL && root->right == NULL)return 1;
        int hl = 0, hr = 0;
        TreeNode *left = root, *right = root;
        while(left != NULL) {
            hl ++;
            left = left->left;
        }
         while(right != NULL) {
            hr ++;
            right = right->right;
        } 
        if(hl == hr)return (1 << hl) - 1;
        return countNodes(root->left) + countNodes(root->right) + 1;
    }
};
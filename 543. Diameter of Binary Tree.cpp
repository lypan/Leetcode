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
    int diameterOfBinaryTree(TreeNode* root) {
        if(root == NULL)return 0;
        int lh, rh;
        int ld = getHeightAndDiameter(root->left, lh);
        int rd = getHeightAndDiameter(root->right, rh);
        return max(lh + rh + 2, max(ld, rd));
    }
    // return diameter, use reference to return h
    int getHeightAndDiameter(TreeNode* root, int& h) {
        if(root == NULL) {
            h = -1;
            return 0;
        }
        int lh, rh;
        int ld = getHeightAndDiameter(root->left, lh);
        int rd = getHeightAndDiameter(root->right, rh);

        h = max(lh, rh) + 1;

        return max(lh + rh + 2, max(ld, rd));
    }

};

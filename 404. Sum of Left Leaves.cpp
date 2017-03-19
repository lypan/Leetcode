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
    int sumOfLeftLeaves(TreeNode* root, bool isLeft = false) {
        if(root == NULL)return 0;
        int sum = 0;

        if(isLeft && root->left == NULL && root->right == NULL)sum += root->val;
        if(root->left != NULL) {
            sum += sumOfLeftLeaves(root->left, true);
        }
        if(root->right != NULL){
            sum += sumOfLeftLeaves(root->right, false);
        }
        return sum;
    }
};

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
    int pathSum(TreeNode* root, int sum) {
        if(root == NULL)return 0;
        return pathSum(root->left, sum) + pathSum(root->right, sum) + DPS(root, sum);
    }
    // because node only go downwards
    int DPS(TreeNode* root, int sum) {
        if(root == NULL)return 0;
        int count = 0;
        int offset = sum - root->val;

        if(root->val == sum) count ++;

        count += DPS(root->left, offset);
        count += DPS(root->right, offset);

        return count;
    }
};

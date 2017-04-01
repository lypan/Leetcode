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
    int closestValue(TreeNode* root, double target) {

        int parentVal = root->val;

        auto child = target < parentVal ? root->left : root->right;

        if(child == NULL)return parentVal;

        int childVal = closestValue(child, target);

        if(abs(target - parentVal) < abs(target - childVal))return parentVal;
        else return childVal;

    }
};

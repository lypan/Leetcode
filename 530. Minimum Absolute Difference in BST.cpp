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
    int getMinimumDifference(TreeNode* root) {
        vector<int> sorted;
        // in-order:due to bst, in order will be sorted data
        inOrder(root, sorted);

        int min = INT_MAX;
        for(int i = 1; i < sorted.size(); i ++) {
            int diff = abs(sorted[i] - sorted[i - 1]);
            min = diff < min ? diff : min;
        }
        return min;
    }

    void inOrder(TreeNode* root, vector<int>& sortedVec) {
        if(root == NULL) return;
        inOrder(root->left, sortedVec);
        sortedVec.push_back(root->val);
        inOrder(root->right, sortedVec);
    }
};

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
    vector<int> findMode(TreeNode* root) {
        unordered_map<int, int> map;
        vector<int> result;
        int maxCount = getMaxCount(root, map);

        for(auto p : map) {
            if(p.second == maxCount)result.push_back(p.first);
        }

        return result;
    }
    int getMaxCount(TreeNode* root, unordered_map<int, int> &map) {
        if(root == NULL)return 0;

        int val = root->val;

        map[val] ++;

        int lval = getMaxCount(root->left, map);
        int rval = getMaxCount(root->right, map);

        return max(map[val], max(lval, rval));
    }
};

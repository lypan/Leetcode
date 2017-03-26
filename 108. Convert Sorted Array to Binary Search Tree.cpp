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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if(nums.size() == 0)return NULL;

        TreeNode *root = constructBST(nums, 0, nums.size() - 1);
        return root;
    }

    TreeNode* constructBST(vector<int>& nums, int left, int right) {
            // when left == right, a single element
            // left will increase or right will decrease, so it is marginal condition
            if(left > right)return NULL;

            // choose the right if size of a array is even, ex: two elements [0, 1], we will choose 1 as the root
            int middle = (left + right + 1) / 2;

            TreeNode *root = new TreeNode(nums[middle]);
            root->left = constructBST(nums, left, middle - 1);
            root->right = constructBST(nums, middle + 1, right);

            return root;
    }
};

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
    bool isSymmetric(TreeNode* root) {
        if(root == NULL)return true;
        TreeNode *left = root->left;
        TreeNode *right = root->right;

        if(left == NULL && right == NULL)return true;
        else if(left == NULL || right == NULL)return false;
        else if(left->val != right->val)return false;
        else return isMirror(left, right);
    }

    bool isMirror(TreeNode* left, TreeNode* right) {
        if(left == NULL && right == NULL)return true;
        else if(left == NULL || right == NULL)return false;
        else if(left->val != right->val)return false;
        else return isMirror(left->left, right->right) && isMirror(left->right, right->left);
    }
};

// sol2
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// class Solution {
// public:
//     bool isSymmetric(TreeNode* root) {
//         queue<TreeNode*> myQueue;
//
//         if(root == NULL)return true;
//         // TreeNode* left = root->left;
//         // TreeNode* right = root->right;
//
//
//
//         myQueue.push(root->left);
//         myQueue.push(root->right);
//
//
//         while(!myQueue.empty()) {
//
//             TreeNode* left = myQueue.front();
//             myQueue.pop();
//
//             TreeNode* right = myQueue.front();
//             myQueue.pop();
//
//             if(left == NULL && right == NULL)continue;
//             else if(left == NULL || right == NULL)return false;
//             else if(left->val != right->val)return false;
//
//             myQueue.push(left->left);
//             myQueue.push(right->right);
//             myQueue.push(left->right);
//             myQueue.push(right->left);
//         }
//
//         return true;
//
//     }
// };

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 // recursive version
// class Solution {
// public:
//     TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
//         if(p->val < root->val && q->val < root->val) {
//             root = lowestCommonAncestor(root->left, p , q);
//         }
//         else if(p->val > root->val && q->val > root->val) {
//             root = lowestCommonAncestor(root->right, p , q);
//         }
//         return root;
//     }
// };
// iterative version
// class Solution {
// public:
//     TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
//         TreeNode* current = root;
//         while(true) {
//             if(p->val < current->val && q->val < current->val) {
//                 current = current->left;
//             }
//             else if(p->val > current->val && q->val > current->val) {
//                 current = current->right;
//             }
//             else return current;
//         }
//     }
// };

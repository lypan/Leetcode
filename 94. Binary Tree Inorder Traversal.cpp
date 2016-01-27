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
    vector<int> inorderTraversal(TreeNode* root) {
    	vector<int> nodevec;
    	stack<TreeNode*> nodestack;
    	while(!nodestack.empty() || root != NULL) {
    	    if(root != NULL) {
    	    	nodestack.push(root);
 				root = root->left;
    	    }
    	    else {
    	    	root = nodestack.top();
    	    	nodevec.push_back(root->val);
    	    	nodestack.pop();
    	    	root = root->right;
    	    }
    	}
    	return nodevec;    
    }
};
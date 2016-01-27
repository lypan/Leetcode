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
    vector<int> preorderTraversal(TreeNode* root) {
    	vector<int> nodevec;
    	stack<TreeNode*> nodestack;
    	while(!nodestack.empty() || root != NULL) {
    	    if(root != NULL) {
    	    	nodevec.push_back(root->val);
    	    	if (root->right != NULL) {
    	    		nodestack.push(root->right);
    	    	}
	    		root = root->left;
    	    }
    	    else {
    	    	root = nodestack.top();
    	    	nodestack.pop();
    	    }
    	}
    	return nodevec;
    }
};
// recursive version
/*class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
    	vector<int> result;
		vector<int> left;
    	vector<int> right;

		if(!root)return result;    	

		result.push_back(root->val);
        left = preorderTraversal(root->left);
        right = preorderTraversal(root->right);

        if(left.size() != 0)result.insert(result.end(), left.begin(), left.end());
        if(right.size() != 0)result.insert(result.end(), right.begin(), right.end());    		    		
    	
    	return result;
    }
};*/
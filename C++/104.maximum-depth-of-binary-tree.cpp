/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution{
public:
    int maxDepth(TreeNode* root){
        if(root==NULL){
            return 0;
        }else{
            int left_d=maxDepth(root->left);
            int right_d=maxDepth(root->right);
            return max(left_d,right_d)+1;
        }
    }
};
//回溯法
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        if(n)
            backtrack("",0,0,n);
        return ans;
    }
public:
    vector<string> ans;
    void backtrack(string cur,int left,int right,int n){
        if(cur.length()==n*2){
            ans.push_back(cur);
            return;
        }
        if(left<n)
            backtrack(cur+"(",left+1,right,n);
        if(right<left)
            backtrack(cur+")",left,right+1,n);
        
    }
};
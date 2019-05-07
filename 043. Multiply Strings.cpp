class Solution {
public:
    string multiply(string num1, string num2) {
        int n=num1.size(),m=num2.size();
        string ret;
        vector<int> v(n+m,0);
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                int temp=v[i+j]+(num1[n-i-1]-'0')*(num2[m-j-1]-'0');
                v[i+j]=temp%10;
                v[i+j+1]+=temp/10;
            }
        }
        int flag=0;
        for(int k=n+m-1;k>=0;--k){
            if(flag==0)
                if(v[k]!=0) flag=1;
            if(flag==1) ret+=to_string(v[k]);
        }
        return ret==""?"0":ret;
    }
};
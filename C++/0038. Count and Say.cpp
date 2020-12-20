class Solution {
public:
    string countAndSay(int n) {
        if(n==1)return "1";
        if(n==2)return "11";
        string p="11",temp="";
        for(int i=2;i<n;++i){
            temp=p;
            p="";
            int k=0,m=1;
            while(k<temp.size()){
                while(temp[m]==temp[k]){
                    ++m;
                }
                int l=m-k;
                p+=to_string(l)+temp[k];
                k=m;
                m=k+1;
            }
        }
        return p;
    }
};

class Solution {
public:
    string countAndSay(int n) {
        if(n == 1) return "1";
        string re="";
        string pre=countAndSay(n-1);
        int count=1;
        for(int i=0;i<pre.size();++i){
            if(pre[i]==pre[i+1]){
                ++count;
            }
            else{
                re+=to_string(count)+pre[i];
                count=1;
            }
        }
        return re;
    }
};
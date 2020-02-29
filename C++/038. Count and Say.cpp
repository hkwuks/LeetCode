class Solution {
public:
    string countAndSay(int n) {
        string p="11",temp="";
        int t=1;
        for(int i=2;i<=n;++i){
            temp=p;
            p="";
            int k=0,m=1;
            while(k<temp.length()&&m<temp.length()){
                while(temp[m]==temp[k])++m;
                p+=(char)m-k+1;
                p+=temp[k];
                k=m;
                ++m;
            }
        }
        return p;
    }
};
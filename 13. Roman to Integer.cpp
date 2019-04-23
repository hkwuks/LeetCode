class Solution {
public:
    int romanToInt(string s) {
        map<char,int> m;
        int ans=0;
        int a[]={1,5,10,50,100,500,1000};
        char b[]={'I','V','X','L','C','D','M'};
        for(int i=0;i<7;++i)
            m.insert(pair<char,int> (b[i],a[i]));
        for(int j=0;j<s.length()-1;++j){
            if(m[s[j]]>=m[s[j+1]])
                ans+=m[s[j]];
            else
                ans-=m[s[j]];
        }
        ans+=m[s[s.length()-1]];
        return ans;
    }
};
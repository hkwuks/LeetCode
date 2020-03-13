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

class Solution {
public:
    int romanToInt(string s) {
        int num=0;
        map<char,int> m={{'I',1},{'V',5},{'X', 10},{'L', 50} ,{'C', 100} ,{'D', 500} ,{'M', 1000} };
        for(int i=0;i<s.size();++i){
            if(m[s[i]]>=m[s[i+1]])
                num=num+m[s[i]];
            else{
                num=num+m[s[i+1]]-m[s[i]];
                ++i;
            }
        }
        return num;
    }
};
class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.empty()) return 0;
        if(haystack.empty())return -1;
        int pos=haystack.find(needle);
        if(pos==-1) return -1;
        return pos;
    }
};

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.empty()) return 0;
        if(haystack.empty())return -1;
        int len1=haystack.size();
        int len2=needle.size();
        for(int i=0;i<=len1-len2;++i)
            for(int j=0;j<len2&&haystack[i+j]==needle[j];++j)
                if(j==len2-1)return i;
        return -1;
    }
};
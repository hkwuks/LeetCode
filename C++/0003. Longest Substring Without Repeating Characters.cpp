class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start=0,end=0,len=0,result=0;
        int sLen=s.size();
        while(end<sLen){
            char c=s[end];
            for(int i=start;i<end;++i){
                if(c==s[i]){
                    start=i+1;
                    len=end-start;
                    break;
                }
            }
            ++end;
            ++len;
            result=max(result,len);
        }
        return result;
    }
};

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start=0,end=0,len=0,result=0;
        int sLen=s.size();
        unordered_map<char,int> hash;
        while(end<sLen){
            char c=s[end];
            if(hash.find(c)!=hash.end()&&hash[c]>=start){
                start=hash[c]+1;
                len=end-start;
            }
            hash[c]=end;
            ++end;
            ++len;
            result=max(result,len);
        }
        return result;
    }
};
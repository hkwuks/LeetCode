//官方题解
class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1)return s;
        vector<string> rows(min(numRows,int(s.size())));//测试用例中没有超过s.size()的用例，可不用min()
        int curRow=0;
        bool goingDown=false;
        for(char c:s){
            rows[curRow]+=c;
            if(curRow==0||curRow==numRows-1) goingDown=!goingDown;
            curRow+=goingDown?1:-1;
        }
        string ret;
        for(string row:rows) ret+=row;
        return ret;
    }
};
//第二种解法
class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1)return s;
        string ret;
        for(int i=0;i<numRows;++i){
            for(int j=i;j<s.size();j+=2*(numRows-1)){
                ret+=s[j];
                if(i!=0&&i!=numRows-1&&j+2*(numRows-1-i)<s.size())
                    ret+=s[j+2*(numRows-1-i)];
            }
        }
        return ret;
    }
};

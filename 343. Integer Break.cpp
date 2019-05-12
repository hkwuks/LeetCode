//参照柳神解法
class Solution {
public:
    int integerBreak(int n) {
        if(n<=3)return n-1;
        int ret=1;
        while(n>2){
            ret*=3;
            n-=3;
        }
        if(n==1)
            return ret/3*4;
        else if(n==2)
            return ret*2;
        else
            return ret;
    }
};
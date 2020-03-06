class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len=prices.size();
        if(len==0)return 0;
        int *dp1=new int[len];
        int *dp2=new int[len];
        int ans=0;
        left(prices,dp1,len);
        right(prices,dp2,len);
        for(int i=0;i<len;++i)
            ans=max(ans,dp1[i]+dp2[i]);
        return ans;
    }

    void left(vector<int>prices,int *&dp1,int len){
        int ans=0;
        int low=prices[0];
        for(int i=0;i<len;++i){
            ans=max(ans,prices[i]-low);
            dp1[i]=ans;
            low=min(low,prices[i]);
        }
    }
    void right(vector<int>prices,int *&dp2,int len){
        int ans=0;
        int high=prices[len-1];
        for(int i=len-1;i>=0;--i){
            ans=max(ans,high-prices[i]);
            dp2[i]=ans;
            high=max(high,prices[i]);
        }
    }
};
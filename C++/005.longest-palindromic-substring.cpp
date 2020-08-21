//方法一：动态规划
class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n));
        string ans;
        for (int len = 0; len < n; ++len) {
            for (int i = 0; i + len < n; ++i) {
                int j = i + len;
                if (len == 0) {
                    dp[i][j] = 1;
                }
                else if (len == 1) {
                    dp[i][j] = (s[i] == s[j]);
                }
                else {
                    dp[i][j] = (s[i] == s[j] && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && len + 1 > ans.size()) {
                    ans = s.substr(i, len + 1);
                }
            }
        }
        return ans;
    }
};


//方法二：
class Solution {
public:
    string longestPalindrome(string s) {
        if (s.size() <= 1)return s;
        int start = 0, end = 0, len = 0;
        for (int i = 0;i < s.size();++i) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            len = max(max(len1, len2), len);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substr(start, len);
    }
private:
    int expandAroundCenter(string s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.size() && s[L] == s[R]) {
            --L;
            ++R;
        }
        return R - L - 1;
    }
};
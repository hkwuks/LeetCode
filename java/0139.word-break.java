// 动态规划
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}


// 优化
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet wordDictSet=new HashSet();
        int maxLen = 0;
        for (String word : wordDict) {
            wordDictSet.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = i; j >= i - maxLen && j >= 0; --j) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
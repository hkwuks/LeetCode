class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            ++cnt[ch - 'a'];
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            --cnt[ch - 'a'];
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
}

class Solution {
    public char findTheDifference(String s,String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }
}

class Solution {
    public char findTheDifference(String s,String t) {
        return (char) (s + t).chars().reduce(0, (a, b) -> a ^ b);
    }
}

class Solution {
    public char findTheDifference(String s,String t) {
        char re = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); ++i) {
            re ^= s.charAt(i) ^ t.charAt(i);
        }
        return re;
    }
}
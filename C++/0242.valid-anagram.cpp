class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() == 0 && t.size() == 0) return true;
        if (s.size() != t.size()) return false;
        unordered_map<char, int> count;
        for (int i = 0;i < s.size();++i) {
            ++count[s[i]];
            --count[t[i]];
        }
        for (int j = 0;j < s.size();++j) {
            if (count[s[j]] != 0)
                return false;
        }
        return true;
    }
};

class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() == 0 && t.size() == 0) return true;
        if (s.size() != t.size()) return false;
        unordered_map<char, int> count;
        for (const char& i : s) {
            ++count[i];
        };
        for (const char& j : t) {
            --count[j];
            if (count[j] < 0)
                return false;
        }
        return true;
    }
};
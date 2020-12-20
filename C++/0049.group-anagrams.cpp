//排序
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ret;
        if (strs.empty()) return ret;
        unordered_map<string, vector<string>> map;
        for (string& s : strs) {
            string t = s;
            sort(t.begin(), t.end());
            map[t].emplace_back(s);
        }
        for (auto& n : map) {
            ret.emplace_back(n.second);
        }
        return ret;
    }
};

//按计数分类
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ret;
        if (strs.empty()) return ret;
        unordered_map<string, vector<string>> map;
        for (const string& s : strs) {
            vector<int> cnt(26, 0);
            for (char& c : s) {
                ++cnt[c - 'a'];
            }
            string tmp;
            for (int i = 0;i < 26;++i) {
                tmp += '#';
                tmp += cnt[i];
            }
            map[tmp].emplace_back(s);
        }
        for (const auto& n : map) {
            ret.emplace_back(n.second);
        }
        return ret;
    }
};
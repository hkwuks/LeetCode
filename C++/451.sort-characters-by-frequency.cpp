class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> map;
        for (char c : s) {
            ++map[c];
        }
        priority_queue<pair<int, char>> pd;
        for (const auto m : map) {
            pd.push({ m.second,m.first });
        }
        string ans;
        while (!pd.empty()) {
            auto t = pd.top();
            pd.pop();
            ans.append(t.first, t.second);
        }
        return ans;
    }
};
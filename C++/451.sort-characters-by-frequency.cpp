//自定义排序
class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> map;
        for (const char& c : s) {
            ++map[c];
        }
        vector<pair<char, int>> vec;
        for (const auto& m : map) {
            vec.emplace_back(m);
        }
        sort(vec.begin(), vec.end(), [](const pair<char, int>& p1, const pair<char, int>& p2) { return p1.second > p2.second; });
        string ret;
        for (const auto& v : vec) {
            ret += string(v.second, v.first);
        }
        return ret;
    }
};

//优先队列
class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> map;
        for (const char& c : s) {
            ++map[c];
        }
        priority_queue<pair<int, char>> pq;
        for (const auto& m : map) {
            pq.push({ m.second, m.first });
        }
        string ret;
        while (!pd.empty()) {
            auto t = pq.top();
            pq.pop();
            ret.append(t.first, t.second);
        }
        return ret;
    }
};

//数组下标索引
class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> ump;
        for (const auto& c : s) {
            ++ump[c];
        }
        vector<string> vec(s.size() + 1);
        string res;
        for (const auto& m : ump) {
            vec[m.second].append(m.second, m.first);
        }
        for (int i = s.size(); i > 0; --i) {
            if (!vec[i].empty()) {
                res.append(vec[i]);
            }
        }
        return res;
    }
};

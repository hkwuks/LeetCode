class Solution {
public:
    bool wordPattern(string pattern, string str) {
        unordered_map<char, string> map;
        unordered_map<string, char> rmap;
        stringstream ss(str);string s;
        for (const char& c : pattern) {
            if (!(ss >> s) || (map.count(c) && map[c] != s) || (rmap.count(s) && rmap[s] != c)) return false;
            map[c] = s;rmap[s] = c;
        }
        return (ss >> s) ? false : true;
    }
};
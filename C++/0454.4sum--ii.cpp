class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        unordered_map<int, int>map;
        for (const int& a : A) {
            for (const int& b : B) {
                ++map[a + b];
            }
        }
        int ret = 0;
        for (const int& c : C) {
            for (const int& d : D) {
                if (map.count(-(c + d)))
                    ret += map[-(c + d)];
            }
        }
        return ret;
    }
};
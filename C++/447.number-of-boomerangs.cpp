class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        int ans = 0;
        for (int i = 0;i < points.size();++i) {
            unordered_map<int, int>map;
            for (int j = 0;j < points.size();++j) {
                if (i == j) continue;
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                ++map[dx * dx + dy * dy];
            }
            for (const auto& m : map) {
                ans += m.second * (m.second - 1);
            }
        }
        return ans;
    }
};
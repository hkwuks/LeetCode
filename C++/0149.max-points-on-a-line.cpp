class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        if (points.size() < 3) return points.size();
        int ret = 0;
        for (int i = 0;i < points.size();++i) {
            int duplicate = 0;
            int maxp = 0;//当前线上点的个数
            unordered_map <string, int> map;
            for (int j = i + 1;j < points.size();++j) {
                //求斜率的分子、分母
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if (dx == 0 && dy == 0) {
                    ++duplicate;
                    continue;
                }
                //约分
                int gcd = getgcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                string key = to_string(dx) + "@" + to_string(dy);
                ++map[key];
                maxp = max(maxp, map[key]);
            }
            ret = max(ret, maxp + duplicate + 1);
        }
        return ret;
    }
private:
    int getgcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
};
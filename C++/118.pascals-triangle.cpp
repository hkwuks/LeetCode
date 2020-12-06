class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> re(numRows);
        for (int i = 0;i < numRows;++i) {
            re[i].resize(i + 1);//resize():设置大小
            re[i][0] = re[i][i] = 1;
            for (int j = 1;j < i;++j) {
                re[i][j] = re[i - 1][j - 1] + re[i - 1][j];
            }
        }
        return re;
    }
};
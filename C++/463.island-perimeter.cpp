class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        int count = 0;
        int edge = 0;
        for (int i = 0;i < m;++i) {
            for (int j = 0;j < n;++j) {
                if (grid[i][j]) {
                    ++count;
                    if (i + 1 < m)
                        if (grid[i + 1][j] == 1) ++edge;
                    if (j + 1 < n)
                        if (grid[i][j + 1] == 1) ++edge;
                }
            }

        }
        return 4 * count - 2 * edge;
    }
};
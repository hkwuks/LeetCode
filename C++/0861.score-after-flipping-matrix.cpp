//code 1
class Solution {
public:
    int matrixScore(vector<vector<int>>& A) {
        int m = A.size();
        int n = A[0].size();
        for (int i = 0;i < m;++i) {
            if (A[i][0] == 0) {
                for (int j = 0;j < n;++j) {
                    A[i][j] = !A[i][j];
                }
            }
        }

        for (int j = 1;j < n;++j) {
            int col_sum = 0;
            for (int i = 0;i < m;++i) {
                col_sum += A[i][j];
            }
            if (col_sum < (m + 1) / 2) {
                for (int k = 0;k < m;++k) {
                    A[k][j] = !A[k][j];
                }
            }
        }
        return sumA(A, m, n);
    }

private:
    int sumA(vector<vector<int>> A, int m, int n) {
        int re = 0;
        for (int i = 0;i < m;++i) {
            for (int j = 0;j < n;++j) {
                if (A[i][j] == 1) {
                    re += pow(2, n - j - 1);
                }
            }
        }
        return re;
    }
};

//code 2
class Solution {
public:
    int matrixScore(vector<vector<int>>& A) {
        int m = A.size(), n = A[0].size();
        int ret = m * (1 << (n - 1));

        for (int j = 1;j < n;++j) {
            int colSum = 0;
            for (int i = 0;i < m;++i) {
                if (A[i][0] == 1) {
                    colSum += A[i][j];
                }                
else {
                    colSum += 1 - A[i][j];
                }
            }
            int k = max(colSum, m - colSum);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }
};
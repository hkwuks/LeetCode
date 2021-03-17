class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int left = 0,right=m-1,top=0,bottom=n-1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; ++j) {
                res.add(matrix[top][j]);
            }
            for (int i = top+1; i <= bottom; ++i) {
                res.add(matrix[i][right]);
            }
            if(left<right&&top<bottom){ // 解决非方阵的特殊情况
                for (int j = right-1; j >= left; --j) {
                    res.add(matrix[bottom][j]);
                }
                for (int i = bottom-1; i > top; --i) {
                    res.add(matrix[i][left]);
                }
            }
            ++top;
            --bottom;
            ++left;
            --right;
        }
        return res;
    }
}
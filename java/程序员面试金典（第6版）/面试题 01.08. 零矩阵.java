import java.util.HashSet;

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        for (Integer i : rowSet) {
            setRowZeroes(matrix, n, m, i);
        }
        for (Integer j : colSet) {
            setColZeroes(matrix, n, m, j);
        }
    }
    
    public void setColZeroes(int[][] matrix, int n, int m, int col) {
        for (int i = 0; i < n; ++i) {
            matrix[i][col] = 0;
        }
    }
    
    public void setRowZeroes(int[][] matrix, int n, int m, int row) {
        for (int j = 0; j < m; ++j) {
            matrix[row][j] = 0;
        }
    }
}
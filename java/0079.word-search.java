class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (check(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {

        if (board[i][j] != s.charAt(k)) {
            return false;
        }
        if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length && !visited[newi][newj]) {
                if(check(board, visited, newi, newj, s, k + 1))
                result = true;
            }
        }
        visited[i][j] = false;
        return result;
    }
}
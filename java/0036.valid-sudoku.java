class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9;++i){
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i]=new HashMap<Integer, Integer>();
        }
        
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = i / 3 * 3 + j / 3;
                    
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n,columns[j].getOrDefault(n, 0) +1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
                    
                    if(rows[i].get(n)>1||columns[j].get(n) > 1 ||boxes[box_index].get(n)>1){
                        return false;
                    }
                }                
            }
        }
        return true;
    }
}

class Solution {
    //官方用的hashmap，但采用数组更方便
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sbox = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    int index_box = (i/3)*3+j/3;
                    if (rows[i][num]==1) { return false;}
                    else { rows[i][num]=1; }
                    if (col[j][num]==1) { return false;}
                    else { col[j][num]=1; }
                    if (sbox[index_box][num]==1)  { return false;}
                    else { sbox[index_box][num]=1; }
                }
            }
        }
        return true;
    }
}
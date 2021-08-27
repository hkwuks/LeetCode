public class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length,wlen=word.length();
        boolean[][] visited=new boolean[h][w];
        for(int i=0;i<h;++i){
            for(int j=0;j<w;++j){
                if(check(board,word,i,j,visited,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(char[][] board,String word,int i,int j,boolean[][] visited,int k){
        if(word.charAt(k)!=board[i][j]){
            return false;
        }
        if(k==word.length()-1){
            return true;
        }
        visited[i][j]=true;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        boolean ans=false;
        for(int[] dir:directions){
            int ni=i+dir[0],nj=j+dir[1];
            if(ni>=0&&ni<board.length&&nj>=0&&nj<board[0].length&&!visited[ni][nj] && check(board,word,ni,nj,visited,k+1)){
                return true;
            }
        }
        visited[i][j]=false;
        return false;
    }
}
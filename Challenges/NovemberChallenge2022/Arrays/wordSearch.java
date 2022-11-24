public class wordSearch {

    // 79. Word Search

    // Matrix Problem -> BFS or DFS
    // Applying DFS normally
    // with a visited array for each traversal from each point if it matches the first character
    // Then in the dfs do the stuff, if you get the path return true otherwise false.
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        boolean res = false;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                boolean[][] vis = new boolean[n][m];
                res = dfsMatchWord(board,i,j,vis,word,0,dirs);
                if(res) return res;
                }
            }
        }
        return res;
    }
    private boolean dfsMatchWord(char[][] board,int sr,int sc,boolean[][] vis,String word,int wordIdx,int[][] dirs){
        
        if(board[sr][sc] != word.charAt(wordIdx)){
            return false;
        }
        if(wordIdx == word.length()-1){
            return true;
        }
        vis[sr][sc] = true;
        boolean res = false;
        for(int[] dir:dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && !vis[r][c]){
                res = res || dfsMatchWord(board,r,c,vis,word,wordIdx+1,dirs);
                if(res) return true;
            }
        }
        vis[sr][sc] = false;
        return false;
    }
}

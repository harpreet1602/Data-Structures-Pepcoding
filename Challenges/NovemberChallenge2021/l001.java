public class l001{
    // 130. Surrounded Regions
    // Time: O(n^2), Space: O(1)
      
    public void dfs(char[][] board,int sr, int sc,int[][] dir){
        int n =board.length, m = board[0].length;
       for(int[] d:dir){
       int r = sr+d[0];
       int c = sc+d[1];
       if(r>=0 && c>=0 && r<n && c<m && board[r][c]=='O'){
           board[r][c] = 'P';
           dfs(board,r,c,dir);
       }
       }
   }
   public void solve(char[][] board) {
       int n =board.length, m = board[0].length;
       if(n==0 || m==0)
       {
           return;
       }
       int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
//         first column
       for(int i=0;i<n;i++){
           if(board[i][0] == 'O'){
               board[i][0] = 'P';
               dfs(board,i,0,dir);
           }
       }
       
       
//         last column
       for(int i=0;i<n;i++){
           if(board[i][m-1] == 'O'){
               board[i][m-1] = 'P';
               dfs(board,i,m-1,dir);
           }
       }
       
       
//         first row
       for(int j=0;j<m;j++){
           if(board[0][j] == 'O'){
               board[0][j] = 'P';
               dfs(board,0,j,dir);
           }
       }
       
       
//         last row
       for(int j=0;j<m;j++){
           if(board[n-1][j] == 'O'){
               board[n-1][j] = 'P';
               dfs(board,n-1,j,dir);
           }
       }
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(board[i][j] == 'O'){
                   board[i][j] = 'X';
               }
           }
       }
       
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(board[i][j] == 'P'){
                   board[i][j] = 'O';
               }
           }
       }
   }


   public static void main(String[] args){

   }



   
}
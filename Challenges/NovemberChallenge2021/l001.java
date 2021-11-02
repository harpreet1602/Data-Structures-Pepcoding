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
//    980. Unique Paths III
// calculate all the zeroes and locate the starting indices
// after that go for th dfs operations where when you will get 2 then if zeroes has beem reduced
// to -1 then return 1 for finding one path covering all empty spaces
// mark the point visited as you don;t have to use one empty space more than one time
// decrease your one zero as you encountered zero on your path
// in the dfs just go for the valid calls only check if it is not visited or -1
// in the end mark the point unvisited 
// at each cell it will be storing the paths the cell can have to reach the destination

   public int dfs(int[][] grid, int sr,int sc,int zero,int[][] dir){
    int n = grid.length, m= grid[0].length;
   if(grid[sr][sc] == 2)
      return zero==-1?1:0;
   int totalpaths=0;
   grid[sr][sc] = -1;
   zero--;
   for(int[] d:dir){
       int r = sr+d[0];
       int c = sc+d[1];
       if(r>=0 && c>=0 &&r<n && c<m&&grid[r][c]!=-1){
           totalpaths +=dfs(grid,r,c,zero,dir);
       }
   }
   grid[sr][sc] = 0;
   return totalpaths;
}
public int uniquePathsIII(int[][] grid) {
   int n = grid.length, m= grid[0].length, zero =0 ,sr=0,sc=0;
   int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
   for(int i=0;i<n;i++){
       for(int j=0;j<m;j++){
           if(grid[i][j] == 0){
               zero++;
           }
           else if(grid[i][j] ==1)
           {
               sr = i;
               sc = j;
           }
       }
   }
   return dfs(grid,sr,sc,zero,dir);
}
   public static void main(String[] args){

   }



   
}
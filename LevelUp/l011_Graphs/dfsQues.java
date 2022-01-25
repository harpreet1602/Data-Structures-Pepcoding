public class dfsQues {
    
//     200. Number of Islands
//     tc O(2*(m*n)) => O(m*n) sc O(1)
//   no of island = no of dfs called
//     mark the current thing and go in all four directions
//     similarly do for every index
//  in the end you will get the ans   
public void dfsIsland(int i,int j, char[][] grid, int[][] dirS){
    //         marking as visited so that infinite loop doesn't occur 
            grid[i][j] = '0';
            
            for(int[] dir: dirS){
                int r = i + dir[0];
                int c = j + dir[1];
                
                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == '1'){
                    dfsIsland(r,c,grid,dirS);
                }
            }
        }
        public int numIslands(char[][] grid) {
            int noOfIslands = 0;
            int[][] dirS = {{-1,0},{0,-1},{1,0},{0,1}};
            
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j] == '1'){
                        dfsIsland(i,j,grid,dirS);
                        noOfIslands++;
                    }
                }
            }
            return noOfIslands;
        }


        
//     695. Max Area of Island
//     tc O(m*n) sc O(1)
//     again return the size of every island and at every cell return the 
//     size + 1 which will tell that from them how many cells can be reached
//     in the end the starting of the island will tell the full size of
//     island that is the recursion thing that happens to give us the size
//     otherwise you can the 1 size array to store each island's size
    // and check for the max size
//     of all the islands
//     
    public int dfsMaxIsland(int i,int j, int[][] grid, int[][] dirS){
        //         marking as visited so that infinite loop doesn't occur 
                grid[i][j] = 0;
                int size = 0; 
                for(int[] dir: dirS){
                    int r = i + dir[0];
                    int c = j + dir[1];
                    
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 1){
                        size += dfsMaxIsland(r,c,grid,dirS);
                    }
                }
                return size+1;
            }
            
            public int maxAreaOfIsland(int[][] grid) {
                int maxIsland = 0;
                int[][] dirS = {{-1,0},{0,-1},{1,0},{0,1}};
                
                for(int i=0;i<grid.length;i++){
                    for(int j=0;j<grid[0].length;j++){
                        if(grid[i][j] == 1){
                           int size = dfsMaxIsland(i,j,grid,dirS);
                           maxIsland = Math.max(maxIsland,size);
                        }
                    }
                }
                return maxIsland;   
            }


            
    // 463. Island Perimeter
//     tc O(m*n) sc O(1)
//     so 4 * noOfOnes must be there
//     the nbrcount of all the ones must be subtracted to get the perimeter
    public int islandPerimeter(int[][] grid) {
        int noOfOnes = 0;
        int nbrCount = 0;
        int[][] dirS = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j] == 1){
                    noOfOnes++;
                    for(int[] dir: dirS){
                    int r = i + dir[0];
                    int c = j + dir[1];
                    
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 1)        {
                        nbrCount++;
                        }
                    }
                }
            }
        }
        return 4*noOfOnes - nbrCount;
    }



//     130. Surrounded Regions
    //     tc O( (n*m)^2 + n*m) => O((m*n)^2) sc O(1)
//     dfs from boundary to inner
    
    public void dfsSurr(int i, int j, char[][] board){
        board[i][j] = 'b';
        int[][] dirS = {{-1,0},{0,-1},{1,0},{0,1}};
               
                for(int[] dir: dirS){
                    int r = i + dir[0];
                    int c = j + dir[1];
                    
                    if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c] == 'O'){
                        dfsSurr(r,c,board);
                    }
                }        
    }
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
//         travvelling from boundary to inner and applying bfs to change
//         the 'O' to 'b' so that only surrounded area of 'O' will be left
//         
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j == m-1){
                    if(board[i][j] == 'O')
                    dfsSurr(i,j,board);
                }
            }
        }
        
        
//         now easily convert the surrounded 'O' to 'X'
//         and side by side convert the changed 'b' back to 'O'
//         so our whole work will be done nicely.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                    else if(board[i][j] == 'b'){
                        board[i][j] = 'O';
                    }
            }
        }
        
    }



    
    // 1905. Count Sub Islands
//     tc O((m*n)^2) sc O(1)
//  If in grid 2 the cell is one then go for the dfs and check that for every grid 2 cell as 1
//     grid 1 cell must be 1 if it is not then also traverse and mark it true that we have visited 
//     and don't visit again. If it matches all and all then increase the count.
    public boolean dfsSubIsland(int i, int j, int[][] grid1, int[][] grid2, int m, int n, int[][] dir)     {
        boolean ans = grid1[i][j] == grid2[i][j];
        
        grid2[i][j] = 0;
        for(int[] d:dir){
            int r = i + d[0];
            int c = j + d[1];
           
            if(r>=0 && c>=0 && r<m && c<n && grid2[r][c] == 1){
                ans = dfsSubIsland(r,c,grid1,grid2,m,n,dir) && ans;
            }
        }
        return ans;
        
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length, ansSub = 0;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j] == 1){
                    boolean ans = dfsSubIsland(i,j,grid1,grid2,m,n,dir);
                    if(ans){
                        ansSub++;
                    }
                }
            }
        }
        return ansSub;
    }

    
    // https://www.hackerrank.com/challenges/journey-to-the-moon/problem
    // pending




}

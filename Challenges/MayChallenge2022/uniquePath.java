
public class uniquePath {
    
    // 63. Unique Paths II
//     Brute => standard DFS to get the answer.
//     tc O((m*n)) sc O(m*n)
// 
private int dfs(int sr,int sc,int n,int m,int[][] obstacleGrid,int[][] paths,int[][] dirs){
    //         if we have reached the destination from one path return 1.
            if(sr == n-1 && sc == m-1){
                return 1;
            }
    //         memoisation DP
            if(paths[sr][sc]!=0){
                return paths[sr][sc];
            }
            
            int pathsAvailable = 0;
    //         total paths of the four directions from the current cell will be added 
    //         and stored for the current cell
    //         faith of the cell => how many paths are there from me to the destination
    //         So keep on doing it, in the end you will get the answer at the 0,0 position of paths array.
            for(int[] dir:dirs){
                int r = sr + dir[0];
                int c = sc + dir[1];
                
                if(r>=0 && c>=0 && r<n && c<m && obstacleGrid[r][c]!=1){
                    pathsAvailable += dfs(r,c,n,m,obstacleGrid,paths,dirs);
                }
            }
            return paths[sr][sc] = pathsAvailable;
            
        }
        public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
            int n = obstacleGrid.length, m = obstacleGrid[0].length;
            int[][] paths = new int[n][m];
            int[][] dirs = {{0,1},{1,0}};
            if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1){
                return 0;
            }
            return dfs(0,0,n,m,obstacleGrid,paths,dirs);
        }
        
        
    //     Optimized
    //     DP => Tabulation.
    //     tc O(n*m) sc O(n*m)
         public int uniquePathsWithObstacles(int[][] obstacleGrid) {
             int n = obstacleGrid.length, m = obstacleGrid[0].length;
             if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1){
                return 0;
            }
    //          faith of the cell => how many paths are there to reach me from the starting.
    //          
             int[][] dp = new int[n][m];
    //          first row and column will be 1 if there is no blockage in between from the source as there is no other path.
    //          if there is blockage so there is no path to reach the cells after that in first row and column.
             for(int j=0;j<m;j++){
                 if(obstacleGrid[0][j]==1){
                     break;
                 }
                 dp[0][j] = 1;
             }
             
             for(int i=0;i<n;i++){
                 if(obstacleGrid[i][0]==1){
                     break;
                 }
                 dp[i][0] = 1;
             }
    //          now it is simple just keep on traversing from 1,1 to n-1,m-1
    //          consider adding the previous two adjacent cells which tell that 
    //          how many paths are there to reach the current cell.
    //          So in the end we will be getting the answer in the destination cell.
    //          as it tells how many paths are there to reach desination from source.
             for(int i=1;i<n;i++){
                 for(int j=1;j<m;j++){
                     if(obstacleGrid[i][j]!=1){
                         dp[i][j] = dp[i][j-1] + dp[i-1][j];
                     }
                 }
             }
             
             return dp[n-1][m-1]; 
         }
}

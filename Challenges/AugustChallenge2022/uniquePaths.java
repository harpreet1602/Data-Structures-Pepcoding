public class uniquePaths{
    
    // 62. Unique Paths
//     tc O(m*n) sc O(m*n) => i think
//     memoisation
//     from me to destination how many paths are there => this is the demand and faith.
public int uniquePaths1(int m, int n) {
    int[][] dirs = {{1,0},{0,1}};
    int[][] grid = new int[m][n];
    return findUniquePaths(0,0,m,n,dirs,grid);
}
private int findUniquePaths(int sr,int sc,int m,int n,int[][] dirs,int[][] grid){
    if(sr == m-1 && sc == n-1){
        return grid[m-1][n-1] = 1;
    }
    
    if(grid[sr][sc]!=0){
        return grid[sr][sc];
    }
    int count = 0;
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];
        
        if(r>=0 && c>=0 && r<m && c<n){
            count += findUniquePaths(r,c,m,n,dirs,grid);
        }
    }
    return grid[sr][sc] = count;
}


//     tc O(m*n) sc O(m*n)
//     tabulation
//     cell => how many ways are there to reach me.

 public int uniquePaths(int m, int n) {
     int[][] dp = new int[m][n];
     for(int i=0;i<m;i++){
         dp[i][0] = 1;
     }
     for(int j=0;j<n;j++){
         dp[0][j] = 1;
     }
     
     for(int i=1;i<m;i++){
         for(int j=1;j<n;j++){
             dp[i][j] = dp[i-1][j] + dp[i][j-1];
         }
     }
     return dp[m-1][n-1];
 }
}
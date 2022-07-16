public class outOfBoundary{
    
    // 576. Out of Boundary Paths
//         tc O(m*n*maxMove) sc O(m*n*maxMove)
// Memoisation along with basic DFS approach to avoid TLE.
//     Whenever I get out of the boundary with 0 or greater than 0 maxMove return 1
//     if maxMove gets over earlier return 0
//     Store it in 3d dp because three variables are getting changed to reuse the answers from the dp itself.
//     At one cell the answer is the submission from all four directions with one move-1.
public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int mod = (int)1e9 + 7;
    Long[][][] dp = new Long[m+1][n+1][maxMove+1];
    
    return (int)findWays(startRow,startColumn,maxMove,dirs,m,n,dp,mod);
}
private long findWays(int sr,int sc,int maxMove,int[][] dirs,int m,int n,Long[][][] dp,int mod){
    if(maxMove<0){
        return 0;
    }
    
    if(!(sr>=0 && sr<m && sc>=0 && sc<n)){
            return 1;
    }
    if(dp[sr][sc][maxMove]!=null){
        return dp[sr][sc][maxMove];
    }
    
    long count = 0;
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];
        count = (count + findWays(r,c,maxMove-1,dirs,m,n,dp,mod)+mod)%mod;        
    }
    dp[sr][sc][maxMove] = count;
    return dp[sr][sc][maxMove];
}
}
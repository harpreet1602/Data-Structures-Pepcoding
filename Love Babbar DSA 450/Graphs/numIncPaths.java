public class numIncPaths {
    
    // 2328. Number of Increasing Paths in a Grid
// tc O(n.m) sc O(n.m)
//     Dp with memoisation in dfs will be applied.
//     at one point we will be storing all the relevant strictly increasing paths that starts from me.
//    so ask the answer from all four directions + 1
//     we will go to the other option if satisfies strictly increasing criteria
//     for the repetitive values, we are using memoisation.
long[][] dp;
int mod = (int)1e9+7;

public int countPaths(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    long ans = 0;
    dp = new long[n][m];
    int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            ans = (ans + dfs(i,j,grid,dirs))%mod;
        }
    }
    return (int)ans;
}

private long dfs(int sr,int sc,int[][] grid,int[][] dirs){
    if(dp[sr][sc]!=0){
        return dp[sr][sc];
    }
    
    long ways = 1;
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];
        
        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]>grid[sr][sc]){
            ways = (ways + dfs(r,c,grid,dirs))%mod;   
        }
    }
    return dp[sr][sc] = ways;
}
}

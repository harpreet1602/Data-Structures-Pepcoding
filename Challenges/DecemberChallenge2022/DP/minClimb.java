public class minClimb{
    
    // 931. Minimum Falling Path Sum
// tc O(n^2) sc O(n^2)
//     Simple DP is applied that the current cell value will be min(prev dp row's left,top,right) + curr matrix value
//     In this way we can figure out the min value from the last row in the end.
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length,left,top,right,ans=(int)1e9;
        int[][] dp = new int[n][m];
        for(int j=0;j<m;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                left = j==0?(int)1e9:dp[i-1][j-1];
                top = dp[i-1][j];
                right = j==m-1?(int)1e9:dp[i-1][j+1];
                
                dp[i][j] = Math.min(Math.min(left,top),right) + matrix[i][j];
                System.out.println(dp[i][j]);
            }
        }
        for(int j=0;j<m;j++){
            ans = Math.min(dp[n-1][j],ans);
        }
        return ans;
    }
}
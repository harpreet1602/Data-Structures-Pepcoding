public class minPathSumMat {
    class Solution {
        // 64. Minimum Path Sum
    // tc O(n^2) sc O(n^2)
    //     Greedy won't work as if you take the minimum at the local step that will lead to wrong answer.
    //     recursion can be applied as we can go to two steps and call for the answer from them to destination.
    //     memoisation dp can be applied into it that is 2^n time as the smaller problems can be solved to solve bigger problems
    //     also repeated subproblems are there.
    //     In the end optimized tabulation dp
    //     dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
    //     through this approach we can get the answer.
        public int minPathSum(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            
            int[][] dp = new int[n][m]; 
            dp[0][0] = grid[0][0];
            
            for(int j=1;j<m;j++){
    //             first row
                    dp[0][j] = grid[0][j] + dp[0][j-1];
            }
            
            for(int i=1;i<n;i++){
    //             first col
                    dp[i][0] = grid[i][0] + dp[i-1][0];
            }
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
            return dp[n-1][m-1];
        }
    }
}

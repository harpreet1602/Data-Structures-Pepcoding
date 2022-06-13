public class rangeSumQuery2d {
    // 304. Range Sum Query 2D - Immutable
//     ṭc O(n*m) sc O(n*m)
//     So we have to use the prefix sum algorithm but by derving the formulas in 2d array
//     Ḍo a dry run to properly understand the formula how it is used here.
private int[][] dp;
//     tc O(n*m) sc O(n*m) => for making the prefix 2d array
    public void NumMatrix(int[][] matrix) {
        int n = matrix.length, m =matrix[0].length;
        dp = new int[n+1][m+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
//                 formula for making the prefix dp 2d array.
//                 prefix sum of row + prefix sum of col + current ele - one which is getting repeated
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
    }
//     tc O(1) sc O(1) => query
//     formula for query 
    public int sumRegion(int row1, int col1, int row2, int col2) {
//         sum till r2+1,c2+1 - sum till r1,c2+1 (row prefix sum getting subtracted which is excluded) - sum till r2+1,c1 (column prefix sum getting subtracted which is excluded) + sum till r1,c1 (which was subtracted twice so compensate by adding one, so that one gets subtracted)
        
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}


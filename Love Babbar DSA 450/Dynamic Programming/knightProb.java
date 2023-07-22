public class knightProb {
    
//  688. Knight Probability in Chessboard
// solution could be to apply dfs in the matrix like structure of the knight in 8 directions.
// and goes for exploring where in k turns we will get success we return 1 from there.
//     from the eight ways add the probability and divide by 8 and return from the current stage.
    
//     so from one point we can call for all probabilities from 8 directions in faith and recursively this thing happens at each step to give the final probability
//     Three D DP for changing k, row and column, memoization
    
public double knightProbability(int n, int k, int row, int column) {
    double[][][] dp = new double[25][25][101];
    int[][] dirs = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    for(double[][] darr:dp){
        for(double[] arr:darr){
            Arrays.fill(arr,-1);
        }
    }
    return knightProb(n,k,row,column,dp,dirs);
}

private double knightProb(int n, int k, int sr, int sc,double[][][] dp,int[][] dirs){
    if(k==0){
        return 1;
    }
    if(dp[sr][sc][k] != -1){
        return dp[sr][sc][k];
    }
    double prob = 0;
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];
        
        if(r>=0 && c>=0 && r<n && c<n){
            prob += knightProb(n,k-1,r,c,dp,dirs);
        }
    }
    return dp[sr][sc][k] = prob/8;
}

}

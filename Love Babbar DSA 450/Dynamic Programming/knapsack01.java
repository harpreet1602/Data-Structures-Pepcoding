
public class knapsack01 {
    
    // https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#
    
    // 0 - 1 Knapsack Problem
    // TC O(n*W) SC O(n*W)
    // DP array will be of size n+1 rows that represents values and W+1 columns 
    // that represents weights. Now we will be having the meaning of dp cell
    // i.e. Till this weight what maximum value can be taken into account.
    // Direction will be from left to right and now think about the relation with the previous entries.
    // So at the current cell we will have two options whether to take this one or not
    // If we will not take this value then take only the previous maximum value till this weight i.e. dp[i-1][j]
    // If we will take this value so first of all check whether weight allow us to do this or not.
    // by checking if j- wt[i-1] >=0, if yes then calculate the maximum of the previous one and 
    // dp[i-1][j-wt[i-1]] + val[i-1] i.e. the previous maximum possible value if we consider the current value also.
    
    // return the dp[n][W] i.e. the maximum value so far we can take under the constraint of W.
    static int knapSack(int W, int wt[], int val[], int n) 
    {
        
        int[][] dp = new int[n+1][W+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                dp[i][j] = dp[i-1][j];
                
                if(j-wt[i-1]>=0){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[n][W];        
    }
}

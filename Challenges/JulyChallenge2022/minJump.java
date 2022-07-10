public class minJump{
    
    // 746. Min Cost Climbing Stairs
//     tc O(n) sc O(n)
//     Optimised => sc O(1) should be done later with two variables
//     Can start from 0th or 1st index so put it as it is in dp array
//     After that at current instance dp[i] will store the minimum cost till now to reach me
//     i.e. cost[i] + min(dp[i-1],dp[i-2])
//     In the end return min(dp[n-1],dp[n-2]) as we can jump one or two steps to reach the top of the floor.
public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n];
    dp[0] = cost[0];
    dp[1] = cost[1];
    
    for(int i=2;i<n;i++){
        dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
    }
    return Math.min(dp[n-1],dp[n-2]);
}
}
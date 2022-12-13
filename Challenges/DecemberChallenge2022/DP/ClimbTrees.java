public class ClimbTrees {
    
    // 70. Climbing Stairs
// tc O(n) sc O(n)
// Simply DP is used to use previous 1 step and 2 step back values 
//     as we have two options of climbing either 1 or 2 steps,
// In the end it will be giving us the desired result.
public int climbStairs(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2;i<=n;i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}

}

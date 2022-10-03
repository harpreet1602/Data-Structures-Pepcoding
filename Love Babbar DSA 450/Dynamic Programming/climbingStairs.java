public class climbingStairs{
    
    // 70. Climbing Stairs
//     tc O(n) sc O(n)
//     Current cell signifies that how many number of ways are there to reach a particular stair
//     How can we calculate it?
//     For reaching the 0th stair the no. of way is 1, we will look at one step back and two step back to make current answer.
    
public int climbStairs(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    for(int i=1;i<=n;i++){
        dp[i] = dp[i-1] + (((i-2)>=0)?dp[i-2]:0);
    }
    return dp[n];
}
}
public class perfectSquare {
    
    // 279. Perfect Squares
// tc O(n) sc O(n)
// DP solution => where we are storing the number of perfect squares required to make the current number
// relation with the previous perfect square is like check the previous number how it is made plus one
// Analyse more => why?
public int numSquares(int n) {
    int[] dp = new int[n+1];
    Arrays.fill(dp,(int)1e9);
    dp[0] = 0;
    for(int i=1;i<=n;i++){
        for(int j=1;j*j<=i;j++){
            dp[i] = Math.min(dp[i],dp[i-j*j]+1);
        }
    }
    return dp[n];
}
}

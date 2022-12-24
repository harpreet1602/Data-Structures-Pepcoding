public class dominoTrominoTiling {
    
    // 790. Domino and Tromino Tiling
// tc O(n) sc O(n)
//     first three cases are the default cases then there is a mathematical equation that you need to derive to get the answer.
//     DP solution because the answer at the current state depends on the previous state
public int numTilings(int n) {
    int[] dp = new int[n+1];
    if(n==1||n==2){
        return n;
    }
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 5;
    int mod = (int)1e9+7;
    for(int i=4;i<=n;i++){
        dp[i] = (2*dp[i-1]%mod + dp[i-3]%mod)%mod;
    }
    return dp[n];
}
}

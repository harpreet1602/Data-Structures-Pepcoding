public class nCr {
     // https://practice.geeksforgeeks.org/problems/ncr1019/1#
    // tc O(n*r) sc O(n*r)
    // DP has been applied to get nCr , why is it so
    // Can't I directly apply the formula and give the answer. No as big numbers
    // factorial is so big that it will not fit in integer or something
    // So apply DP to get the by setting up the table with some initial cases
    // After that find some relation to get nCr from the previous cells
    // Initial case will be like when r>n that cells will be empty like it will be zero
    // After that in n==r case, cell will be 1.
    // nC0 is always one so fill it upfront before applying the actual logic
    // After that you need to derive or learn by heart the formula => 
    // nCr = (n-1)Cr + (n-1)C(r-1)
        // Remember the modulo thing here when to apply as number is large
    static int nCr(int n, int r)
    {
        // code here
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n+1][r+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i&&j<=r;j++){
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%mod;       
            }
        }
        
        return dp[n][r];
    }
    
}

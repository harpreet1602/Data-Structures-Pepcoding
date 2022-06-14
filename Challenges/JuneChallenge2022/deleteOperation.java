public class deleteOperation {
    
    // 583. Delete Operation for Two Strings
//     tc O(n*m) sc O(n*m)
//     Delete operations has to be calculated 
//     So formula is derived word1.len + word2.len -(2*longest common subsequence)
//     For this dp will be applied to calculate the longest common subsequence
//     By having two cases
//     Cell => till now what is the longest common subsequence between the two strings
//     Case 1 - if the character is same then 1+lcs(s1(l1-1),s2(l2-1))
//     Case 2- if the character is not equal then max(lcs(s1(l1-1),s2(l2)),lcs(s1(l1),s2(l2-1)))
//     With this return dp[n][m] that will have the LCS of both the strings.
public int minDistance(String word1, String word2) {
    int n = word1.length(), m = word2.length();
    int[][] dp = new int[n+1][m+1];
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(word1.charAt(i-1) == word2.charAt(j-1)){
                dp[i][j] = 1 + dp[i-1][j-1];
            }
            else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    return (n + m) - 2*dp[n][m];
}
}

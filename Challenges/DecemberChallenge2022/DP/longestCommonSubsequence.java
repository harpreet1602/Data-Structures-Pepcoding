public class longestCommonSubsequence {
    
    // 1143. Longest Common Subsequence
// tc O(n*m) sc O(n*m)
//     DP is getting applied, we have thought of it because numerous possibility can be there
//     and the current answer of a character depends on the previous characters' answer
//     At a current position we have to check what is the longest common substring till now
//     2d dp will be made col for first string and row for second or it can be vice versa as well.
//     At the current character we have two cases either the char will be same or different
//     So char is same then prev dp answer by omitting both char plus one will be the new answer
//     in case of different char , we check max by omitting one char from text 1 and then text 2 take the max one as the new answer.
public int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length(), m = text2.length();
    int[][] dp = new int[n+1][m+1];
    
    for(int i=1;i<=n;i++){
        char ch1 = text1.charAt(i-1);
        for(int j=1;j<=m;j++){
            char ch2 = text2.charAt(j-1);
            
            if(ch1==ch2){
                dp[i][j] = dp[i-1][j-1] + 1;
            }else{
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
    }
    return dp[n][m];
}
}

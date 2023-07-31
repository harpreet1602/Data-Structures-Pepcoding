public class minDelSumAscii {
    
    // 712. Minimum ASCII Delete Sum for Two Strings
// tc O(n*m) sc O(n*m) + recursive
// Maximum Common String alteration question
//    Recursion will be applied to explore all the ways of deleting the character from first string and deleting the character from second string 
//     these are the two choices when the character is not equal
//     otherwise when the characters are equal, go on for the other characters simply
//     Make the dp and memoise the recursive solution for the already calculated values.
    
public int minimumDeleteSum(String s1, String s2) {
    int n = s1.length(), m = s2.length();
    
    int[][] dp = new int[n+1][m+1];
    for(int[] arr:dp){
        Arrays.fill(arr,-1);
    }
    return minDelSum(s1,s2,n-1,m-1,dp);
}

private int minDelSum(String s1, String s2,int i,int j,int[][] dp){     
    if(i<0 && j>=0){
        int ans = 0;
        while(j>=0){
            ans += s2.charAt(j--);
        }
        return ans;
    }
    if(i>=0 && j<0){
        int ans = 0;
        while(i>=0){
            ans += s1.charAt(i--);
        }
        return ans;
    }
    if(i<0 && j<0){
        return 0;
    }
    
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    
    if(s1.charAt(i) == s2.charAt(j)){
        return dp[i][j] = minDelSum(s1,s2,i-1,j-1,dp);
    }
    
    return dp[i][j] = Math.min(minDelSum(s1,s2,i-1,j,dp)+s1.charAt(i),minDelSum(s1,s2,i,j-1,dp)+s2.charAt(j));
}
}

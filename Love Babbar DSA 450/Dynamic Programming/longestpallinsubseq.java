public class longestpallinsubseq {
    
    class Solution {
        // 516. Longest Palindromic Subsequence
    // tc O(n*n) sc O(n*n)
    //     some cases are there we have to understand that
    //     when start will become end only one character is there that will be a pallindrome return 1 for it
    //     other than that if character at start matches character at end 
    //     so length 2 subsequence is already made so call for (start+1, end-1) recursively for increasing this subsequence length.
        
    //     otherwise go and find maximum between start,end-1 or start+1,end.
    //     apply memoisation DP to optimize time
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            
            for(int[] arr:dp){
                Arrays.fill(arr,-1);
            }
            
            return findlongestPallindromeSubseq(s,dp,0,n-1);
        }
        private int findlongestPallindromeSubseq(String s,int[][] dp,int start,int end){
            if(start>end){
                return 0;
            }
            if(dp[start][end]!=-1){
                return dp[start][end];
            }
            if(start == end){
                return dp[start][end] = 1;
            }
            
            if(s.charAt(start) == s.charAt(end)){
                return dp[start][end] = 2 + findlongestPallindromeSubseq(s,dp,start+1,end-1);
            }
            
            return dp[start][end] = Math.max(findlongestPallindromeSubseq(s,dp,start,end-1),findlongestPallindromeSubseq(s,dp,start+1,end));
        }
    }
}

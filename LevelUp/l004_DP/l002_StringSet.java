import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
public class l002_StringSet {
    
// pending dp
    // 115. Distinct Subsequences
    //     TLE for recursion
    public int numDistinct(String s, int idx1, String t, int idx2){
        if(idx2==0){
            return 1;
        }
        if(idx1<idx2){
            return 0;
        }
        
        // if(idx1==s.length())
        //     return 0;
        
        char ch1= s.charAt(idx1-1);
        char ch2= t.charAt(idx2-1);
        int count=0;
        if(ch1==ch2){
            count+=numDistinct(s,idx1-1,t,idx2-1);
            count+=numDistinct(s,idx1-1,t,idx2);
        }
        else{
            count+=numDistinct(s,idx1-1,t,idx2);
        }
        return count;
    }
    
    public int numDistinctMemo(String s, int n, String t, int m,int[][] dp){
        if(m==0){
            return dp[n][m]=1;
        }
        if(n<m){
            return dp[n][m] = 0;
        }
        
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        char ch1= s.charAt(n-1);
        char ch2= t.charAt(m-1);
        int count=0;
        if(ch1==ch2){
            count+=numDistinctMemo(s,n-1,t,m-1,dp);
            count+=numDistinctMemo(s,n-1,t,m,dp);
        }
        else{
            count+=numDistinctMemo(s,n-1,t,m,dp);
        }
        return dp[n][m]=count;
    }


    // Dp analyse bhi karo 
    public int numDistinctTab(String s, int N, String t, int M,int[][] dp){
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++)
            {
                
        if(m==0){
            dp[n][m]=1;
            continue;
        }
        if(n<m){
            dp[n][m] = 0;
            continue;
        }
        
        char ch1= s.charAt(n-1);
        char ch2= t.charAt(m-1);
        int count=0;
        if(ch1==ch2){
            count+=dp[n-1][m-1];
            count+=dp[n-1][m];
        }
        else{
            count+=dp[n-1][m];
        }
        dp[n][m]=count;
        }
        }
        return dp[N][M];
    }



    public int numDistinct(String s, String t) {
        int n = s.length(),m=t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        // return numDistinct(s,n,t,m);
        return numDistinctMemo(s,n,t,m,dp);
    }

      
    public int minDistanceMemo(String word1, String word2, int n, int m, int[][] dp){
        if(n==0 || m==0){
            return n==0?m:n;
        }
        
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        int insert = minDistanceMemo(word1,word2,n,m-1,dp);
        int delete = minDistanceMemo(word1,word2,n-1,m,dp);
        int replace = minDistanceMemo(word1,word2,n-1,m-1,dp);
        
        if(word1.charAt(n-1) == word2.charAt(m-1)){
            dp[n][m] = replace;
        }
        else{
            dp[n][m] = Math.min(insert,Math.min(delete,replace)) + 1;
        }
        return dp[n][m];
    }
       
    public int minDistanceTab(String word1, String word2, int N, int M, int[][] dp){
        for(int n = 0;n<=N;n++){
            for(int m=0;m<=M;m++){
                
        if(n==0 || m==0){
            dp[n][m] = n==0?m:n;
            continue;
        }
        
        int insert = dp[n][m-1];
        int delete = dp[n-1][m];
        int replace = dp[n-1][m-1];
        
        if(word1.charAt(n-1) == word2.charAt(m-1)){
            dp[n][m] = replace;
        }
        else{
            dp[n][m] = Math.min(insert,Math.min(delete,replace)) + 1;
        }
            }
        }
        return dp[N][M];
    }

    // follow up question
    // 1. IF THE COST OF INSERT DELETE AND REPLACE IS GIVEN THEN FIND THE MINIMUM COST FOR THE 
    // OPERATION OF CONVERTING THE STR1 TO STR2

    public static int minDistanceFollow(String word1, String word2, int n, int m, int[] cost, int[][] dp){
        if(n==0 || m==0){
            return n==0?m*cost[0]:n*cost[2];
        }
        
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        int insert = minDistanceFollow(word1,word2,n,m-1,cost,dp);
        int delete = minDistanceFollow(word1,word2,n-1,m,cost,dp);
        int replace = minDistanceFollow(word1,word2,n-1,m-1,cost,dp);
        
        if(word1.charAt(n-1) == word2.charAt(m-1)){
            dp[n][m] = replace;
        }
        else{
            dp[n][m] = Math.min(insert + cost[0],Math.min(delete + cost[2],replace + cost[1]));
        }
        return dp[n][m];
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp =new int[n+1][m+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int[] cost = {4,5,7};
        // return minDistanceMemo(word1,word2,n,m,dp);
        return minDistanceFollow(word1, word2, n, m, cost, dp);
    }

    // 1035. Uncrossed Lines
    public int maxUncrossedLines(int[] nums1, int[] nums2, int n, int m,int[][] dp){
        if(n==0 || m==0){
            return dp[n][m] = 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(nums1[n-1] == nums2[m-1]){
            dp[n][m] = maxUncrossedLines(nums1,nums2,n-1,m-1,dp) + 1;
        }
        else{
            dp[n][m] = Math.max(maxUncrossedLines(nums1,nums2,n-1,m,dp),maxUncrossedLines(nums1,nums2,n,m-1,dp));
            
        }
        return dp[n][m];
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int ans = maxUncrossedLines(nums1, nums2, n, m, dp);
        return ans;
    }

    // 1458. Max Dot Product of Two Subsequences
    public int maximum(int... arr){
        int max = arr[0];
        for(int ele:arr){
            max = Math.max(max,ele);
        }
        return max;
    }
    public int maxDotProduct(int[] nums1, int[] nums2, int n, int m, int[][] dp){
        if(n==0 || m==0){
            return dp[n][m]=-(int)1e8;
        }
        if(dp[n][m]!=-(int)1e9){
            return dp[n][m];
        }
        int val = nums1[n-1]*nums2[m-1];
        int bothValAccepted = maxDotProduct(nums1,nums2,n-1,m-1,dp) + val;
        int a = maxDotProduct(nums1,nums2,n-1,m,dp);
        int b = maxDotProduct(nums1,nums2,n,m-1,dp);
        return dp[n][m] = maximum(val,bothValAccepted,a,b);
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp){
            Arrays.fill(d,-(int)1e9);
        }
        int ans = maxDotProduct(nums1, nums2, n, m, dp);
        return ans;
    }
    // 139. Word Break
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int len = 0, n = s.length();
        for(String ss : wordDict){
            set.add(ss);
            len = Math.max(ss.length(),len);
        }
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 0;i<=n;i++){
            if(!dp[i]) continue;
            // ye condition kaise aayi
            for(int l=1;l<=len && i+l<=n;l++){
                String substr = s.substring(i,i+l);
                if(set.contains(substr)){
                    dp[i+l] = true;
                }
            }
        }
        return dp[n];
    }

    // printing the longest pallindromic subsequence using dp of LPS
    public static String lpss_backEng(String str, int si, int ei,int[][] dp){
        if(si>=ei){
            return si==ei?str.charAt(si)+"":"";
        }
        if(str.charAt(si) == str.charAt(ei)){
            return str.charAt(si) + lpss_backEng(str, si+1, ei-1, dp) + str.charAt(ei);
        }
        else{
            if(dp[si+1][ei] > dp[si][ei-1]){
                return lpss_backEng(str, si+1, ei, dp);
            }
            else{
                return lpss_backEng(str, si, ei-1, dp);
            }
        }
    }




    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
       
    }

    
}

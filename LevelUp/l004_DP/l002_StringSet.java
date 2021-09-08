import java.util.Arrays;
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
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp =new int[n+1][m+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return minDistanceMemo(word1,word2,n,m,dp);
    }

    
}

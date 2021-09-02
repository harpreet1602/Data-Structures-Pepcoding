import java.util.*;
public class l001_twoPointerSet{
    // Steps to follow in Dp
    // 1_Faith
    // 2_Recursive_Tree
    // 3_RecursiveCode->Memoization
    // 4_Observation
    // 5_Tabulation
    // 6_Optimization
    
    public static void display(int[] dp){
        for(int ele:dp){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    public static void display2D(int[][] dp){
        for(int[] d:dp){
            display(d);
        }
        System.out.println();
    }
    public static int fibo_memo(int n,int[] dp){
        // Initially all the values are 0 in dp as 0 has come only one time in recursive tree so it can be used here as the default value
        if(n<=1){
            return dp[n]=n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ans = fibo_memo(n-1,dp) + fibo_memo(n-2,dp);
        return dp[n] = ans;
    }

    
    public static int fibo_tabu(int N,int[] dp){
        // Initially all the values are 0 in dp as 0 has come only one time in recursive tree so it can be used here as the default value
        int n=0;
        for(n = 0; n<=N; n++){
        if(n<=1){
            dp[n]=n;
            continue;
        }
        int ans = dp[n-1] + dp[n-2];
        dp[n] = ans;
        }
        return dp[N];
    }

    public static void fibo(){
        int n =5;
        int[] dp = new int[n+1];
        // fibo_memo(n, dp);
       fibo_tabu(n, dp);
        display(dp);
    }
    public static int mazePath(int sr, int sc, int er, int ec, int[][] dp, int[][] dir){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int count = 0;

        for(int[] d:dir){
            int r = sr + d[0];
            int c = sc + d[1];
            
            if(r>=0 && c>=0 && r<dir.length && c<dir[0].length){
                count += mazePath(r,c,er,ec,dp,dir);
            }
        }
        return dp[sr][sc] = count;
    }


    public static void mazePath(){
        int m = 3, n=3;
        int[][] dp = new int[m][n];
        int[][] dir = {{1,0},{1,1},{0,1}};
        mazePath(0,0,m-1,n-1,dp,dir);
        display2D(dp);
    }


    // 91. Decode Ways
    public int numDecodingsDP(String s, int idx, int[] dp){
        if(idx==s.length()){
            return dp[idx] = 1; 
        }
        if(dp[idx]!=-1) return dp[idx];
        char ch = s.charAt(idx);
        if(ch=='0'){
            return dp[idx] = 0;
        }
        int count = numDecodingsDP(s,idx+1,dp);
        if(idx<s.length()-1){
            char ch1 = s.charAt(idx+1);
            int num = (ch-'0')*10 + (ch1-'0');
            if(num<=26){
                count+= numDecodingsDP(s,idx+2,dp);
            }
        }
        return dp[idx] = count;
    }

    // Tabulation of decode ways
    
    public int numDecodingsDPTabu(String s, int Idx, int[] dp){
        for(int idx=s.length();idx>=0;idx--){
        if(idx==s.length()){
            dp[idx] = 1; 
            continue; 
        }
        // if(dp[idx]!=-1) return dp[idx];
        char ch = s.charAt(idx);
        if(ch=='0'){
            dp[idx] = 0;
            continue;
        }
        int count = dp[idx+1];
        if(idx<s.length()-1){
            char ch1 = s.charAt(idx+1);
            int num = (ch-'0')*10 + (ch1-'0');
            if(num<=26){
                count+= dp[idx+2];
            }
        }
            dp[idx] =count;
        }
        
        return dp[Idx];
    }
    


    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return numDecodingsDP(s,0,dp);
    }

    public static void main(String[] args){
        // fibo();
        mazePath();
    }
}
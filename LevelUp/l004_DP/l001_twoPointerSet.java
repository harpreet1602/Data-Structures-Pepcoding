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
    
    // optimization
    public int numDecodingsDPopt(String s, int Idx, int[] dp){
        int a =1, b=0;
         for(int idx=s.length()-1;idx>=0;idx--){
        
            
        char ch = s.charAt(idx);
        int sum=0;
        if(ch!='0'){  
        sum+= a;
        if(idx<s.length()-1){
            char ch1 = s.charAt(idx+1);
            int num = (ch-'0')*10 + (ch1-'0');
            if(num<=26){
                sum+= b;
            }
        }
          
        }
            b=a;
            a=sum;
         }
        return a;
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return numDecodingsDP(s,0,dp);
    }

    // 639. Decode Ways II

    

    public long numDecodings2(String s, int idx,long[] dp){
        int n = s.length();
        int mod = (int)1e9 + 7;
        if(idx == n){
            return (dp[idx] = 1);
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        char ch = s.charAt(idx);
        if(ch=='0'){
            return (dp[idx]=0);
        }
        long count=0;
        if(ch =='*'){
            count = (count + 9*numDecodings2(s,idx+1,dp))%mod;
            if(idx<n-1){
            char ch1 = s.charAt(idx+1);
                if(ch1=='*'){
                    count = (count + 15*numDecodings2(s,idx+2,dp))%mod;
        
                }
                else{
                    if(ch1>='0' && ch1<='6'){
                        count = (count + 2*numDecodings2(s,idx+2,dp))%mod;
            
                    } else{
                        count = (count + 1*numDecodings2(s,idx+2,dp))%mod;
            
                    }           
                }
            }
            
        }else{
            count = (count + 1 * numDecodings2(s,idx+1,dp))%mod;
                if(idx<n-1){
                    char ch1 = s.charAt(idx+1);
                    if(ch1=='*' && ch=='1'){
                        count = (count + 9*numDecodings2(s,idx+2,dp))%mod;
            
                    }
                    else if(ch1=='*' && ch=='2'){
                        
                        count = (count + 6*numDecodings2(s,idx+2,dp))%mod;
                        
                    }
                    else if(ch1!='*'){
                        int num = (ch-'0')*10 + (ch1-'0');
                        if(num<=26){ 
                        count = (count + 1*numDecodings2(s,idx+2,dp))%mod;
                        }
                    }
                }            
        }
        return (dp[idx] = count);
        
    }
    
      public long numDecodings2Tab(String s, int IDX,long[] dp){
        int n = s.length();
        int mod = (int)1e9 + 7;
        for(int idx = n;idx>=IDX;idx--){
        if(idx == n){
            dp[idx] = 1;
            continue;
        }
        char ch = s.charAt(idx);
        if(ch=='0'){
            dp[idx]=0;
            continue;
        }
        long count=0;
        if(ch =='*'){
            count = (count + 9*dp[idx+1])%mod;
            if(idx<n-1){
            char ch1 = s.charAt(idx+1);
                if(ch1=='*'){
                    count = (count + 15*dp[idx+2])%mod;
        
                }
                else{
                    if(ch1>='0' && ch1<='6'){
                        count = (count + 2*dp[idx+2])%mod;
            
                    } else{
                        count = (count + 1*dp[idx+2])%mod;
            
                    }           
                }
            }
            
        }else{
            count = (count + 1 * dp[idx+1])%mod;
                if(idx<n-1){
                    char ch1 = s.charAt(idx+1);
                    if(ch1=='*' && ch=='1'){
                        count = (count + 9*dp[idx+2])%mod;
            
                    }
                    else if(ch1=='*' && ch=='2'){
                        
                        count = (count + 6*dp[idx+2])%mod;
                        
                    }
                    else if(ch1!='*'){
                        int num = (ch-'0')*10 + (ch1-'0');
                        if(num<=26){ 
                        count = (count + 1*dp[idx+2])%mod;
                        }
                    }
                }            
        }
        dp[idx] = count;
        }
        return dp[IDX];
    }

    public long numDecodings2Opt(String s, int IDX,long[] dp){
        int n = s.length();
        int mod = (int)1e9 + 7;
        long a=1,b=0;
        for(int idx = n-1;idx>=IDX;idx--){
        long count=0;
        char ch = s.charAt(idx);
        if(ch!='0'){
        
        if(ch =='*'){
            count = (count + 9*a)%mod;
            if(idx<n-1){
            char ch1 = s.charAt(idx+1);
                if(ch1=='*'){
                    count = (count + 15*b)%mod;
        
                }
                else{
                    if(ch1>='0' && ch1<='6'){
                        count = (count + 2*b)%mod;
            
                    } else{
                        count = (count + 1*b)%mod;
            
                    }           
                }
            }
            
        }else{
            count = (count + 1 * a)%mod;
                if(idx<n-1){
                    char ch1 = s.charAt(idx+1);
                    if(ch1=='*' && ch=='1'){
                        count = (count + 9*b)%mod;
            
                    }
                    else if(ch1=='*' && ch=='2'){
                        
                        count = (count + 6*b)%mod;
                        
                    }
                    else if(ch1!='*'){
                        int num = (ch-'0')*10 + (ch1-'0');
                        if(num<=26){ 
                        count = (count + 1*b)%mod;
                        }
                    }
                }            
        }
        }
        b=a;
        a=count;
        }
        return a;
    }


    public int numDecodings2(String s) {
        int n = s.length();
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return (int)numDecodings2(s,0,dp);
    }

    // https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1#
    public int mod = (int)1e9 + 7;
    public long countFriendsPairings(int n, long[] dp){
        if(n==0){
            return dp[n]=1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        long single = countFriendsPairings(n-1,dp);
        long pair = n-2>=0?countFriendsPairings(n-2,dp)*(n-1):0;
        
        return dp[n] = (single + pair%mod)%mod;
    }
    public long countFriendsPairings1(int N, long[] dp){
        for(int n=0;n<=N;n++){
        if(n==0){
            dp[n]=1;
            continue;
        }
        long single = dp[n-1];
        long pair = n-2>=0?dp[n-2]*(n-1):0;
        
        dp[n] = (single + pair%mod)%mod;
        }
        return dp[N];
    }

    public long countFriendsPairings2(int N){
        long a = 1, b=1;
        for(int n=2;n<=N;n++){
            long sum = b + (a*(n-1))%mod;
            a=b;
            b=sum%mod;
        }
        return b;
    }
   
    public long countFriendsPairings(int n) 
    { 
       //code here
       long[] dp = new long[n+1];
       Arrays.fill(dp,-1);
       return countFriendsPairings(n,dp);
    }

    // https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-n-in-k-groups-incrementally/


    // pending dp






























    public static void main(String[] args){
        // fibo();
        mazePath();
    }
}
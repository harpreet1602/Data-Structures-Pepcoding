import java.util.Arrays;
public class l006_cutset {
    // https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1#
    public static int mcm_memo(int[] arr,int si,int ei,int[][] dp){
        if(ei-si==1){
            return dp[si][ei] =0;
        }
        if(dp[si][ei]!=-1){
            return dp[si][ei];
        }
        int minres = (int)1e9;
        for(int cut = si+1;cut<ei;cut++){
        int left = mcm_memo(arr,si,cut,dp);
        int right = mcm_memo(arr,cut,ei,dp);
        minres = Math.min(minres,left+(arr[si]*arr[cut]*arr[ei])+right);
        }
        return dp[si][ei] = minres;
    }
    public static void display2D(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
   public static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp =new int[N][N];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int ans= mcm_memo(arr,0,N-1,dp); 
         display2D(dp); 
         return ans; 
    }
    public static void mcm(){
        int N=5;
        int[] arr ={40, 20, 30, 10, 30};
        matrixMultiplication(N, arr);
    }
    public static int mcm_tab(int[] arr,int Si,int Ei,int[][] dp){
        return dp[Si][Ei];
    }   

    // 312. Burst Balloons
// cut the array on a index take the value from left and right you will get the cost then for
// the current index find the cost by multiplying its left val and right val with the current val 
// and add all the cost from leftcost + current + right cost  
    public int maxCoins(int[] nums, int si,int ei,int[][] dp) {
        if(dp[si][ei]!=0) return dp[si][ei];
        int lele = si==0?1:nums[si-1];
        int rele = ei==nums.length-1?1:nums[ei+1];
        int maxCoins=0;
        for(int cut = si;cut<=ei;cut++){
            int leftcost =  cut==si?0:maxCoins(nums,si,cut-1,dp);
            int rightcost = cut==ei?0:maxCoins(nums,cut+1,ei,dp);
            
            maxCoins = Math.max(maxCoins,leftcost + lele*nums[cut]*rele + rightcost);
        }
        return dp[si][ei] = maxCoins;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        return maxCoins(nums, 0,n-1,dp);
    }

    // https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
    static class pairBoolean{
        long totaltrue=0;
        long totalfalse=0;
        pairBoolean(){
            
        }
        pairBoolean(int totaltrue,int totalfalse){
            this.totaltrue = totaltrue;
            this.totalfalse = totalfalse;
        }
    }
    static void evaluate(pairBoolean leftres,pairBoolean rightres,pairBoolean res,char operator){
        long mod = 1003;
        long totaltf = (leftres.totaltrue+leftres.totalfalse) * (rightres.totaltrue+rightres.totalfalse);
        long totaltrue = 0, totalfalse = 0;
        
        
        if(operator == '|'){
            totalfalse = (leftres.totalfalse * rightres.totalfalse) % mod;
            totaltrue = (totaltf - totalfalse + mod) % mod;
        }
        else if(operator == '&'){
            totaltrue = (leftres.totaltrue * rightres.totaltrue) % mod;
            totalfalse = (totaltf - totaltrue + mod) % mod;
        }
        else if(operator == '^'){
            totaltrue = ((leftres.totaltrue * rightres.totalfalse) + (leftres.totalfalse * rightres.totaltrue) ) % mod;
            totalfalse = (totaltf - totaltrue + mod) % mod;
        }
        
        res.totaltrue = (res.totaltrue + totaltrue) % mod;
        
        res.totalfalse = (res.totalfalse + totalfalse) % mod;

    }
    static pairBoolean countWays(String s, int si, int ei, pairBoolean[][] dp){
        if(si==ei){
            char ch = s.charAt(si);
            int t = ch == 'T'?1:0;
            int f = ch == 'F'?1:0;
            return dp[si][ei] = new pairBoolean(t,f);
        }
        if(dp[si][ei]!=null){
            return dp[si][ei];
        }
        pairBoolean res = new pairBoolean();
        // operators pai cut lage aur left right mai expression jaye
        
        for(int cut=si+1;cut<ei;cut+=2){
            pairBoolean leftres = countWays(s,si,cut-1,dp);
            pairBoolean rightres = countWays(s,cut+1,ei,dp);
            
            evaluate(leftres,rightres,res,s.charAt(cut));
        }
        return dp[si][ei] = res;
    }
    
    static int countWays(int N, String S){
        // code here
        
        pairBoolean[][] dp = new pairBoolean[N][N];
        return (int)countWays(S,0,N-1,dp).totaltrue;
    }

// https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
    // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/optimal-bst-official/ojquestion
    public static int optimalbst(int[] keys,int[] frequency,int si,int ei,int[][] dp){
        if(dp[si][ei]!=0){
            return dp[si][ei];
        }
        int mincost = (int)1e9;
        int sum=0;
        for(int cut = si; cut<=ei; cut++){
            int leftcost = si==cut?0:optimalbst(keys,frequency,si,cut-1,dp);
            
            int rightcost = ei==cut?0:optimalbst(keys,frequency,cut+1,ei,dp);
            mincost = Math.min(mincost,leftcost+(0)+rightcost);
            sum+=frequency[cut];
        }
        return dp[si][ei] = mincost + sum;
    }
    private static void optimalbst(int[] keys, int[] frequency, int n) {
      //write your code here
      int[][] dp =new int[n][n];
      System.out.println(optimalbst(keys,frequency,0,n-1,dp));
      }


    //   1039. Minimum Score Triangulation of Polygon
    public int minScoreTriangulation(int[] values,int si,int ei,int[][] dp){
        if(ei-si < 2) return 0;
        if(dp[si][ei]!=-1){
            return dp[si][ei];
        }
        int minCost = (int)1e9;
        for(int cut=si+1;cut<ei;cut++){
            int leftcost = minScoreTriangulation(values,si,cut,dp);
            int rightcost = minScoreTriangulation(values,cut,ei,dp);
            
            minCost = Math.min(minCost,leftcost + values[si]*values[cut]*values[ei] + rightcost);
        }
        
        return dp[si][ei] = minCost;
    }
    public int minScoreTriangulation(int[] values) {
        int  n = values.length;
        int[][] dp =new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return minScoreTriangulation(values,0,n-1,dp);
    }
    
    // 95. Unique Binary Search Trees II

    // 1278. Palindrome Partitioning III


    // 213. House Robber II
    public int rob(int[] nums,int si,int ei,int[] dp){
        if(si>ei) return 0;
        if(dp[si]!=-1) return dp[si];
        
        int robcurrenthouse = nums[si] + rob(nums,si+2,ei,dp);
        int notrobcurrenthouse = rob(nums,si+1,ei,dp);
                
        return dp[si] = Math.max(robcurrenthouse,notrobcurrenthouse);
    }
    public int rob(int[] nums) {
       int n = nums.length;
        if(n==0 || n==1){
            return n==1?nums[0]:0;
        }
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        
        return Math.max(rob(nums,0,n-2,dp1),rob(nums,1,n-1,dp2));
    }

    // 198. House Robber
    public int rob01(int[] nums,int si,int ei,int[] dp){
        if(si>ei) return 0;
        if(dp[si]!=-1) return dp[si];
        
        int robcurrenthouse = nums[si] + rob01(nums,si+2,ei,dp);
        int notrobcurrenthouse = rob01(nums,si+1,ei,dp);
                
        return dp[si] = Math.max(robcurrenthouse,notrobcurrenthouse);
    }
    public int rob01(int[] nums) {
       int n = nums.length;
        if(n==0 || n==1){
            return n==1?nums[0]:0;
        }
        
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        
        return rob01(nums,0,n-1,dp);
    }

    // or
    public int rob1(int[] nums,int n,int[] dp){
        if(n<=0) return 0;
        if(dp[n]!=-1) return dp[n];
        
        int robcurrenthouse = nums[n-1] + rob1(nums,n-2,dp);
        int notrobcurrenthouse = rob1(nums,n-1,dp);
                
        return dp[n] = Math.max(robcurrenthouse,notrobcurrenthouse);
    }
    public int rob1(int[] nums) {
       int n = nums.length;
        if(n==0 || n==1){
            return n==1?nums[0]:0;
        }
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        
        return rob1(nums,n,dp);
    }


    // 1388. Pizza With 3n Slices
    


    public static void main(String[] args){
        mcm();
    }
}

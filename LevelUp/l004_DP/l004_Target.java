import java.util.Arrays;
public class l004_Target{
    public static int permutations(int[] arr,int target,int[] dp){
        if(target==0){
            System.out.println("base case");
            return dp[target]=1;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int count=0;
        for(int ele:arr){
            if(target-ele>=0)
            count+=permutations(arr, target-ele,dp); 
        }
        return dp[target] = count;
    }
    public static int permutations_DP(int[] arr,int Target,int[] dp){
        for(int target=0;target<=Target;target++){            
        if(target==0){
            // System.out.println("base case");
            dp[target]=1;
            continue;
        }
        int count=0;
        for(int ele:arr){
            if(target-ele>=0)
            count+=dp[target-ele]; 
        }
         dp[target] = count;
        }
        return dp[Target];
    }
    
    public static int combinations(int[] arr,int n,int target,int[][] dp){
        if(target==0){
            // System.out.println("base case");
            return dp[n][target]=1;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        int count=0;
        for(int i=n;i>0;i--){
            if(target-arr[i-1]>=0)
            count+=combinations(arr, i, target-arr[i-1],dp); 
        }
        return dp[n][target] = count;
    }
    public static void print1d(int[] dp){
        for(int ele:dp){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    public static void print2d(int[][] dp){
        for(int[] d:dp){
            print1d(d);
        }
        System.out.println();
    }
    public static void fill1d(int[] dp){
        Arrays.fill(dp,-1);
    }
    public static void fill2d(int[][] dp){
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
    }
    public static void solvePerComb(){
        int[] arr = {2,3,5,7};
        int target=10;
        int[] dp = new int[target+1];
        fill1d(dp);
        // System.out.println(permutations(arr, target, dp));
        System.out.println(combinations(arr, arr.length,target, dp));
        
        print1d(dp);
    }





    // https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#
    public static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[] dp = new int[W+1];
        for(int w=0;w<=W;w++){
            for(int i=0;i<N;i++)
            {
                if(w-wt[i]>=0){
                    dp[w] = Math.max(dp[w],dp[w-wt[i]]+val[i]);
                }
            }
        }
        return dp[W];
    }
    

    // 416 not understandable

    // 494

    
    // 698

    
    // 688

    public static void main(String[] args){
        solvePerComb();
    }
}
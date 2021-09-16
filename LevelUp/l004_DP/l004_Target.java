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
    
    public static int combinations(int[] arr,int n,int target,int[] dp){
        if(target==0){
            // System.out.println("base case");
            return dp[target]=1;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int count=0;
        for(int i=n;i>0;i--){
            if(target-arr[i-1]>=0)
            count+=combinations(arr, i, target-arr[i-1],dp); 
        }
        return dp[target] = count;
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

    public static void main(String[] args){
        solvePerComb();
    }
}
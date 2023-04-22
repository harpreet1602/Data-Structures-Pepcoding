public class profitableSchemes {
    
    class Solution {
        // 879. Profitable Schemes
    // tc O(index*members*profit)=>O(101*101*101) sc O(index*members*profit)=>O(101*101*101)
    //     Here we have to explore all the opportunities so recursion will be applied
    //     and then we have repeated subproblems with three changing properties so memoise it with 3d dp
    //     Main concept will be to whether select the group member or not and its profit will be added or not and accordingly call recursively for both the non select and select cases
        private int mod = (int)1e9+7;
        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            int[][][] dp = new int[101][101][101];
            for(int[][] arr1:dp){
                for(int[] arr2:arr1){
                    Arrays.fill(arr2,-1);
                }
            }
            return getProfitableSchemes(n,minProfit,0,0,0,group,profit,dp); 
        }
        
        private int getProfitableSchemes(int n,int minProfit,int index,int members,int currprofit,int[] group, int[] profit,int[][][] dp){
            if(index == group.length){
                if(currprofit>=minProfit){
                    return 1;
                }
                return 0;
            }
            
            if(dp[index][members][currprofit]!=-1){
                return dp[index][members][currprofit];
            }
            int ans = 0;
            
            ans += (getProfitableSchemes(n,minProfit,index+1,members,currprofit,group,profit,dp))%mod;
            if(members+group[index]<=n){
            ans += (getProfitableSchemes(n,minProfit,index+1,members+group[index],Math.min(minProfit,currprofit+profit[index]),group,profit,dp))%mod;
            }
            return dp[index][members][currprofit] = ans%mod;
        }
    }
}

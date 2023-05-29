public class stoneCutPartition {
    class Solution {
        // 1547. Minimum Cost to Cut a Stick
    // tc O(m^2*m)=>O(m^3) sc O(m^2)
    //     Recursion and then memoisation and then tabulation can also be applied 
    //     tabulation done later 
    //     partition dp
    //     at the current state explore all the possible cuts and get the length for cutting it now and call for exploration on the left hand side and right hand side 
    //     give the minimum result for each si to ei best minimum cut
    //     0 and n is added into the cuts array so that cuts[ei+1]-cuts[si-1] always gives us the loength for doing any cut in between but before that sort the cuts array so that left side is independent of the right hand side to make a cut
    //     
        public int minCost(int n, int[] cuts) {
            int size = cuts.length;
            int[] arr = new int[size+2];
            arr[0] = 0;
            arr[arr.length-1] = n;
            for(int i=0;i<size;i++){
                arr[i] = cuts[i];
            }
            Arrays.sort(arr);
            int[][] dp = new int[size+1][size+1];
            for(int[] a:dp){
                Arrays.fill(a,-1);
            }
            return minCostPartition(1,arr.length-2,arr,dp);
        }
        
        private int minCostPartition(int si,int ei,int[] cuts,int[][] dp){
            if(si>ei){
                return 0;
            }
            if(dp[si][ei]!=-1){
                return dp[si][ei];
            }
            int cost = 0, min = (int)1e9;
            
            for(int ind = si;ind<=ei;ind++){
                cost = cuts[ei+1] - cuts[si-1] + minCostPartition(si,ind-1,cuts,dp) + minCostPartition(ind+1,ei,cuts,dp);
                min = Math.min(min,cost);
            }
            return dp[si][ei] = min;
        }
    }
}

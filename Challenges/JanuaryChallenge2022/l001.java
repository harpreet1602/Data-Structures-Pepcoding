public class l001{
   
//     tc: O(n^3) sc: O(n^2)
//     gap strategy is used.
//    https://www.youtube.com/watch?v=YzvF8CqPafI
//     Make dp table then you will understand the solution
//     for every gap we go from si  to ei
//     then in that we go for bursting the current cut at the last
//      so bring the answer from left and right in that interval of (si-ei)
//    then cut ele * si-1 ele * ei+1 ele will act as the val for bursting 
//     curr cut ele and then in it as we are going for all permutations
//     go for the maximum one and then assign it into the dp
//     in the end ans will be contained like from 0 to n-1 in dp[0][n-1]
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int gap = 0;gap<n;gap++){
            for(int si=0,ei=gap;ei<n;si++,ei++){
            int max = -(int)1e9;
                for(int cut=si;cut<=ei;cut++){
                    int left = cut==si?0:dp[si][cut-1];
                    int right = cut==n-1?0:dp[cut+1][ei];
                    int currVal = (si==0?1:nums[si-1])*nums[cut]*(ei==n-1?1:nums[ei+1]);
                    int total = left+right+currVal;
                    max = Math.max(total,max);
                }
                dp[si][ei] = max;
            }
        }
        return dp[0][n-1];
    }
 
}
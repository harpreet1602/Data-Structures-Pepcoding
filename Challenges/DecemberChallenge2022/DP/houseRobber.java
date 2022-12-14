public class houseRobber{
    
//     198. House Robber
// tc O(n) sc O(n)
//     Dp is applied 
//     Cell => Best amount of monety that can be robbed till now
//     so deciding the max between dp[i-2]+nums[i],dp[i-1].
//     Hence in the end we will get the answer.
public int rob(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    
    for(int i=1;i<n;i++){
        if(i==1){
            dp[i] = Math.max(dp[0],nums[i]);
        }
        else{
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
    }
    return dp[n-1];
}
}
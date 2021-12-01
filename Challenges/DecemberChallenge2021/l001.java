public class l001{
    
//     time O(n) space O(n)
    public int rob1(int[] nums) {
        int n = nums.length,max=0;
        int[] dp = new int[n];
        if(n==0)
            return 0;
        else if(n==1)
            return nums[0];
        else if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = nums[2] + nums[0];
            max = Math.max(dp[1],dp[2]);
            for(int i=3;i<n;i++){
                dp[i] = Math.max(dp[i-2],dp[i-3]) + nums[i];
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }
    
//     time O(n) space O(1)
    public int rob(int[] nums) {
        int n = nums.length,max=0,prev2,prev3,ans=0;
        if(n==1)
            return nums[0];
        else if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            prev3 = nums[0];
            prev2 = nums[1];
            int prev1 = nums[2] + nums[0];
            max = Math.max(prev1,prev2);
            for(int i=3;i<n;i++){
                ans = Math.max(prev2,prev3) + nums[i];
                max = Math.max(ans,max);
                prev3 = prev2;
                prev2 = prev1;
                prev1 = ans;
            }
        }
        return max;
    }
}
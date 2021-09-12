public class l003_LIS {
    
    // 300. Longest Increasing Subsequence
    public int LISmemo(int[] nums,int ei, int[] dp){
        if(dp[ei]!=0){
            return dp[ei];
        }
        int maxLen = 1;
        for(int i =ei-1;i>=0;i--){
            if(nums[i]<nums[ei]){
            int recAns = LISmemo(nums,i,dp);
            maxLen = Math.max(maxLen,recAns+1);
            }
        }
        return dp[ei] = maxLen;
    }
      public int LIStab(int[] nums, int[] dp){
       int n = nums.length,maxLen=0;
        for(int i = 0;i<n;i++){
          
        dp[i]=1;
        for(int j =i-1;j>=0;j--){
            if(nums[j]<nums[i]){
            dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        maxLen = Math.max(dp[i],maxLen);
        }
          return maxLen;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
//         int maxLen = 0;
//         for(int i = 0;i<nums.length;i++){
         
//         maxLen = Math.max(maxLen,LISmemo(nums,i,dp));
           
//         }
//         return maxLen;
        return LIStab(nums,dp);
    }

    public int LDStab(int[] nums, int[] dp){
        int n = nums.length,maxLen=0;
         for(int i = 0;i<n;i++){
           
         dp[i]=1;
         for(int j =i-1;j>=0;j--){
             if(nums[j]>nums[i]){
             dp[i] = Math.max(dp[i],dp[j]+1);
             }
         }
         maxLen = Math.max(dp[i],maxLen);
         }
           return maxLen;
     }
}

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
      public int LIS_LR(int[] nums, int[] dp){
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
    public int LIS_RL(int[] nums, int[] dp){
        int n = nums.length,maxLen=0;
         for(int i = n-1;i>=0;i--){
           
         dp[i]=1;
         for(int j =i+1;j<n;j++){
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
        return LIS_LR(nums,dp);
    }

    public int LDS_LR(int[] nums, int[] dp){
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

     public int LDS_RL(int[] nums, int[] dp){
        int n = nums.length,maxLen=0;
         for(int i = n-1;i>=0;i--){
           
         dp[i]=1;
         for(int j =i+1;j<n;j++){
             if(nums[j]>nums[i]){
             dp[i] = Math.max(dp[i],dp[j]+1);
             }
         }
         maxLen = Math.max(dp[i],maxLen);
         }
           return maxLen;
     }

// https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
     public int LongestBitonicSequence(int[] nums)
     {
         // Code here
         int  n =nums.length;
         int[] LIS = new int[n];
         int[] LDS = new int[n];
         LIS_LR(nums,LIS);
         LIS_RL(nums,LDS);
         int maxLen=0;
         for(int i =0 ;i < n ; i++){
             maxLen = Math.max(maxLen, LIS[i] + LDS[i]-1);
             
         }
         return maxLen;
     }

}

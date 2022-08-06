import java.util.Arrays;

public class combinationSum4 {
     // 377. Combination Sum IV
//     tc O() sc O()
//     Recursion with memoisation
//     Find all the possible permutations for the target.
//    Simple recursion can be used to get that
//     But after that for optimising the solution 
//     Use the value of the number of ways to make a particular target i.e. target -> number of ways to make that target mapping
//     If it's already found return it. Filling the dp with -1 because it is not part of answer => 0 is part of answer.
public int combinationSum41(int[] nums, int target) {
    int[] dp = new int[target+1];
    Arrays.fill(dp,-1);
    return combinationHelper(nums,target,dp);
}
private int combinationHelper(int[] nums, int target,int[] dp) {
    if(dp[target]!=-1){
        return dp[target];
    }
    if(target == 0){
        return 1;
    }    
  
    int count = 0;
    for(int i=0;i<nums.length;i++){
        if(target-nums[i]>=0)
        count += combinationHelper(nums,target-nums[i],dp);
    }
    return dp[target] = count;
}    
}

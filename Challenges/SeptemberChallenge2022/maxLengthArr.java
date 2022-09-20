public class maxLengthArr{
    
    // 718. Maximum Length of Repeated Subarray
//     tc O(n*m) sc O(n*m)
//     Simple concept of 2d dp will be applied to track the longest common substring between two arrays
//     We will see if the current number is same then add the previous state plus one in the current in the dp cell
//     Dp cell meaning is how much is the longest substring present till myself.
public int findLength(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length,ans=0;
    int[][] dp = new int[n+1][m+1];
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(nums1[i-1] == nums2[j-1]){
                dp[i][j] = dp[i-1][j-1] + 1;
                ans = Math.max(ans,dp[i][j]);
            }
        }
    }
    return ans;
}
}
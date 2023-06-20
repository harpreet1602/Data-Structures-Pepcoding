public class kradiusSubArr {
    
    // 2090. K Radius Subarray Averages
// tc O(n) sc O(n)
//     prefix sum is used to solve this question
    
//     we have made n+1 size prefix Sum to include 0 at the first index and shift the indexes by 1 in the prefixSum array
//     so that if we start from i = k then we will be able to consider the sum in the range as prefixSum[i+k+1] - prefixSum[i-k], do dry run to understand this.
//     
public int[] getAverages(int[] nums, int k) {
    int n = nums.length, windowSize=2*k+1;
    long[] prefixSum = new long[n+1];
    int[] ans = new int[n];
    Arrays.fill(ans,-1);
    
    if(n<windowSize){
        return ans;
    }
    
    for(int i=0;i<n;i++){
        prefixSum[i+1] = prefixSum[i] + nums[i];
    }
    
    for(int i=k;i<n-k;i++){
        ans[i] = (int)((prefixSum[i+k+1]-prefixSum[i-k])/windowSize);
    }
    
    return ans;
}
}

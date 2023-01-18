public class maxSumSubarrCirc {
    class Solution {
        // 918. Maximum Sum Circular Subarray
    // tc O(n) sc O(1)
    //     More Dry run is needed to understand the last condition
    //     So basic idea in the first case is simple to maintain the currMax that we can take  the current el or not take it according to the benefit
    //     accordingly maxSum gets updated.
        
    //     In the same way we are trying to find the minimum contiguous subarray
    //     so that we can total = min + x + y => 
    //     total - min = x+y in the case of circular bigger subarray
        public int maxSubarraySumCircular(int[] nums) {
            int maxSum=nums[0], currMax = 0, minSum = nums[0], currMin = 0, totSum=0;
            
            for(int el:nums){
                currMax = Math.max(el,currMax + el);
                maxSum = Math.max(maxSum,currMax);
                
                currMin = Math.min(el,currMin + el);
                minSum = Math.min(minSum,currMin);
                
                totSum += el;
            }
            
            return maxSum>0? Math.max(maxSum, totSum - minSum):maxSum;
        }
    }
}

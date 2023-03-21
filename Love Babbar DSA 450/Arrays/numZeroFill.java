public class numZeroFill{
    class Solution {
//     2348. Number of Zero-Filled Subarrays
// tc O(n) sc O(1)
//     (n*(n+1))/2 are the total number of subarrays can be made from the array of length n
//     so just keep on tracking the arrays filled with zero and add their respective answer in the result.
    
    public long zeroFilledSubarray(int[] nums) {
        long count = 0,ans=0,mod=(int)1e9;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                count++;
            }
            else{
                ans = (ans + (count*(count+1))/2);
                count = 0;
            }
        }
        ans += (count*(count+1))/2;
        return ans;
    }
}
}
public class binSubSum {
    
    // 930. Binary Subarrays With Sum
// tc O(n) sc O(1)
//     When we are seeing that the question is of two pointer approach
//     then we have two options that either it can be of atmost k sum or exact k sum
//     Ṭhis question we need to find the exact k sum but for that we need to use 
//     number of subarrays with atmost goal sum minus number of subarrays with atmost goal-1 sum
//     It will be like subarrays with sum 2,1,0 - subarrays with sum 1,0 will give us the subarrays with exact sum 2.
//     For finding the atmost sum k subarrays,
//     We will run the ei without thinking, we will add it into the sum 
//     while our window will be disturbed, we will keep on subtracting the nums[si] from sum
    // and increment the starting index 
//     once we are with the valid window of subarray with sum <= goal then we add window size into the answer because from ei number to starting index number, subarrays will be the part of the answer
//     like for [1,0,1,0] subarrays will be 0, 
    // 1 0, 
    // 0 1 0, 
    // 1 0 1 0 
//     So add 4-0 = 4 into the answer for acknowledging the all the subarrays of the window.
public int numSubarraysWithSum(int[] nums, int goal) {
    return subWithAtmostKsum(nums,goal) - ((goal==0)?0:subWithAtmostKsum(nums,goal-1));
}

private int subWithAtmostKsum(int[] nums,int goal){
    int si = 0, ei = 0, sum = 0,ans=0, n =nums.length;
    
    while(ei<n){
        sum+=nums[ei];
        ei++;
        while(sum>goal){
            sum -= nums[si];
            si++;
        }
        ans += ei-si;
    }
    return ans;
}
}

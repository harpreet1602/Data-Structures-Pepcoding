public class runningsum {
    
    // 1480. Running Sum of 1d Array
//     Brute force 
//    Using extra space for an array that is asked. 
//  tc O(n) sc O(1)   
    
//     Optimised => inplace work has been done in the given input array
//     tc O(n) sc O(1) => In place 
//     In that array only add the previous index's value and current index's value and
//     store it in current index.

public int[] runningSum(int[] nums) {
    int n = nums.length;
    for(int i=1;i<n;i++){
        nums[i] = nums[i-1] + nums[i];
    }
    return nums;
}
}

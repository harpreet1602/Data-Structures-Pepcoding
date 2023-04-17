package Two Pointers;

public class squareSorted {
    
    class Solution {
        // 977. Squares of a Sorted Array
    // tc O(n) sc O(1)
    //     we can have two pointers one in the start and one in the end
    // these two are the contenders for the biggest square number 
    //     so now check the square of the low or high and add it accordingly.
        public int[] sortedSquares(int[] nums) {
            int n = nums.length,low=0,high=n-1,idx=n-1;
            int[] ans = new int[n];
            
            while(low<=high){
                if(nums[low]*nums[low] >= nums[high]*nums[high]){
                    ans[idx] = nums[low]*nums[low];
                    low++;
                }
                else{
                    ans[idx] = nums[high]*nums[high];
                    high--;
                }
                idx--;
            }
            
            return ans;
        }
    }
}

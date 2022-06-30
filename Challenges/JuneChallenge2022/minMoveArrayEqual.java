import java.util.Arrays;
public class minMoveArrayEqual {
    
//     462. Minimum Moves to Equal Array Elements II
    
//     Brute
//     tc O(nlogn) sc O(1)
//     Just sort the array and get the median
    // traverse the array and find the absolute difference off all the elements with that median
//     because this will be the middle element where all other elements will come to get equal to each other.
    // Optimized will be done later
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length,ans = 0, mid = n/2;
        
        for(int i=0;i<n;i++){
            ans = ans + Math.abs(nums[mid]-nums[i]);
        }
        
        return ans;
    }
}

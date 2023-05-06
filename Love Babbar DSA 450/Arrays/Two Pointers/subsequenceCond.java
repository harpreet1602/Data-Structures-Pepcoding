package Two Pointers;

public class subsequenceCond {
    class Solution {
        //     1498. Number of Subsequences That Satisfy the Given Sum Condition
        //     tc O(nlogn) sc O(n)
        //     power array needs to be created to avoid overflow condition
        //     number of subsequences will not get affected on sorting 
        //     sort the array and then apply two pointer, l and r in the start and end
        //     ele at l will always be minimum and r will always be maximum
        //     if nums[l]+nums[r] <= target this means add all the subsequences from l to r
        //     with 2^(r-l) and move l++ as more bigger minimum can be considered now
        //     otherwise move r-- as with this maximum the condition is not getting satisfied so we need lesser maximum element next
            
            public int numSubseq(int[] nums, int target) {
                int n = nums.length, low = 0, high=n-1,mod = (int)1e9+7;
                long count = 0;
                Arrays.sort(nums);
                int[] pow = new int[n];
                pow[0] = 1;
                
                for(int i=1;i<n;i++){
                    pow[i] = (pow[i-1]*2)%mod;
                }
                while(low<=high){
                    if((nums[low]+nums[high])<=target){
                        count = (count + pow[high-low])%mod;
                        low++;
                    }
                    else{
                        high--;
                    }
                }
                
                return (int)count%mod;
            }
        }
}

package Two Pointers;

public class subarrayK {
    class Solution {
        // 992. Subarrays with K Different Integers
    // tc O(n) sc O(n)
    //     two pointers approach of sliding window will be applied 
    //     main logic is to consider all the subrrays with exactly k distinct elements
    //     we need to find subarrays with atmost k distinct elements minus subarrays with atmost k-1 distinct elements
    //     this will definitely give us subarrays with exact k distinct elements
    //     rest applying the logic for subarrays with atmost k distinct elements.
    //     end will go on exploring if we find a new element, distinct ele count increases
    //     and while loop will be there till distinct ele count greater than k then increase your start pointer and see if any freq[nums[start]] goes to zero 
    //     decrement the distinct ele count
    //     outside it, add end-start+1 to the answer of subarrays to consider all the subarrays with atmost k distinct ele from start to end.
        public int subarraysWithKDistinct(int[] nums, int k) {         
            return subarrayAtmostK(nums,k)-subarrayAtmostK(nums,k-1);
        }
        private int subarrayAtmostK(int[] nums,int k){
            int n = nums.length,start=0,diff=0,sub=0;
            int[] freq = new int[(2*(int)1e4)+1];
            if(k==0)
            {
                return 0;
            }
            for(int end=0;end<n;end++){
                if(freq[nums[end]]==0){
                    diff++;
                }
                freq[nums[end]]++;
                while(start<n && start<=end && diff>k){
                    freq[nums[start]]--;
                    if(freq[nums[start]] == 0){
                        diff--;
                    }
                    start++;
                }
                sub += (end-start+1);
            }
            return sub;
        }
    }
}

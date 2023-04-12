package HashMap;

public class numberPairsAbsK {
    class Solution {
        // 2006. Count Number of Pairs With Absolute Difference K
    // tc O(n) sc O(n)
    //     Brute can be to use O(n^2) solution
    //     optimized one will be to use hashmap where we can ask for the element 
    //     that can make pair with current nums element.
    //     We will check for nums[i] - k and nums[i] + k if its key is present in the map
    //     add its value in the answer because pair is made.
    //     add the nums[i] in the map. 
        public int countKDifference(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int n = nums.length, ans = 0;
            
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i]-k)){
                    ans += map.get(nums[i]-k);   
                }
                if(map.containsKey(nums[i]+k)){
                    ans += map.get(nums[i]+k);   
                }
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            return ans;
        }
    }
}

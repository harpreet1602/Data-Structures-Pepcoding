import java.util.HashMap;
public class l001{
    // 1. Two Sum
//     So in this brute force will be fixing one and checking with other TC O(n^2) SC O(1)
// Optimised solution will be to use a hashmap where we will be storing the addresses of the numbers
//     and then if target - current number already exists in the hashmap that means we got the pair 
public int[] twoSum(int[] nums, int target) {
    int[] ans= new int[2];
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i = 0;i<nums.length;i++)
    {
        if(map.containsKey(target-nums[i]))
        {
            ans[1] = i;
            ans[0] = map.get(target-nums[i]);
            return ans;
        }
        map.put(nums[i],i);
    }
    return ans;
}





}
public class subArrSum {
    
    // t974. Subarray Sums Divisible by K
// tc O(n) sc O(n)
//     Maintain a hashmap of <remainder,frequency> so with this what we are doing is 
//     that prefix sum is there and we take its remainder and if it has come before also
//     so previous frequency of that will come into the answer because that much combinations of subarray will be there whose sum is divisible by k.
//     Rest do dry run to understand this logic.
public int subarraysDivByK(int[] nums, int k) {
    int n = nums.length, preSum = 0, rem = 0, ans=0;
    Map<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    for(int ele:nums){
        preSum += ele;
        rem = preSum%k;
        if(rem<0){
            rem = rem + k;
        }
        if(map.containsKey(rem)){
            ans += map.get(rem);
        }
        map.put(rem,map.getOrDefault(rem,0)+1);
    }
    return ans;
}
}

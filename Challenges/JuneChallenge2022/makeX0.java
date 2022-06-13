import java.util.HashMap;
public class makeX0{
    
    // 1658. Minimum Operations to Reduce X to Zero
//     tc O(n) sc O(n)
//     
public int minOperations1(int[] nums, int x) {
    int n = nums.length,max=-1;
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] prefixSum = new int[n];
    map.put(0,-1);
    prefixSum[0] = nums[0];
    for(int i=1;i<n;i++){
        prefixSum[i] = prefixSum[i-1] + nums[i];
    }
    int target = prefixSum[n-1] - x;
    for(int i=0;i<n;i++){
        map.put(prefixSum[i],i);
        if(map.containsKey(prefixSum[i]-target)){
            int len = i - map.get(prefixSum[i]-target);
            max = Math.max(max,len);
        }   
        
    }
    return max == -1?max:n - max;
}

//     Maintain a hashmap and use prefix sum concept.

//     We will find longest subarray whose sum is totalSum - x
//     This thing we can have like n - maxLength of longest subarray whose sum is totalSum - x
//     Maintain a hashmap of prefix,index
//     Whenever we find a mapping like prefix - target in the map so we calculate the length between the two indices
//     Maintain the maxLength of longest subarray whose sum is totalSum - x
//     In the end we return nums.length - maxLength of longest subarray whose sum is totalSum - x which will give me the minimum operations to make x as 0
 public int minOperations(int[] nums, int x) {
    int n = nums.length,max=-1,prefixSum = 0,totalSum = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,-1);
    for(int i=0;i<n;i++){
        totalSum += nums[i];
    } 
    int target = totalSum - x;
    for(int i=0;i<n;i++){
        prefixSum += nums[i];
        map.put(prefixSum,i);
        if(map.containsKey(prefixSum-target)){
            int len = i - map.get(prefixSum-target);
            max = Math.max(max,len);
        }   
        
    }
    return max == -1?max:n - max;

 }
}
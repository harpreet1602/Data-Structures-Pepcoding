public class maxNumPairs {
        // 1679. Max Number of K-Sum Pairs
//     tc O(nlogn) sc O(1)
//     sort and use 2 pointers =>brute
    
public int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int start = 0, end = nums.length-1,count=0;
    while(start<end){
        int sum = nums[start] + nums[end];
        
        if(sum<k){
            start++;
        }
        else if(sum>k){
            end--;
        }
        else{
            count++;
            start++;
            end--;
        }
    }
    return count;
}
//     optimised 
//     tc O(n) sc O(n)
//     Use hashmap for the pairs to be identified.

public int maxOperations1(int[] nums, int k) {
    int count = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int ele:nums){
        if(map.containsKey(k-ele) && map.get(k-ele)>0){
            count++;
            map.put(k-ele,map.get(k-ele)-1);
        }
        else{
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
    }
    return count;
}
    
    
    
}

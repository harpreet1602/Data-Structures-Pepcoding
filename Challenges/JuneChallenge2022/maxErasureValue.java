import java.util.HashMap;
import java.util.HashSet;

public class maxErasureValue {
    
    // 1695. Maximum Erasure Value
//     tc O(2*n)=> O(n) sc O(2*n)=>O(n)
//     Two pointer approach to make window that will be slided in the array from start to end 
//     We will maintain max sum of the unique elements from the start to end.
//     When we will have end as duplicate then till its previous value end - 1 from prefixSum can be obtained minus the prefisSum of start - 1 so we will get the sum of the unique elements from start to end.
//     edge cases are also covered like answer can be made from the end of the array as well.
public int maximumUniqueSubarray1(int[] nums) {
    int n = nums.length,start = 0,end=0,max=0,prevend=-1,sum=0;
    int[] prefixSum = new int[n];
    HashMap<Integer,Integer> map = new HashMap<>();
    prefixSum[0] = nums[0];
    for(int i=1;i<n;i++){
        prefixSum[i] = prefixSum[i-1] + nums[i];
    }
    
    while(start<=end && end<n){
        if(prevend!=end)
        map.put(nums[end],map.getOrDefault(nums[end],0)+1);
        prevend = end;
        if(map.get(nums[end]) > 1){
            sum = prefixSum[end-1] - ((start==0)?0:prefixSum[start-1]);
            // System.out.println(sum);
            max = Math.max(max,sum);
            map.put(nums[start],map.get(nums[start])-1);
            start++;
        }
        else{
            end++;
        }
    }
    sum = prefixSum[end-1] - ((start==0)?0:prefixSum[start-1]);
    max = Math.max(max,sum);
    return max;
}

//     Optimised in terms of time and space and code quality and easiness
//     TC O(n) SC O(n)
//     While end < n 
//     Just keep a hashset and add when unique end comes in set, add it in running sum
//     compare running sum with max sum,increment end
//     else delete start ele from set and from running sum when the ele at end is duplicate, increment start
public int maximumUniqueSubarray(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int n=nums.length,rsum=0,msum =0,start =0,end=0;
    
    while(end<n){
        if(set.contains(nums[end])){
            set.remove(nums[start]);
            rsum -= nums[start];
            start++;
        }else{
            set.add(nums[end]);
            rsum += nums[end];
            msum = Math.max(msum,rsum);
            end++;
        }
    }
    return msum;
    
}
}

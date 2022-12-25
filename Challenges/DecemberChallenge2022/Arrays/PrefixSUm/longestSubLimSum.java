package Arrays.PrefixSUm;

public class longestSubLimSum {
    
    // 2389. Longest Subsequence With Limited Sum
// tc O(nlogn + qlogn) sc O(n)
//     nlogn for sorting, logn for floorKey and q queries are there.
//     Sort the array and put the prefix Sum along with the indexes in the treemap
//     In that treemap we will fetch the floorkey accordingly we will get the elements whose sum is less than particular query.
public int[] answerQueries(int[] nums, int[] queries) {
    int n = nums.length,m = queries.length,prefixSum=0;
    int[] ans = new int[m];
    TreeMap<Integer,Integer> map = new TreeMap<>();
    Arrays.sort(nums);
    for(int i=0;i<n;i++){
        prefixSum += nums[i];
        map.put(prefixSum,i);
    }
    for(int i=0;i<m;i++){
        Integer key = map.floorKey(queries[i]);
        if(key == null){
            ans[i] = 0;
        }
        else{
            ans[i] = map.get(key)+1;    
        }
        
    }
    return ans;
}
}

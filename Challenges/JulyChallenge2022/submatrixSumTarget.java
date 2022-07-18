public class submatrixSumTarget {
    
    // 1074. Number of Submatrices That Sum to Target
//     tc O((m^2)*n) sc O(n)
//     560. Subarray Sum Equals K This questions's technique will be used prefix sum + hashmap => see it once more.
//     Applying this thing on a 2d array.
//    So traverse all the rows one by one taking prefidx sum of the columns and then passing the rows for the same algorithm which takes rows's prefix sum in consideration
//     Through this some possiblities will get cover 
//     After that to take all possibilities , we are iterating from each row downwards so that every submatrix possibility can be covered.
public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int ans = 0;
    int m = matrix.length,n = matrix[0].length;
    int[] summedrow = new int[n];
    for(int i=0;i<m;i++){
        Arrays.fill(summedrow,0);
        for(int j=i;j<m;j++){
            for(int k=0;k<n;k++){
                summedrow[k] += matrix[j][k];
            }
            ans += subarraySum(summedrow,target);
        }
    }
    return ans;
}

private int subarraySum(int[] nums, int k){
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    int prefixSum=0,ans=0;
    for(int i=0;i<nums.length;i++){
        prefixSum += nums[i];
        if(map.containsKey(prefixSum-k)){
            ans += map.get(prefixSum-k);
        }
        map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
    }
    return ans;
}    
}

public class minCostArrEq {
      // 2448. Minimum Cost to Make Array Equal
// tc O(nlogn + n) sc O(n)
//     Finding the median in the range which is going from high to low and then low to high
//     so by finding the median we will be able to find the converging value that will be best answer where all the values of nums should be changed to get the minimum cost
//     So for implementing this idea, we are storing it in a 2d array of size n*2 and sorting it on the basis of nums,
//    calculating the sum of all the costs, and then when we will get the sum as half , we need that nums value because that will be median
//     we will change all array values to that median and we will get the minimum cost.
//     https://www.youtube.com/watch?v=clHTLCrl7eM&ab_channel=BroCoders
    
public long minCost(int[] nums, int[] cost) {
    int n = nums.length, p = 0;
    long ans = 0, sum=0, totSum=0, median=0;
    int[][] arr = new int[n][2];
    
    for(int i=0;i<n;i++){
        arr[i] = new int[]{nums[i],cost[i]};
    }
    
    Arrays.sort(arr,(a,b)->{
       return a[0]-b[0]; 
    });
    
    for(int i=0;i<n;i++){
        sum += arr[i][1];
    }
    
    while(totSum<(sum+1)/2 && p<n){
        median = arr[p][0];
        totSum += arr[p][1];
        p++;
    }
    
    for(int i=0;i<n;i++){
        ans += Math.abs(nums[i]-median)*cost[i];
    }
    
    return ans;
}

}

public class sumEven {
    
// 985. Sum of Even Numbers After Queries
//     Brute
//     tc O(queries.length*n) sc O(1)
//     Do as said in the question
    
//     Optimised
//     tc O(n+queries.length) sc O(1)
//     First of all get the sum of all even elements and then accordingly manage the evenSum
//     while changing the array elements before and after the change.
public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
    int evenSum = 0,n=nums.length,oldVal=0,idx=0;
    int[] ans = new int[queries.length];
    for(int i=0;i<n;i++){
        if(nums[i]%2==0)
        evenSum += nums[i];
    }
    
    for(int[] query:queries){
        if(nums[query[1]]%2==0){
            evenSum -= nums[query[1]];
        }
        nums[query[1]] = nums[query[1]]+query[0];
        
        if(nums[query[1]]%2==0){
            evenSum += nums[query[1]];
        }
        ans[idx++] = evenSum;
    }
    return ans;
}
}

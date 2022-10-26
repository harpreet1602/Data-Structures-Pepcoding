public class continuousSubarray{
    
    // 523. Continuous Subarray Sum
//     tc O(n) sc O(k) because 0 to k-1 can be the remainders
//     Simple solution is to take a hashmap and store remainder to index mapping
//     whenver same remainder comes again then check if the difference between the numbers
//     which when divided by k gives the same remainder is more than or equal to 2 
//     then return true otherwise in the end return false.
//     Do a dry run you will understand the logic (sum2-sum1)%k = 0
// [a,b,c]
    //     sum 1 = a , sum2 = a+b+c
//     sum2%k = sum1%k
public boolean checkSubarraySum(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int sum = 0, n = nums.length,num=1;
    map.put(0,-1);
    for(int i=0;i<n;i++){
        sum += nums[i];
        num = sum%k;
        if(map.containsKey(num)){
            if(i-map.get(num)>=2){
                return true;
            }
        }
        else{
            map.put(num,i);
        }
    }
    return false;
    
}
}
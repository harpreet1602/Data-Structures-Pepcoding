public class missingNumber{
    
//     268. Missing Number
//     tc O() sc O()
//     Brute force => sort the array and then if the current ele!=index then that is the missing ele
//     if we do not get the answer in loop then the length is the answer after the loop traversal.
public int missingNumber1(int[] nums) {
    Arrays.sort(nums);
    for(int i=0;i<nums.length;i++){
        if(i!=nums[i]){
            return i;
        }
    }
    return nums.length;
}

//     Better
//     tc O(n) sc O(n)
//     Hashtable => store the frequency in the array and then check till length which ele is not present.
 public int missingNumber2(int[] nums) {
     int n = nums.length;
     int[] ans = new int[n+1];
    
     for(int i=0;i<n;i++){
         ans[nums[i]]++;
     }
     
     for(int i=0;i<n+1;i++){
         if(ans[i]==0){
             return i;
         }
     }
     return n;
 }

    
//     Optimised 
//     tc O(n) sc O(1)
//     Subtract the sum of all ele of array from the sum of first n natural numbers 
//    which will eventually give us the missing ele.

public int missingNumber(int[] nums) {
    int sum = 0, n =nums.length;
    for(int i=0;i<n;i++){
        sum += nums[i];
    }
    
    return ((n*(n+1))/2) - sum;
 
 }

//     Optimised
//     tc O(n) sc O(1)
//     Take xor of all the ele and indexes and in the end with the length as well to get the missing ele
//     missing ele can be found as everything else will become 0.
 public int missingNumber3(int[] nums) {
     int ans=0;
     for(int i=0;i<nums.length;i++){
         ans = ans^i^nums[i];
     }
     return ans^nums.length;
 }

}
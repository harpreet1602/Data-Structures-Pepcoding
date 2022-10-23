public class setmis{
    
    // 645. Set Mismatch
//     Brute
//     Hashset tc O(n) sc O(n)
//     Add and see what is duplicated 
//     then run a loop from 1 to n if there is an element missing add it in the answer.
    
//     tc O(n) sc O(1)
//     Doing it in place 
//     as there is a fact that numbers in the aarray from 1 to n and one number is duplicated and one is missing
//     So we are going to each index corresponding to the number coming and once we see 
//     same number two times we add it in the answer
//     whatever index is left in the array to hold a negative number will be the missing number. 
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx]<0){
                ans[0] = idx+1;
            }
            else{
                nums[idx] = -nums[idx];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[1] = i+1;
            }
        }
        return ans;
    }
}
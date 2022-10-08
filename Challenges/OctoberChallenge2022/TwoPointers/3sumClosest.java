public class 3sumClosest {
    
    // 16. 3Sum Closest
//     tc O(n^2) sc O(1)
//     two pointers after sorting then track the closestsum-target value whichever is smaller
//     return its closestsum
public int threeSumClosest(int[] nums, int target) {
    int n = nums.length,start,end,sum=0,ans=0,diff=0,pdiff=(int)1e9;
    Arrays.sort(nums);
    for(int i=0;i<n-2;i++){
        start=i+1;
        end=n-1;
        while(start<end){
            sum = nums[i]+nums[start]+nums[end];
            
            if(sum<target){
                start++;
            }
            else if(sum>target){
                end--;
            }
            else{
                return target;
            }
            diff = Math.abs(target-sum);
            if(diff<pdiff){
                pdiff = diff;
                ans = sum;
            }
        }
    }
    return ans;
}
}

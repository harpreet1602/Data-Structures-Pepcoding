public class firstLastIndex {
     // 34. Find First and Last Position of Element in Sorted Array
//     tc O(2*logn)=>O(logn) sc O(1)
//     just go towards 0th index for first index and go towards last index for finding the last index and just have a basic check in the equal condition
private int findFirstInd(int[] nums,int target){
    int low = 0, high = nums.length-1,mid;
    while(low<=high){
        mid = (low+high)/2;
        if(nums[mid] == target){
            if(mid>0 && nums[mid-1]==target){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        else if(target < nums[mid]){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return -1;
}
private int findLastInd(int[] nums,int target){
    int low = 0, high = nums.length-1,mid;
    while(low<=high){
        mid = (low+high)/2;
        if(nums[mid] == target){
            if(mid<nums.length-1 && nums[mid+1]==target){
                low = mid+1;
            }
            else{
                return mid;
            }
        }
        else if(target < nums[mid]){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return -1;
}
public int[] searchRange(int[] nums, int target) {
    int[] ans = new int[2];
    ans[0] = findFirstInd(nums,target);
    ans[1] = findLastInd(nums,target);
    
    return ans;
}
}

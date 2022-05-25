
public class firstLastIndex {
    
//     34. Find First and Last Position of Element in Sorted Array
//     O(2*logn) => O(log n) sc O(1)
// Two times binary search can be applied to the first index and last index of the element in the sorted array.
    
private int firstIndex(int[] nums, int target){
    int low = 0, high = nums.length-1;
//     Low can till it is equal to high because we are handling the case when the 

    while(low<=high){
// to avoid overflow condition, good to use .
        int mid = low + (high-low)/2;
//           handling the different case here when mid reaches the target.  
        if(nums[mid] == target){
//                 if its previous ele is also target then go to left side otherwise this is the first index.
            if(mid-1>=0 && nums[mid-1] == target){
                high = mid-1;
            }   
            else{
                return mid;
            }
        }
//             rest the binary search is same.
        else if(nums[mid]<target){
            low = mid+1;
        }
        else{
            high = mid-1;
        }
    }
    return -1;
}

//     Find the last index by applying the same binary search with just the difference in one case when we find the target
//     check the next element if is target then go to right otherwise this is the last index
//     If the ele is not present so it will not be able to return from inside the loop
//     then return -1.
private int lastIndex(int[] nums, int target){
    int low = 0, high = nums.length-1;
    while(low<=high){
        int mid = low + (high-low)/2;
        
        if(nums[mid] == target){
            if(mid+1<nums.length && nums[mid+1] == target){
                low = mid+1;
            }   
            else{
                return mid;
            }
        }
        else if(nums[mid]<target){
            low = mid+1;
        }
        else{
            high = mid-1;
        }
    }
    return -1;
}


public int[] searchRange(int[] nums, int target) {
    if(nums.length == 0){
        return new int[]{-1,-1};
    }
    
    return new int[]{firstIndex(nums,target),lastIndex(nums,target)};
        
}
}

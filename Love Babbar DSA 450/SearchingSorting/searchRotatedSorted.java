public class searchRotatedSorted {
    
    // 33. Search in Rotated Sorted Array
// tc O(log n) sc O(1)
//     we need to do it in log n time and it is rotated sorted array
//     Apply binary search but be careful as it is rotated sorted array so 
//     we have to check whether we are in the sorted range or not and accordingly 
//     we have to put a lot of conditions in between to handle each and every case 
//     that can occur.
//     Do dry run to know how these conditions are derived.

public int search(int[] nums, int target) {
    int low = 0, high = nums.length-1;
//         normal condition till binary search runs if the ele is not there so return -1.
    while(low<=high){
        int mid = low + (high-low)/2;
        
        if(nums[mid] == target){
            return mid;
        }

        else if(nums[mid]>target){
//                 sorted region and the condition where low can be equal to mid 
            if(nums[low]<=nums[mid]){
//                     then on the lhs the target will not be there so go to rhs
                if(nums[low]>target){
                    low = mid+1;
                } 
//                     otherwise go on lhs 
                else{
                    high = mid-1;
                }
            }
//                 unsorted region so find it on the rhs
            else{
                high = mid-1;
            }
        }
        else{
//                 nums[mid]<target
//                 sorted region so it will not be on lhs as ele more smaller will be there
            if(nums[low]<=nums[mid]){
               low = mid+1;
            }
//                 unsorted region => so check where to go
            else{
//                     greater and smaller are on the lhs 
                 if(nums[low]>target){
                    low = mid+1;
                } 
//                     otherwise it is on the lhs
                else{
                    high = mid-1;
                };
            }
        }
    }
    return -1;
}




//     2nd method => simpler in understanding
//     tc O(2*logn) => O(logn) sc O(1)
//     Find the pivot on which the array is rotated and apply binary search to search
//     in the left hand side sorted array or rhs sorted array because we know the pivot element now.
    
private int findPivot(int[] nums){
    int low = 0, high = nums.length-1;
    while(low<high){  
        int mid = low +(high-low)/2;
     
//             lhs is sorted so the pivot is in the rhs
        if(nums[0] <= nums[mid]){
            low = mid+1;
        }
//             otherwise rhs is sorted and the pivot must be in lhs because it is unsorted including current ele.
        else{
            high = mid;
        }
    }
    return high;
}

private int findIndex(int[] nums,int target,int si,int ei){
    int low = si, high = ei;
    while(low<=high){
        int mid = low +(high-low)/2;
        if(nums[mid] == target){
            return mid;    
        }
        else if(target<nums[mid]){
            high = mid-1;
        }
        else{
            low =mid+1;
        }
        
    }
    return -1;
}

public int search1(int[] nums, int target) {
    int pivot = findPivot(nums);
    int n =nums.length;
    if(target>=nums[pivot] && target<=nums[n-1]){
        return findIndex(nums,target,pivot,n-1);
    }
    else{
        return findIndex(nums,target,0,pivot-1);
    }
    
  }
}

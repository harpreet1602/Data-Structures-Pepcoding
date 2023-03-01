public class mergeSort {
    
//    912. Sort an Array 
//     tc O(nlogn) sc O(n)
//     Merge sort will be applied to get the time as nlogn always in every case best, worst, average
// Here divide and conquer technique is applied, simple concept to divide the array into two halves
//     and call with the faith that the two arrays will come sorted so I will merge the two sorted array together
//     with the base case when only one element in the array is left
//     then return array with one element
//     In the merge function simply merge it with the template you know.
public int[] sortArray(int[] nums) {
    int n = nums.length;
    
    return sortArray(nums,0,n-1);
}

private int[] sortArray(int[] nums,int si,int ei){
    int mid = (si+ei)/2;
    if(si == ei){
        return new int[]{nums[si]};
    }
    int[] left = sortArray(nums,si,mid);
    int[] right = sortArray(nums,mid+1,ei);
        
    return mergeSortedArrays(left,right);
}
private int[] mergeSortedArrays(int[] left,int[] right){
    int l=0,r=0,n=left.length,m=right.length,k=0;
    int[] ans = new int[n+m];
    while(l<n && r<m){
        if(left[l]<=right[r]){
            ans[k++] = left[l++];
        }
        else{
            ans[k++] = right[r++];
        }
    }
    while(l<n){
        ans[k++] = left[l++];
    }
    while(r<m){
        ans[k++] = right[r++];
    }
    return ans;
}


//    912. Sort an Array 
//     tc O(nlogn) sc O(n)
// keep on dividing till we get a single element and once we get it start merging the arrays
//     make left and right arrays accordingly and do changes in the nums array itself through si, mid and ei.
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        
        sortArray(nums,0,n-1);
        return nums;
    }
    
    private void sortArray(int[] nums,int si,int ei){
        if(si<ei){
        int mid = (si+ei)/2;
        
        sortArray(nums,si,mid);
        sortArray(nums,mid+1,ei);
            
        mergeSortedArrays(nums,si,mid,ei);
        }
    }
    private void mergeSortedArrays(int[] nums,int si,int mid,int ei){
        int l=0,r=0,n=mid-si+1,m=ei-mid,k=si;
        int[] left = new int[n];
        int[] right = new int[m];
        
        for(int i=si;i<=mid;i++){
            left[l++] = nums[i];
        }
        l=0;
        for(int i=mid+1;i<=ei;i++){
            right[r++] = nums[i];
        }
        r=0;
        
        while(l<n && r<m){
            if(left[l]<=right[r]){
                nums[k++] = left[l++];
            }
            else{
                nums[k++] = right[r++];
            }
        }
        while(l<n){
            nums[k++] = left[l++];
        }
        while(r<m){
            nums[k++] = right[r++];
        }
    }
}

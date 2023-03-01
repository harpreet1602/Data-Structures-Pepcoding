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
}

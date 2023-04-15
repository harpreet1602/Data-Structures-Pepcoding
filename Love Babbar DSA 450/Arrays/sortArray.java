public class sortArray {
    class Solution {
        //    912. Sort an Array 
    //     tc O(nlogn) sc O(n)
    // keep on dividing till we get a single element and once we get it start merging the arrays
    //     make left and right arrays accordingly and do changes in the nums array itself through si, mid and ei.
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            mergeSort(nums,0,n-1);
            return nums;
        }
        private void mergeSort(int[] nums,int si,int ei){
            if(si<ei){
            int mid = (si+ei)/2;
            
            mergeSort(nums,si,mid);
            mergeSort(nums,mid+1,ei);
            
            mergeTwoSortedArrays(nums,si,mid,ei);
            }
        }
        private void mergeTwoSortedArrays(int[] nums,int si,int mid, int ei){
            int l=0, r=0, a=si, n=mid-si+1, m=ei-mid;
            int[] left = new int[n];
            int[] right = new int[m];
            
            for(int i=si;i<=mid;i++){
                left[l++] = nums[i];
            }
            for(int i=mid+1;i<=ei;i++){
                right[r++] = nums[i];
            }
            l=0;
            r=0;
            while(l<n && r<m){
                if(left[l]<=right[r]){
                    nums[a++] = left[l++];
                }
                else{
                    nums[a++] = right[r++];
                }
            }
            while(l<n){
                nums[a++] = left[l++];
            }
            while(r<m){
                nums[a++] = right[r++];
            }
        }
    }
}

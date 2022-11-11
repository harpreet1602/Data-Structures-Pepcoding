public class removeDup {
      // 26. Remove Duplicates from Sorted Array
// Brute
// O(nlogn + n ) sc O(n)
// store the elements in the hashset and then change the value in the array

// optimal
    // tc O(n) sc O(1)
    // Two pointer approach keep on moving the j whenever the ele at i and j is different 
    // change the value from arr[j] to arr[i] and keep on doing it
    // return i+1 that will give count of unique elements.
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0,j=1;
        while(j<n){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}

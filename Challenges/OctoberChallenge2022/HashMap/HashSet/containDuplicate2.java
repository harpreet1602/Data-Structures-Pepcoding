public class containDuplicate2{
    
//     219. Contains Duplicate II
//     tc O(n) sc O(n)
//     Take a hashset and take a window of k and see if a element is repeated 
//     and once window becomes of size k + 1 delete the starting element of the window
//     whenever we find the duplicate entry in the window then return true
//     otherwise after the iteration return false
public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashSet<Integer> set = new HashSet<>();
    int n=nums.length;
    for(int i=0;i<n;i++){
        if(i>k){
            set.remove(nums[i-k-1]);
        }
        if(!set.add(nums[i])) return true;
    }
    return false;
}
}
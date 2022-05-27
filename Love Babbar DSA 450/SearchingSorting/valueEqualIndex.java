import java.util.ArrayList;

public class valueEqualIndex {
    
    // https://practice.geeksforgeeks.org/problems/value-equal-to-index-value1330/1#
    // tc O(n) sc O(1)
    // Linear search and check for the given condition and add all the elements which satisfy the condition
    // into the list.
    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {

        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(i+1==arr[i]){
                ans.add(arr[i]);
            }
        }
        return ans;
    }

    
//     2057. Smallest Index With Equal Value
//     tc O(n) sc O(1)
//     Apply linear search and check for the given condition
public int smallestEqual(int[] nums) {
    for(int i=0;i<nums.length;i++){
        if(i%10 == nums[i]){
            return i;
        }    
    }
    return -1;
}



}

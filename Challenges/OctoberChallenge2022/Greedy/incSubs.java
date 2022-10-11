public class incSubs{
    
//     334. Increasing Triplet Subsequence
//     tc O(n) sc O(1)
//     Just keep track of the left and mid values
//     write the conditions accordingly where we see if we have found the right ele,mid or left ele in each iteration
//     if we don't get the three numbers as inreasing subsequence then return false
public boolean increasingTriplet(int[] nums) {
    int left,mid;
    left = mid = Integer.MAX_VALUE;
    for(int ele:nums){
        if(ele>mid){
            return true; //right element found
        }
        else if(ele<mid && ele>left){
            mid = ele;
        }
        else if(ele<left){
            left = ele;
        }
    }
    return false;
}
}
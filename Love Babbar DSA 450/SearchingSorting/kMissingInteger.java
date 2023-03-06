public class kMissingInteger {
    
    // 1539. Kth Missing Positive Number
//     Brute
//     linear search for the missing number will take O(n) time
    
//     Optimised
//     Apply binary search for the case where missing number lies is between the array
//     otherwise for the case where count of missing numbers less than k then go for the direct formula to return the answer
    
//     Inside binary search go for finding the most appropriate arr[high]
//     through which we will return arr[high] + (k-count of missing number)
//     But if high reaches -1 then missing number is lying in between 1 to element at 0th index so return k.
// tc O(log n) sc O(1)
//     
public int findKthPositive(int[] arr, int k) {
    int n = arr.length, missNo = arr[n-1] - n;
    
    if(missNo < k){
        return arr[n-1] + (k-missNo);
    }
    
    int low = 0, high = n-1;
    while(low<=high){
        int mid = (low+high)/2;
        
        int currMissNo = arr[mid] - (mid+1);
        if(currMissNo<k){
            low = mid+1;
        }
        else{
            high = mid-1;
        }
    }
    if(high == -1){
        return k;
    }
    missNo= arr[high]-(high+1);
    return arr[high] + (k-missNo);
}
}

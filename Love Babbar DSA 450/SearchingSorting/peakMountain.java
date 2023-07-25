public class peakMountain {
    
//     852. Peak Index in a Mountain Array
    
//     Brute => linear search find the index but that is not even asked tc O(n) sc O(1)
    
//  Optimised  
// tc O(log n) sc O(1)
//     Apply binary search in the range from 1 to length-2, why
//     because we want an index in this range where number exists before that index and after that index also as it is a mountain array.
//     then in the binary search, check if mid ele is greater than mid -1 ele and mid+1 ele then return mid as it is the index we are searching for
//     if mid ele is lesser than mid-1 and greater than mid+1 ele
//     this means decreasing order so the possibility of the answer is in left hand side
//     so directly set high as mid-1.
//     otherwise it is reverse case that we are in the sorted order so go for the rhs by setting low as mid+1
public int peakIndexInMountainArray(int[] arr) {
    int low = 1, high = arr.length-2;
    while(low<high){
        int mid = (low + (high-low)/2);
       
        if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
            return mid;
        }
        else if(arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]){
            high = mid-1;
        }
        else {
            low = mid+1;
        }
    }
    return low;
}
}

import java.util.Arrays;
import java.util.LinkedList;

public class shortestUnsorted {
    
    // 581. Shortest Unsorted Continuous Subarray
//     Brute force 
//     tc O(nlogn) sc O(n)
//     Sort the array and then find the discrupency in both the arrays
//     and find the left  index and right index of it.
//     return right-left+1 or 0 accordingly.
public int findUnsortedSubarray1(int[] nums) {
    int n = nums.length;
    int[] newNums = new int[n];
    for(int i=0;i<n;i++){
        newNums[i] = nums[i];
    }
    Arrays.sort(newNums);
    
    int left = -1;
    for(int i=0;i<n;i++){
        if(newNums[i]!=nums[i]){
            left = i;
            break;
        }
    }
    
    int right = n;
    for(int i=n-1;i>=0;i--){
        if(newNums[i]!=nums[i]){
            right = i;
            break;
        }
    }
    
    return (left==-1&&right==n)?0:right-left+1;
    
}

//     Optimised
//     tc O(n) sc O(n)
//     Monotonic Stack
//     Here also main aim is to find the left index and right index
//     So by using the concept we will find dicrupancy in the array
//     By pushing and popping the elements of the stack by comparing them with 
// the current ele of the array. Do a dry run to understand.

public int findUnsortedSubarray(int[] nums) {
    LinkedList<Integer> st = new LinkedList<>();
    int n = nums.length;
    int left = n-1,right=0;

    for(int i=0;i<n;i++){
        if(st.size()==0){
            st.addFirst(i);
        }
        else{
            while(st.size()!=0 && nums[st.getFirst()] > nums[i]){
                left = Math.min(st.removeFirst(),left);
            }
            st.addFirst(i);
        }
    }
    LinkedList<Integer> st1 = new LinkedList();
    for(int i=n-1;i>=0;i--){
        if(st1.size()==0){
            st1.addFirst(i);
        }
        else{
            while(st1.size()!=0 && nums[st1.getFirst()] < nums[i]){
                right = Math.max(st1.removeFirst(),right);
            }
            st1.addFirst(i);
        }
    }
    
    return (left==n-1&&right==0)?0:right-left+1;
}
}

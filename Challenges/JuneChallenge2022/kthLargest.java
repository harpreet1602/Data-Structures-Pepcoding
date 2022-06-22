import java.util.PriorityQueue;

public class kthLargest{
    
    // 215. Kth Largest Element in an Array

    //     Brute force
//     tc O(nlogn) sc O(1)
//     sort the array and return arr[n-k]
    
//     Better
//     tc O(nlogk) for traversing over n elements and log k operation of priorityqueue.
    // sc O(k) for k size priority queue
//     keep on adding k elements in pq and when the size>k remove the smallest element from the pq i.e. functionality of minheap
//     in the end whatever is at the top of pq is the kth largest.
public int findKthLargest1(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int n = nums.length;
    
    for(int i=0;i<n;i++){
        pq.add(nums[i]);
        if(pq.size()>k){
            pq.remove();
        }
    }
    return pq.peek();
}

//     Optimized
//     Quick Select Algorithm
//     tc best => O(n) and worst O(n^2)
//     Similar to quick sort
//     Two pointers at the start and end and pivot index 
//     if it becomes equal to length - k then return the ele
//     otherwise if it is greater then end = partitionIndex-1, search space goes to left
//    else start = partitionIndex+1, search in the RHS

 public int findKthLargest(int[] nums, int k) {
    int n=nums.length,start = 0, end =n-1, index = n-k;
     while(start<=end){
         int partitionIndex = partition(nums,start,end);
         if(partitionIndex == index){
             return nums[index];
         }
         else if(partitionIndex > index){
             end = partitionIndex - 1;
         }
         else{
             start = partitionIndex + 1;
         }
     }
     return -1;
 }
// In partition, check the position where all the ele less than pivot should be left and greater on right
//     for this purpose, i  will keep on going until we find greater ele than pivot
//     and j will decrease until we find smaller ele than pivot,
//     as they have gone one place wrong so swap i and j in nums
//     wherever i is that is where the partition is so swap pivot with i in nums and return i
private int partition(int[] nums,int start,int end){
    int i = start, j = end, pivot = end;
    
    while(i<j){
        while(i<j && nums[i]<=nums[pivot]){
            i++;
        }
        
        while(i<j && nums[j]>=nums[pivot]){
            j--;
        }
        
        swap(nums,i,j);
    }
    swap(nums,i,pivot);
    return i;
}
private void swap(int[] nums,int i,int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

}
import java.util.PriorityQueue;

public class kthLargest {
    
//     215. Kth Largest Element in an Array
//     tc O(nlogk) sc O(k)
// Use min priority queue and keep on adding the elements and when size becomes greater than k remove the top element
//     at the end you will get the k largest elements in the pq as all the small
//     elements are removed step by step in the traversal
//     After the traversal, return the topmost ele i.e. kth largest.
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(); 
    for(int i=0;i<nums.length;i++){
        pq.add(nums[i]);
        
        if(pq.size()>k){
            pq.remove();
        }
    }
    return pq.peek();
}
    
}

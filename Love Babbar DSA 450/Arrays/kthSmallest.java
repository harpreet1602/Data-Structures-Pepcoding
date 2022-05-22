import java.util.PriorityQueue;
public class kthSmallest {
    
    // Kth smallest element
    // Brute force 
    // sort the array and return arr[k-1].
    // tc O(nlogn) sc O(1)
    
    // Optimised.
    // tc O(n.logk) sc O(k)
    // Whenever kth somethings is used => use priority queue.
    // We need to find the kth smallest so k smallest elements must be there in the priority queue
    // Run a loop over all the elements and add it in the pq and when the size of pq becomes greater 
    // than k remove the element, by this all the large elements will be removed.
    // after the traversal return the topmost element of the pq i.e. kth smallest.
    public static int kthSmallest1(int[] arr, int l, int r, int k) 
    { 
        //Your code here
         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
           return b-a; 
        });
        
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    } 
}

package Love Babbar DSA 450.Heap;

public class kthLargestStream {
    class KthLargest {
        // 703. Kth Largest Element in a Stream
        // tc O(nlogk + 1) sc O(k)
        //     First of all, Intialize the MinHeap pq and maintain k largest elements in the priority queue.
        // Then while adding new element is it greater than the k th largest then only add
        //     otherwise reject
        //     and return the peak
        //     corner case when pq is not of size k then directly add in the pq.
            private PriorityQueue<Integer> pq;
            int size = 0;    
        //     tc nlogk
            public KthLargest(int k, int[] nums) {
                pq = new PriorityQueue<>();
                for(int ele:nums){
                    pq.add(ele);
                    if(pq.size()>k){
                        pq.remove();
                    }
                }
                size = k;
            }
        //     tc O(1)
            public int add(int val) {
                if(pq.size()<size){
                    pq.add(val);
                }
                else if(pq.peek()<val){
                    pq.remove();
                    pq.add(val);
                }
                return pq.peek();
            }
        }
        
        /**
         * Your KthLargest object will be instantiated and called as such:
         * KthLargest obj = new KthLargest(k, nums);
         * int param_1 = obj.add(val);
         */
}

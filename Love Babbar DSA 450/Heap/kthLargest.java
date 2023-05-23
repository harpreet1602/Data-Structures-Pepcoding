package Heap;

public class kthLargest {
    class KthLargest {
        // 703. Kth Largest Element in a Stream
        // tc O(nlogk + logk) sc O(k)
        //  Add the elements in the priority queue intially here in this case min heap
        //     maintain the k largest elements into it
        //     in the add function whatever ele will come if it is greater than the kth largest element then that peak ele will be removed and new ele will be added in the priority queue maintaining the standard that the queue has k largest elements
        //     return the peak element from there.
            
        //     O(nlog k)
            PriorityQueue<Integer> pq;
            int lim;
            public KthLargest(int k, int[] nums) {
                pq = new PriorityQueue<>();
                for(int i=0;i<nums.length;i++){
                    pq.add(nums[i]);
                    if(pq.size()>k){
                        pq.remove();
                    }
                }
                lim = k;
            }
        //     O(k)
            public int add(int val) {
                if(pq.size()<lim){
                    pq.add(val);
                }
                else if(val>pq.peek()){
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

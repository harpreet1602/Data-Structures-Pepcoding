package Love Babbar DSA 450.Heap;

public class medianDataStream {
    class MedianFinder {
        // 295. Find Median from Data Stream
        // tc O(logn) sc O(n)
        //     Maximum element of Max Heap is less than the Minimum elememt of min heap
        //     We will use two heaps, one is max heap and one is min heap, so we will maintain
        //     the half numbers in one heap and the other half numbers in the other heap
        //     We will check whether the ele is less than max heap or max heap is empty, add the ele in the maxheap otherwise in the min heap and then do balancing if any heap size is greater than the other by 2 then remove the ele from larger to smaller size heap
        //     Then in findMedian whichever is larger by 1 return its peek
        //     or the average of both the peaks in case of equal size heaps.
            private PriorityQueue<Integer> max;
            private PriorityQueue<Integer> min;
            
            public MedianFinder() {
                max = new PriorityQueue<>((a,b)->{
                    return b-a;
                });
                min = new PriorityQueue<>();
            }
            
            public void addNum(int num) {
                if(max.size()==0 || num <= max.peek()){
                    max.add(num);
                }
                else{
                    min.add(num);
                }
                if(max.size()-min.size() == 2){
                    min.add(max.remove());
                }
                else if(min.size()-max.size() == 2){
                    max.add(min.remove());
                }
            }
            
            public double findMedian() {
                if(max.size()-min.size() == 1){
                    return (double)max.peek();
                }
                else if(min.size()-max.size() == 1){
                    return (double)min.peek();
                }
                return (double)(max.peek()+min.peek())/2;
            }
        }
        
        /**
         * Your MedianFinder object will be instantiated and called as such:
         * MedianFinder obj = new MedianFinder();
         * obj.addNum(num);
         * double param_2 = obj.findMedian();
         */
}

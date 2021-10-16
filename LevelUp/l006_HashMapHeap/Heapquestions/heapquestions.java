import java.util.*;
public class heapquestions {
    // https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
    // O(nlog k)
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
          return b-a;  
        });
        // n
        while(l<=r){
            pq.add(arr[l]);              //log k
            if(pq.size()>k){
                pq.remove();
            }
            l++;
        }
        return pq.peek();
    } 
    // kth smallest nikalna hai to max heap and kth largest then min heap 

    // optimised solution
    //  N + Klog n
    // make a heap then send k times the first ele at last in min heap

// O(1)
private static void swap(int[] arr,int x, int y){
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}
// O(log(n))
private static void downHeapify(int pi,int n,int[] arr){
    int lci = 2*pi +1;
    int rci = 2*pi + 2;
    int maxidx = pi;

    if(lci<=n && (arr[lci] < arr[maxidx])){
        maxidx = lci;
    }
    
    if(rci<=n && (arr[rci] < arr[maxidx])){
        maxidx = rci;
    }

    if(pi!=maxidx){
        swap(arr,pi,maxidx);
        downHeapify(maxidx,n,arr);
    }
}
public static void display(int[] arr){
    for(int ele:arr)
    System.out.print(ele+" ");
    System.out.println();
}
//     5
// 7 10 4 20 15
// 4

// 6
// 7 10 4 3 20 15
// 3


// 8
// 73 188 894 915 940 616 900 548
// 7
public static int kthSmallest1(int[] arr, int l, int r, int k) 
{ 
    //Your code here
    int n=arr.length,K = k;
    // boolean isIncreasing = false;
    for(int i=n-1;i>=0;i--){
        downHeapify(i,r,arr);
    }
    // display(arr);
    while(r>0 && k-->0){
    swap(arr,0,r--);
    downHeapify(0,r,arr);
    }
    // display(arr);
    return arr[n-K];
} 


    // 703. Kth Largest Element in a Stream
    class KthLargest {

        //     by default heap is minheap in java and maxheap in c++.
            PriorityQueue<Integer> pq ;
            int K;
            public KthLargest(int k, int[] nums) {
                pq = new PriorityQueue<>();
                K = k;
                for(int ele:nums){
                    pq.add(ele);
                    if(pq.size()>k){
                        pq.remove();
                    }
                }
            }
            
            public int add(int val) {
              pq.add(val);
                if(pq.size()>K){
                        pq.remove();
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

package Heap;

public class removeStones {
    
    // 1962. Remove Stones to Minimize the Total
// tc O(nlogn) sc O(n)
//    We need the maximum element each time after performing the operation
//     That is why we need priority queue here, so just take the max heap
//     Add all the elements in the pq and then just apply the operation
//     Operation is remove the maximum element and then add ele - (ele/2).
public int minStoneSum(int[] piles, int k) {
    //         Max Heap
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                return b-a;
            });
            int n = piles.length, sum=0;
            for(int i=0;i<n;i++){
                pq.add(piles[i]);
            }
            
            while(k-->0){
                int ele = pq.remove();
                pq.add(ele - (ele/2));
            }
            for(int ele:pq){
                sum += ele;
            }
            return sum;
        }
}

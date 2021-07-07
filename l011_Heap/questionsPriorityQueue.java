import java.util.PriorityQueue;
public class questionsPriorityQueue {
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int e:arr)
        {
        pq.add(e);
        if(pq.size()>k)
        {
            pq.remove();
        }
        }
        return pq.peek();
    } 
}

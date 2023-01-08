package Love Babbar DSA 450.Heap;

public class topkFrequent {
    
    // 347. Top K Frequent Elements
// tc O(nlogk) sc O(n+k)=> O(n)
//     Here we are using the combo of HashMap and priorityQueue 
//     make a freq map and then min heap of the keys
//     and accordingly while adding keys in the pq remove the ele after size exceeds k
//     in the end we get topmost k elements.
public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return map.get(a) - map.get(b);
    });

    int[] ans = new int[k];
    int idx = 0;
    for(int ele:nums){
        map.put(ele,map.getOrDefault(ele,0)+1);
    }
    
    for(int key:map.keySet()){
        pq.add(key);
        if(pq.size()>k){
            pq.remove();
        }
    }
    while(pq.size()!=0){
        ans[idx++] = pq.remove(); 
    }
    
    return ans;        
}
}

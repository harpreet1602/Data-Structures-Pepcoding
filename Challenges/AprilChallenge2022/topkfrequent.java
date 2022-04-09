public class topkfrequent {
    
//     347. Top K Frequent Elements
//     TC O(nlogk) SC O(n+k)
//     Prepare a frequency map and maintain a priority queue which will store integers
//     but the priority will be of the minimum frequency value of the key of the map.
//     So in the end whatever k elements that will be left in the prirority queue will be the answer.
public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
       return map.get(a) - map.get(b); 
    });
    
    for(int ele:nums){
        map.put(ele,map.getOrDefault(ele,0)+1);
    }
    
    for(int ele:map.keySet()){
        pq.add(ele);
        if(pq.size()>k){
            pq.remove();
        }
    }
    
    int[] ans = new int[k];
    int idx = 0;
    while(pq.size()>0){
        ans[idx++] = pq.remove();
    }
    return ans;
}
}

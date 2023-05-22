package Heap;

public class kFrequentElel {
    class Solution {
        // 347. Top K Frequent Elements
    // tc O(nlog k) sc O(n)
    //     Hashmap to store the frequency map and then min priority queue for storing the top k frequent elements.
    //    If the size exceeds k, remove element from the priority queue 
        private class Pair{
            int key;
            int val;
            
            public Pair(int key,int val){
                this.key = key;
                this.val = val;
            }
        }
        
        public int[] topKFrequent1(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
                return a.val-b.val;
            });
            int[] ans = new int[k];
            int ind = 0;
            
            for(int ele:nums){
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
            
            for(int key:map.keySet()){
                pq.add(new Pair(key,map.get(key)));
                if(pq.size()>k){
                    pq.remove();
                }
            }
            
            while(pq.size()!=0){
                Pair p = pq.remove();
                ans[ind++] = p.key;
            }
            return ans;
        }
        
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                return map.get(a)-map.get(b);
            });
            int[] ans = new int[k];
            int ind = 0;
            
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
                ans[ind++] = pq.remove();
            }
            return ans;
        }
    }
}

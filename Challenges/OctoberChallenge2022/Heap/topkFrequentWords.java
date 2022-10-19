public class topkFrequentWords{
    
//  692. Top K Frequent Words
//     tc O(nlog k) => for n strings, log k time for pq to remove 
    // sc O(n) => for hashmap
//     Idea is to make a frequency map
//     Priority queue such that lowest frequency string will come out first 
//         remove the lexicographically higher in case of equal frequencies.
//     In between add string of map and remove when the size of pq becomes greater than k
//     In the end add the strings of pq in the starting so that it gets added in reverse fashion.
//     Because it was a min heap.
public List<String> topKFrequent(String[] words, int k) {
    List<String> ans = new ArrayList<>();
    HashMap<String,Integer> map = new HashMap<>();
    for(String word:words){
        map.put(word,map.getOrDefault(word,0)+1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>((w1,w2)->{
       return map.get(w1) == map.get(w2)? w2.compareTo(w1): map.get(w1)-map.get(w2); 
    });
    
    for(String word:map.keySet()){
        pq.add(word);
        if(pq.size()>k) pq.remove();
    }
    while(pq.size()!=0){
        ans.add(0,pq.remove());
    }
    return ans;
}
}
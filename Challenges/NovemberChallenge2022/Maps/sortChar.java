public class sortChar{
    
    // 451. Sort Characters By Frequency
// Brute => PriorityQueue, store the hashmap keys into it and get the highest freq key first from it
// so that it can be added in the string that freq times
// TC O(nlogn) Sc O(n) I think

// Optimised.
// TC O(n) SC O(n)
// Store the freq map
// Array of arraylist of character is made to store index=> list of characters with index frequency
// we will traverse from back and will make our string.
public String frequencySort(String s) {
    HashMap<Character,Integer> map = new HashMap<>();
    int n = s.length(),max=0;

    for(int i=0;i<n;i++){
        char ch = s.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
        max = Math.max(max,map.get(ch));
    }

    ArrayList<Character>[] arr = new ArrayList[max+1];
   
    for(Character ch:map.keySet()){
        int idx = map.get(ch);
        if(arr[idx] == null){
            arr[idx] = new ArrayList<>();
        }
        arr[idx].add(ch);
    }    
        
    StringBuilder sb = new StringBuilder();
    for(int i=arr.length-1;i>=0;i--){
        if(arr[i]!=null){
            for(Character ch:arr[i]){
                for(int j=0;j<i;j++){
                    sb.append(ch);
                }
            }
        }
    }
    return sb.toString();
}
}
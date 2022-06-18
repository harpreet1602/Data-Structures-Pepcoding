public class prefixSuffix {
    
// 745. Prefix and Suffix Search
//     tc O() sc O()
//     Trie solution will be implemented later on.
    
//     Brute force => use StartsWith and EndsWith for prefix and suffix search in every word. => TLE

//     HashMap solution
//     tc O(N*length*length) => length of each word 
   //  sc O(n*l*l)
//     Store every possible prefix and suffix pair in a  hashmap with a seperator like prefix#suffix with the index in word of all the words
//     then query it using amotised O(1) time
    
private HashMap<String,Integer> map;

public WordFilter(String[] words) {
    map = new HashMap<>();
    int index = 0;        
    for(String word:words){
        for(int i=0;i<=word.length();i++){
            for(int j=0;j<=word.length();j++){
                String prefixSuffix = word.substring(0,i) + "#" + word.substring(j);
                map.put(prefixSuffix,index);
            }
        }
        index++;
    }
}

public int f(String prefix, String suffix) {
    String prefixSuffix = prefix + "#" + suffix;
    return map.getOrDefault(prefixSuffix,-1);
}
}

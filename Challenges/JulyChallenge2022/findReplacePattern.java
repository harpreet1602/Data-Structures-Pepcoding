public class findReplacePattern {
    
    // 890. Find and Replace Pattern
//     tc O(m*n) => m = word.length, n = word.length  sc O(n)
//     Make a pattern string by character to integer mapping and then check each of the words satisfying the pattern string will become part of the answer set.
//    while mapping it will be character to map.size() if that character is coming for the first time
//     do a dry run to understand the algo
public List<String> findAndReplacePattern(String[] words, String pattern) {
    String p = normalise(pattern);
    List<String> list = new ArrayList<>();        
    for(String word:words){
        if(p.equals(normalise(word))){
            list.add(word);
        }
    }
    return list;
}
private String normalise(String input){
    HashMap<Character,Integer> map = new HashMap<>();
    String ans = "";
    for(int i=0;i<input.length();i++){
        char ch = input.charAt(i);
        map.putIfAbsent(ch,map.size());
        ans += map.get(ch);
    }
    return ans;
}
}

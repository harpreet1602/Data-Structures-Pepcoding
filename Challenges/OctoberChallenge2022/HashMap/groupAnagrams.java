public class groupAnagrams {
    
    // 49. Group Anagrams
//     tc O(n*len)=>O(n^2) sc O(n)
//     Build a unique key for all the strings from the frequency map of each string
//     store its list corresponding to the key in hashmap
//     and then return all the groups of anagram.
public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String,List<String>> map = new HashMap<>();
    
    for(String str:strs){
        String key = buildKey(str);
        List<String> list = map.getOrDefault(key,new ArrayList<>());
        list.add(str);
        map.put(key,list);
    }
    return new ArrayList<>(map.values());
}
private String buildKey(String str){
    char[] arr = new char[26];
    for(char ch:str.toCharArray()){
        arr[ch-'a']++;
    }
    return new String(arr);
}
}

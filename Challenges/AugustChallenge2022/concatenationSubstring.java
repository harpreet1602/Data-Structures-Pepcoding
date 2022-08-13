public class concatenationSubstring {
            
// 30. Substring with Concatenation of All Words
//     tc O(n^2) sc O(n) i think
//     Put the word of words in hashmap and check from every index that is there a possibility of getting the concatenation of substrings or not.
//     copy of map will be created for each index to check from there on the substrings concatenation
public List<Integer> findSubstring(String s, String[] words) {
    HashMap<String,Integer> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    int n = s.length(),len=words[0].length();
    for(String word: words){
        map.put(word,map.getOrDefault(word,0)+1);
    }
    for(int i=0;i<=n - len*words.length;i++){
        HashMap<String,Integer> copyMap = new HashMap<>(map);
        
        for(int j=0;j<words.length;j++)
        {
            String str = s.substring(i+j*len,i+j*len+len);
            
            if(copyMap.containsKey(str)){
                int count = copyMap.get(str);
                if(count == 1) copyMap.remove(str);
                else{
                    copyMap.put(str,count-1);
                }
                if(copyMap.isEmpty()){
                    ans.add(i);
                }
            }else{
                break;
            }
        }
       
    }
    return ans;
}
}

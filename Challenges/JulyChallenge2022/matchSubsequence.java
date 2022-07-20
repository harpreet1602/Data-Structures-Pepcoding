public class matchSubsequence{
    
    // 792. Number of Matching Subsequences
//     tc O(n) sc O(n) i think
//     Brute can also be applied.
//     optimised => character to queue mapping is done.
//    Accorrdingly their first characters are gettting deleted each time and assigned into the new group. 
public int numMatchingSubseq(String s, String[] words) {
    HashMap<Character,LinkedList<String>> map = new HashMap<>();
    int n = s.length();
    for(int i=0;i<n;i++){
        char ch = s.charAt(i);
        if(!map.containsKey(ch)){
            map.put(ch,new LinkedList<>());
        }
    }
    
    for(String word:words){
        char ch = word.charAt(0);
        if(map.containsKey(ch)){
           map.get(ch).addLast(word); 
        }
    }
    
    int ans = 0;
    for(int i=0;i<n;i++){
        char ch = s.charAt(i);
        LinkedList<String> list = map.get(ch);
        int size = list.size();
        for(int j=0;j<size;j++){
            String str = list.removeFirst();
            // str = str.substring(1);
            if(str.substring(1).length()==0){
                ans++;
            }
            else{
                char c =str.charAt(1);
                if(map.containsKey(c)){
                    map.get(c).addLast(str.substring(1));
                }
            }
        }
    }
    return ans;
}
}
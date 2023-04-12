package HashMap;

public class longestPallindrome {
    class Solution {
        // 2131. Longest Palindrome by Concatenating Two Letter Words
    // tc O(n) sc O(n)
    //  Here we can see that the strings are of length 2 so one can be put on left side
    //     and its reverse can be put on the other side, for the string with same characters only one out of all can be put in the center and rest even frequency can be considered.
    //     Use hashmap to make frequency map first
    //     then traverse on the key set and then apply the logic.
    //     
        public int longestPalindrome(String[] words) {
            HashMap<String,Integer> map = new HashMap<>();
            int n = words.length, ans=0;
            boolean flag = false;
            
            for(int i=0;i<n;i++){
                map.put(words[i],map.getOrDefault(words[i],0)+1);
            }
            for(String key:map.keySet()){
                
                if(key.charAt(0) == key.charAt(1)){
                        if(map.get(key)%2!=0){
                            flag = true;
                            ans += (map.get(key)-1)*2;
                        }
                        else{
                            ans += (map.get(key)*2);
                        }
                }
                else{
                    StringBuilder sb = new StringBuilder();
                    sb.append(key);
                    String reverseStr = sb.reverse().toString();
                    if(map.containsKey(reverseStr)){
                        ans += (Math.min(map.get(key),map.get(reverseStr))*4);
                        map.put(key,0);
                    }
                }
            }
            return flag==true?ans+2:ans;
        }
    }
}

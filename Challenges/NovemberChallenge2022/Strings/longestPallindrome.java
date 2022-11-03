public class longestPallindrome{
    
    // 2131. Longest Palindrome by Concatenating Two Letter Words
//     tc O(n) sc O(n)
//     Make a string to integer mapping
//     Accordingly apply conditions on various test cases possible
//     Like if the string is pallindrome then check if its freq is even then freq is taken
//     otherwise freq-1 is considered because that will be pallindrome once joined together
//     Or the case where the reverse string exists then take the minimum freq between the two string multiply by 4 and add it in the answer as ty yl makes 4 length palindrome string
//    Also if we have encountered the case where freq-1 was considered ever then +2 will be done to ans as one string can be put in the middle.
//     In the end len * 2 will also get added as we tracked the freq of the strings there 
    // ll ll => len =2 => ans += 2*2.
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int ans = 0,len = 0;
        boolean flag = false;
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        for(String word:map.keySet()){
            int freq = map.get(word);
            if(freq!=0){
            if(word.charAt(0) == word.charAt(1)){
                if(freq%2==0){
                    len += freq;
                }
                else{
                    len += (freq-1);
                    flag = true;
                }
            }
            else if(word.charAt(0)<word.charAt(1)){
                String rword = ""+word.charAt(1)+word.charAt(0);
                if(map.containsKey(rword)){
                    ans += (Math.min(freq,map.get(rword))*4);
                }
            }
            }
        }
        ans += (len*2);
        if(flag){
            ans += 2;
        }
        return ans;
    }
}
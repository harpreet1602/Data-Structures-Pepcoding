public class mergeStrings {
    class Solution {
        // 1768. Merge Strings Alternately
    // tc O(n+m) sc O(1)
    //     Just take a stringbuilder and use two pointers and add the characters of the word alternatively.
    //     handle the cases where one string can be bigger than the second one.
        public String mergeAlternately(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            int i=0,j=0,n=word1.length(),m=word2.length();
            
            while(i<n && j<m){
                sb.append(word1.charAt(i++));
                sb.append(word2.charAt(j++));
            }
            while(i<n){
                sb.append(word1.charAt(i++));
            }
            while(j<m){
                sb.append(word2.charAt(j++));
            }
            return sb.toString();
        }
    }
}

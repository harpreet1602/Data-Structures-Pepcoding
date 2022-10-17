public class checkPangram {
    
//     1832. Check if the Sentence Is Pangram
//     tc O(n+26) => O(n) sc O(26) => O(1)
//    Just create a frequency map and keep track of all the characters of the string.
//    After that check that if any character is not present then return false
//    Otherwise return true.
    
public boolean checkIfPangram(String sentence) {
    boolean[] freq = new boolean[26];
    int n = sentence.length();
    
    for(int i=0;i<n;i++){
        freq[sentence.charAt(i)-'a'] = true;
    }
    
    for(int i=0;i<26;i++){
        if(freq[i]==false){
            return false;
        }
    }
    return true;
}

}

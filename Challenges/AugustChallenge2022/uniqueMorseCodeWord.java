import java.util.HashSet;

public class uniqueMorseCodeWord {
    
    // 804. Unique Morse Code Words
//     tc O(S), where S is the sum of the lengths of words in words. We iterate through each character of each word in words
//     Space Complexity: O(S)
//     Just make the string array for mapping and hashset to store unique strings and return hashset's size.
public int uniqueMorseRepresentations(String[] words) {
    String[] map = new String[]{
        ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };
    
    HashSet<String> set = new HashSet<>();
    
    for(String word:words){
        StringBuilder newStr = new StringBuilder();
        for(char ch:word.toCharArray()){
            int index = ch - 'a';
            newStr.append(map[index]);
        }
        set.add(newStr.toString());
    }
    return set.size();
}
}

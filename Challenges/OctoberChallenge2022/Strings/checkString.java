public class checkString{
    
    // 1662. Check If Two String Arrays are Equivalent
//     tc O(2*n) => O(n) sc O(2*n)
//     simply make a string builder and append the strings of word respectively and compare them
public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    String w1 = concatString(word1);
    String w2 = concatString(word2);
    return w1.equals(w2);
}
private String concatString(String[] words){
    StringBuilder sb = new StringBuilder();
    for(String word:words){
        sb.append(word);
    }
    return sb.toString();
}
}
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class shortEncoding {
    
    // 820. Short Encoding of Words
//     Tries solution will be done later.
    
    
    // tc O(n^2) sc O(n)
//     First of all set will be used to convert the array to hashset because we need to delete duplicate entries. Like a a a b => a b
//     then set to arraylist to access the elements
//     One more hashset for storing those strings which are a part of any other big string and it will always be at the end of big string  
//     We will find out all these strings by nested loops and then put it in the hashset.
//    After that traverse the normal array list and all those strings which are not in duplicate hashset, add their length() and + 1 for '#'.    
public int minimumLengthEncoding(String[] words) {
    HashSet<String> duplicate = new HashSet<>();
    Set<String> set = new HashSet<>(Arrays.asList(words));
    List<String> wordsList = new ArrayList<>(set);
    
    int count = 0, n = wordsList.size();
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i!=j){
                if(wordsList.get(i).endsWith(wordsList.get(j))){
                    duplicate.add(wordsList.get(j));
                }
            }
        }
    }
    
    for(int i=0;i<n;i++){
        if(!duplicate.contains(wordsList.get(i))){
            count = count + wordsList.get(i).length() + 1;
        }
    }
    
    return count;

}
}

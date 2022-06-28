import java.util.HashSet;


public class minDeletionsCharacterUnique {
    
//     1647. Minimum Deletions to Make Character Frequencies Unique
//     tc O(n) sc O(n)
//     Maintain the frequency array of the characters present.
//     Then traverse throught the frequency array and if the frequency number has come before as well in the set
//     Then don't allow it to get added to the set until its frequency is decreased to the point it becomes unique and inrement the delCountOperations.
//     Then only add it into the hashset either it has become unique or 0.
//     0 will not affect us 
public int minDeletions(String s) {
    int delCount = 0;
    int[] freq = new int[26];
    HashSet<Integer> set = new HashSet<>();
    for(char ch:s.toCharArray()){
        freq[ch-'a']++;
    }
    
    for(int i=0;i<26;i++){
        while(freq[i]!=0 && set.contains(freq[i])){
            freq[i]--;
            delCount++;
        }
        set.add(freq[i]);
    }
    return delCount;
}
}

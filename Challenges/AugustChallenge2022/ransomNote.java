public class ransomNote {
    
    // 383. Ransom Note
//     tc O(n) sc O(26)=>O(1)
//     Simply calculate the frequency in hashtable of the second string
//     check the frequency of first string now 
public boolean canConstruct(String ransomNote, String magazine) {
    int[] freq = new int[26];
    
    for(char ch:magazine.toCharArray()){
        freq[ch-'a']++;
    }
    for(char ch:ransomNote.toCharArray()){
        if(freq[ch-'a']<=0){
            return false;
        }
        freq[ch-'a']--;
    }
    return true;
}
}

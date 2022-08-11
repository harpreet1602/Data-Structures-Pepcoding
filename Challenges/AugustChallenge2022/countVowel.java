import java.util.HashMap;
public class countVowel{
    
//     1220. Count Vowels Permutation
// TC O() SC O() have to study
//     backtracking with memoisation
//     finding all the possibilities for every vowel how many valid permutations can be made according to the rules mentioned.
//     
HashMap<String,Long> map = new HashMap<>();
int mod = (int)1e9+7;

public int countVowelPermutation(int n) {
    long total = 0;
    char[] vowels= {'a','e','i','o','u'};
    for(char ch:vowels){
        total = (total + countVowelHelper(n-1,ch))%mod;
    }
    return (int)total;
}
//     if the remainingChar is 0 this means you have found one permutation
//     Otherwise make a key and check in map if it's already present the return it => memoisation
//     for the prevChar whatever  it is accordingly call for the next ones according to the rules
//     in the end put in map 
//     return total permutations on current level with remaingChar and with a prevChar character
private long countVowelHelper(int remainingChar, char prevChar){
    if(remainingChar == 0){
        return 1;
    }
    String key = "" + remainingChar + prevChar;
    if(map.containsKey(key)){
        return map.get(key);
    }
    long total = 0;
    switch(prevChar){
        case 'a': 
            total = countVowelHelper(remainingChar-1,'e')%mod;
            break;
        case 'e': 
            total = (countVowelHelper(remainingChar-1,'a') + countVowelHelper(remainingChar-1,'i'))%mod;
            break;
        case 'i': 
            total = (countVowelHelper(remainingChar-1,'a') + countVowelHelper(remainingChar-1,'e') + countVowelHelper(remainingChar-1,'o') + countVowelHelper(remainingChar-1,'u'))%mod;
            break;   
        case 'o': 
            total = (countVowelHelper(remainingChar-1,'i') + countVowelHelper(remainingChar-1,'u'))%mod;
            break; 
        case 'u': 
            total = countVowelHelper(remainingChar-1,'a')%mod;
            break;
    }
    map.put(key,total);
    return total;
}
}
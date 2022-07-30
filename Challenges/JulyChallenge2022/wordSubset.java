public class wordSubset {
    
    // 916. Word Subsets

//    First of brute force can be get a frequency map of every string in words2 and search its frequency with every string's frequency in word1 => tc O(words1.length*words2.length)
    
//     Optimised

    // //     tc O((words1.length*word1) + (words2.length*word2)), sc O(words1.length + words2.length)
//     Get the commulative frequency from the all the strings of words2 array
//     so at each place maximum freq required will be placed 
//     Now check this frequency map with all the frequency map of all the strings of words1 array
//     words1 string's frequency at each place of 26 characters must be greater than or equal to the words2 commulative frequency map's values
public List<String> wordSubsets(String[] words1, String[] words2) {
    int[] maxbstrfreq = new int[26];
    boolean flag = true;
    List<String> list = new ArrayList<>();
    for(String word2:words2){
        int[] bstrfreq = getFreqMap(word2);
        for(int i=0;i<26;i++){
            maxbstrfreq[i] = Math.max(maxbstrfreq[i],bstrfreq[i]);
        }
    }
    
    for(String word1:words1){
        int[] astrfreq = getFreqMap(word1);
        flag = true;
        for(int i=0;i<26;i++){
            if(astrfreq[i]<maxbstrfreq[i]){
                flag = false;
                break;
            }
        }
        if(flag){
            list.add(word1);
        }
    }
    return list;
}
private int[] getFreqMap(String str){
    int[] freq = new int[26];
    for(int i=0;i<str.length();i++){
        freq[str.charAt(i)-'a']++;
    }
    return freq;
}
}

public class longestStringChain {
    
    // 1048. Longest String Chain
//     tc O(n*l*l) sc O(n)
//     Longest increasing subsequence  DP type thing will be used here.
//     for each string, cut at every index and find its predecessor string and ask for the length of the longest possible chain till that predecessor.
//     At current level it would be longestPredecessor = Math.max(longestPredecessor,dp.getOrDefault(predecessor,0)+1)
//     So it will check all the predecessor and their length + 1 whichever will be maximum that we will assign it to the current word in DP after loop
//    dp.put(word,longestPredecessor);
//     Also check for the overall maximum answer that is seen throughout the array
//     max = Math.max(max,longestPredecessor);
public int longestStrChain(String[] words) {
    int n = words.length,max=0;
    HashMap<String,Integer> dp = new HashMap<>();
    Arrays.sort(words,(a,b)->{
       return a.length()-b.length();            //nlogn
    });
    for(String word:words){        //n
        int longestPredecessor = 0;
        for(int i=0;i<word.length();i++){ //l
            String predecessor = word.substring(0,i) + word.substring(i+1,word.length());     //l
            longestPredecessor = Math.max(longestPredecessor,dp.getOrDefault(predecessor,0)+1);
        }
        dp.put(word,longestPredecessor);
        max = Math.max(max,longestPredecessor);
    }
    return max;
    
}
}

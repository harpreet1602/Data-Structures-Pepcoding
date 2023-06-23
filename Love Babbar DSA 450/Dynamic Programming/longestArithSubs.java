public class longestArithSubs {
    
    // 1027. Longest Arithmetic Subsequence
// tc O(n^2) sc O(n^2)
//     So here dp will be used with hashmaps
//     why? the idea is to store the difference vs the maximum length subsequence with that difference till now
//     when we are standing at the current index, we ask all the previous index's difference and their length of the subsequence with that difference or by default take it as 1 plus one for current number
//     maintain the current index value difference vs new length
//     maintain the maxlength track in the overall procedure.
public int longestArithSeqLength(int[] nums) {
    int n = nums.length, len = 1, diff, newLen;
    HashMap<Integer,Integer>[] dp = new HashMap[n];
    
    for(int i=0;i<n;i++){
        dp[i] = new HashMap<>();
        for(int j=0;j<i;j++){
            diff = nums[i] - nums[j];
            newLen = dp[j].getOrDefault(diff,1)+1;
            dp[i].put(diff,newLen);
            len = Math.max(len,newLen);
        }
    }
    return len;
}
}

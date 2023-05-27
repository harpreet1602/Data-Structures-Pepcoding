public class stoneGame3 {
    class Solution {
        // 1406. Stone Game III
    // tc O(n) sc O(n)
    //     can be done through all these approaches, do this later
    //     Recursion
    //     top to down
    //     bottom to up
    //     space optimization using three variables can be done
    //     fraz video for understanding
        
    //     Here we are considering the the score till now minus whatever will be returned by calling recursively for the answer from the next index
    //     at the current iteration we consider three values like 1, 2, or 3 piles can be taken and then calls for the other person's turn
    //     returns the maximum of the res from the choices explored to the higher level while backtracking
    //     memoise this solution using 1d dp to store the result of computation at the current index
        public String stoneGameIII(int[] stoneValue) {
            int[] dp = new int[stoneValue.length];
            Arrays.fill(dp,-(int)1e9);
            int val = stoneGame(stoneValue,0,dp);
            if(val == 0){
                return "Tie";
            }
            else if(val<0){
                return "Bob";
            }
            return "Alice";
        }
        
        private int stoneGame(int[] stoneValue,int idx,int[] dp){
            int n = stoneValue.length;
            if(idx == n){
                return 0;
            }
            if(dp[idx]!=-(int)1e9){
                return dp[idx];
            }
            int score = 0,res=-(int)1e9;
            for(int i=idx;i<Math.min(idx+3,n);i++){
                score += stoneValue[i];
                res = Math.max(res,score - stoneGame(stoneValue,i+1,dp));
            }
            return dp[idx] = res;
        }
    }
}

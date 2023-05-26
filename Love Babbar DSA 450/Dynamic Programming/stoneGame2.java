public class stoneGame2 {
    class Solution {
        // 1140. Stone Game II
    // tc O() sc O()
    //     need to dry run properly
    //     difficult to understand
    //     alice and bob plays optimally
    //     suppose alice takes x=2 then m becomes 2 then in the next step bob can take 2*m => 4 steps so bob has the choice of exploring all the options from 1 to 4 steps then
    //     turns, index of the piles and m is getting updated so use 3d dp to memoise the solution
    //     
        public int stoneGameII(int[] piles) {
            int n = piles.length;
            int[][][] dp = new int[2][n+1][n+1];
            
            for(int[][] arr:dp){
                for(int[] ar:arr){
                    Arrays.fill(ar,-1);
                }
            }
            
            return stoneGame(piles,dp,0,0,1);
        }
        
        private int stoneGame(int[] piles,int[][][] dp,int turn,int idx,int m){
            int n = piles.length;
            
            if(idx == n){
                return 0;
            }
            
            if(dp[turn][idx][m]!=-1){
                return dp[turn][idx][m];
            }
    //         maximise alice res and minimize bob's result
    //         bob => take int 1e6 and for alice take -1
            int res = turn == 1?(int)1e6:-1;
            int score = 0;
    // from 1 to min of 2*m or n-idx piles can be picked         
            for(int x=1;x<=Math.min(2*m,n-idx);x++){
    //             score is getting made by picking the current pile
                score += piles[idx+x-1];
    //             then according to alice turn res willget updated  by max of prev res or
    //             current score of picking and calling for the next turn of bob
                if(turn == 0){
                    res = Math.max(res,score+stoneGame(piles,dp,1,idx+x,Math.max(m,x)));
                }
    //             no need to add score for bob because we are concerned with alice score
                else{
                    res = Math.min(res,stoneGame(piles,dp,0,idx+x,Math.max(m,x)));
                }
            }
    //         update the answer in dp
            return dp[turn][idx][m] = res;
        }
    }
}


import java.util.Arrays;

public class coinChange {
    
//    322. Coin Change
//     tc O(n*amount) sc O(amount)
//     Tabulation is applied and we are filling all the indexes except the first as maximum because 0 to 0 requires 0 coins
// index represents the how many coins will be needed to reach current amount present at index.
//     Then if valid, we will calculate dp[i] = Math.min(dp[i],dp[i-coin]+1);
//  this is because from 2 or 5 or 6 how many coins will be needed to reach 7
//     because coins are [1,2,5] in sample case and the answer will be calculated in this fashion only.
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    Arrays.fill(dp,(int)1e9);
    dp[0] = 0;
    for(int i=0;i<=amount;i++){
        for(int coin:coins){
            if(i-coin>=0 && dp[i-coin]!=(int)1e9){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
    }
    
    if(dp[amount]==(int)1e9){
        return -1;
    }
    else{
        return dp[amount];
    }
    
}
}

public class buySellTransFee {
    
    // 714. Best Time to Buy and Sell Stock with Transaction Fee
// tc O(n) sc O(n*2)
//     recursion + memoisation, it can be space optimised more
//     we have two options of doing either buy or sell
//     so if we called for buy at the current index
//     then we also have two options either to buy with -prices[index]+call for next by allowing sell or not buy by directly calling the next by allowing buy => take the maximum 
    
    // Second case, is of the sell 
//     either sell with +prices[index] - fees + call for next to buy
//     or not sell with the call for next to sell. => take the maximum
//    and store it in dp[index][buy] and return from the current index with the option of buying(1) or selling(0)
    
public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    for(int[] arr:dp)
    Arrays.fill(arr,-1);
    return maxProfit(0,1,prices,fee,dp);
}

private int maxProfit(int index,int buy,int[] prices, int fee,int[][] dp){
    if(index == prices.length){
        return 0;
    }
    
    if(dp[index][buy]!=-1){
        return dp[index][buy];
    }
    
    if(buy == 1){
        dp[index][buy] = Math.max(-prices[index]+maxProfit(index+1,0,prices,fee,dp),maxProfit(index+1,1,prices,fee,dp));
    }
    else{
        dp[index][buy] = Math.max(prices[index]-fee+maxProfit(index+1,1,prices,fee,dp),maxProfit(index+1,0,prices,fee,dp));
    }
    return dp[index][buy];
}
}

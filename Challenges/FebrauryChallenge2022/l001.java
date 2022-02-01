public class l001{
    
//     121. Best Time to Buy and Sell Stock
//     tc O(n) sc O(1)
//     We are coming to a price and we will ask two questions that can I buy here or
//     sell here. If we will get a negative profit then we will keep it as 0.
//     If we haven't buy yet we can't sell so these condition is also taken care by
//     minus infinity starting point for buying.

    public int maxProfit(int[] prices) {
        int dpi0 = 0, dpi1 = -(int)1e9;
        for(int i=0;i<prices.length;i++){
            dpi0 = Math.max(dpi0,dpi1+prices[i]);  //selling
            dpi1 = Math.max(dpi1,0-prices[i]);     //buying
        }
        return dpi0;
    }

    


}
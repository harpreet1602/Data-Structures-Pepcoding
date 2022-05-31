public class coinChange {
    // 322. Coin Change
// brute force
//     tc O() sc O()
//     Combination from the current index can be applied
//     As I can take many instances of the current number in my answer.
//     call only when it is valid to call recursively.
//     When the amount becomes zero, check the minimum no. of coins and store it in min global variable.
//     Return the min i.e. minimum no. of coins 
private int min = (int)1e9;
public int coinChange1(int[] coins, int amount) {
    int n = coins.length,numCoins=0,idx=0;
    
    combinationCoins1(coins,amount,idx,numCoins);
    
    return min==(int)1e9?-1:min;
}

private void combinationCoins1(int[] coins,int amount,int idx,int numCoins){
    if(amount == 0){
        min = Math.min(min,numCoins);
        return;
    }
    
    for(int i=idx;i<coins.length;i++){
        if(amount-coins[i]>=0)
        combinationCoins1(coins,amount-coins[i],i,numCoins+1);
    }
}

//     Optimised
//     tc O(amount*coins.length) sc O(amount)
//     Dp is applied to get the answer to remove TLE.
//     Idea is to maintain the dp array of size amount whose significance is that how 
//     can I be made by using minimum number of coins 
//     So at each place we have to check all the coins array elements backwards + 1
//     and minimum of that will be stored at the current amount i.e. dp index.
//     In the end, if we get (int)1e9 then this means amount cannot be made using those coins.
  public int coinChange(int[] coins, int amount) {
      int[] ans = new int[amount+1];
      int min;
      
      for(int i=1;i<ans.length;i++){
          min = (int)1e9;
          for(int ele:coins){
              if(i-ele>=0){
                  min = Math.min(min,ans[i-ele]+1);
              }
          }
          ans[i] = min;
      }
      return ans[ans.length-1]==(int)1e9?-1:ans[ans.length-1];
    
  }
}

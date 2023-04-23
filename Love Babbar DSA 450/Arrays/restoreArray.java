public class restoreArray {
    class Solution {
        // 1416. Restore The Array
    // tc O(n*logk) sc O(n)
    //     complexity understand once more
    //     we will take the current number and call for the recursion from the next numbers
    //     following this faith recursion will be applied then at every index, all the ways of making the arrays will be stored so
    //     memoisation can be done to optimize the solution.
        private int mod = (int)1e9+7;
        public int numberOfArrays(String s, int k) {
            int[] dp = new int[s.length()];
            Arrays.fill(dp,-1);
            return countArrays(s,k,0,dp)%mod;
        }
        private int countArrays(String s,int k,int index,int[] dp){
            // System.out.println(index);        
            if(index==s.length()){
                return 1;
            }
            
            if(dp[index]!=-1){
                return dp[index];
            }
            if(s.charAt(index)=='0'){
                return 0;
            }
            int count = 0;
            long number=0;
            
            for(int i=index;i<s.length();i++){
                number = number*10 + s.charAt(i)-'0'; 
                // System.out.println(number);
                if(number>k){
                    break;
                }
                count = (count + countArrays(s,k,i+1,dp))%mod;
            }
            return dp[index]=count;
        }
    }
}

public class oneZero{
    // 474. Ones and Zeroes
//     tc O(n*m*len) sc O(n*m*len)
//     
private int[][][] dp = null;
//     make the frequency array of 0,1 of every string.
    private int[] getFreqCount(String str){
        int[] freq = new int[2];
        for(char ch:str.toCharArray()){
            if(ch=='0'){
                freq[0]++;
            }
            else{
                freq[1]++;
            }
        }
        return freq;
    }

    private int helper(String[] strs,int m, int n,int index, int[][] strFreq){
// if it goes to invalid position then return 0  => base case
        if(index>=strs.length || (m+n)<=0){
            return 0;
        }
//         memoisation to eliminate the TLE
        if(dp[m][n][index]>0){
            return dp[m][n][index];
        }
//         Two choices whether to add the current string or not
// calculate for both and get the maximum out of these two for the current state.        
        int currInc = 0;
        int currExc = 0;
        
        int zeroFreq = strFreq[index][0];
        int oneFreq = strFreq[index][1];
        
        
        if(m-zeroFreq >= 0 && n-oneFreq>=0){
            currInc = 1 + helper(strs,m-zeroFreq,n-oneFreq,index+1,strFreq);
        }
        currExc = helper(strs,m,n,index+1,strFreq);
//         Put it m,n,index to store the result and use it whenever required.
        dp[m][n][index] = Math.max(currInc,currExc);
        
        return dp[m][n][index];
    }
    
    
    
    public int findMaxForm(String[] strs, int m, int n) {
//         freq of 0 & 1
        int len = strs.length;
//         3D DP is applied on the changing parameters => memoisation to avoid the TLE
        dp = new int[m+1][n+1][len];
//      store current string's => freq of   no of 0, no of 1
        
        int[][] strFreq = new int[len][2];
        
        int i =0 ;
//         Making the array where at the corresponding string their no. of 0's & 1's are stored.
        for(String str:strs){
            strFreq[i] = getFreqCount(str);
            i++;
        }
//        call for the recursion 
        return helper(strs,m,n,0,strFreq);
        
    }

}
public class l001{
   
//     tc: O(n^3) sc: O(n^2)
//     gap strategy is used.
//    https://www.youtube.com/watch?v=YzvF8CqPafI
//     Make dp table then you will understand the solution
//     for every gap we go from si  to ei
//     then in that we go for bursting the current cut at the last
//      so bring the answer from left and right in that interval of (si-ei)
//    then cut ele * si-1 ele * ei+1 ele will act as the val for bursting 
//     curr cut ele and then in it as we are going for all permutations
//     go for the maximum one and then assign it into the dp
//     in the end ans will be contained like from 0 to n-1 in dp[0][n-1]
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int gap = 0;gap<n;gap++){
            for(int si=0,ei=gap;ei<n;si++,ei++){
            int max = -(int)1e9;
                for(int cut=si;cut<=ei;cut++){
                    int left = cut==si?0:dp[si][cut-1];
                    int right = cut==n-1?0:dp[cut+1][ei];
                    int currVal = (si==0?1:nums[si-1])*nums[cut]*(ei==n-1?1:nums[ei+1]);
                    int total = left+right+currVal;
                    max = Math.max(total,max);
                }
                dp[si][ei] = max;
            }
        }
        return dp[0][n-1];
    }

    //     1010. Pairs of Songs With Total Durations Divisible by 60
// check for every number for the pair
//     tle => brute force => tc O(n^2) sc O(1)
    public int numPairsDivisibleBy601(int[] time) {
        int count=0,n=time.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((time[i]+time[j])%60==0){
                    count++;
                }
            }
        }
        return count;
    }
    
//     tc O(n) + 30 => O(n)
    // sc O(1)
    // now here if we divide a no by 60 we get remainders from 0 to 59
    // so make a array of 60 and store the remainders of all the numbers
    // then from 1 to 29 if their pair exist then the combinations will be mC1 * nC1 = m*n
    // for 0 and 30 the combinations will be pC2 = p*(p-1)/2
    public int numPairsDivisibleBy60(int[] time) {
        int[] freqMap = new int[60];
        int ans=0;
        for(int i=0;i<time.length;i++){
            int rem = time[i]%60;
            freqMap[rem]++;
        }
        
        for(int i=1;i<30;i++){
            ans += freqMap[i] * freqMap[60-i];
        }
        
        if(freqMap[0]>0)
        ans += freqMap[0]*(freqMap[0]-1)/2;
    
        if(freqMap[30]>0)
        ans += freqMap[30]*(freqMap[30]-1)/2;
        return ans;
    }
        
    
//    997. Find the Town Judge 
//    tc O(n) sc O(n) 
//     any node with outdegree = 0 && indegree = n-1 will be the town judge
    public int findJudge(int n, int[][] trust) {
        int[] inwardDegree = new int[n+1];
        int[] outwardDegree = new int[n+1];
        for(int i=0;i<trust.length;i++){
            int countOut = outwardDegree[trust[i][0]];
            outwardDegree[trust[i][0]] = countOut + 1;
            int countIn = inwardDegree[trust[i][1]];
            inwardDegree[trust[i][1]] = countIn + 1;
        }
        
        for(int i=1;i<=n;i++){
            if(outwardDegree[i] == 0 && inwardDegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }

}
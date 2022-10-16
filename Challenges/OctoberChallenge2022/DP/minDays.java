public class minDays {
    
    // 1335. Minimum Difficulty of a Job Schedule
//     tc O() sc O()
//     We have to explore the possibilities so we are doing dp applying it partition by partition
//     days and index will change, d-1 partitions will happen in that partition s maximum element should come
//     and the overall result should be minimum.
//     have to understand more
public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if(n<d){
        return -1;
    }
    int[][] dp = new int[d+1][n];
    
    for(int[] arr:dp)
    Arrays.fill(arr,-1);
    
    return dfs(dp,jobDifficulty,d,0);
}
public int dfs(int[][] dp, int[] jobDifficulty,int d,int idx){
    if(d==1){
        int max = 0;
        while(idx<jobDifficulty.length){
            max = Math.max(max,jobDifficulty[idx++]);
        }
        return max;
    }
    if(dp[d][idx]!=-1){
        return dp[d][idx];
    }
    int leftMax = 0;
    int res = (int)1e9;
    for(int i=idx;i<jobDifficulty.length-d+1;i++){
        leftMax = Math.max(leftMax,jobDifficulty[i]);
        int rightMax = dfs(dp,jobDifficulty,d-1,i+1);
        res = Math.min(res,leftMax+rightMax);
    }
    return dp[d][idx] = res;
}
}

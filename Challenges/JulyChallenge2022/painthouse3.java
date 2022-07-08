public class painthouse3 {
        // 1473. Paint House III
//     tc O() sc O()
//     ok, but need better understanding
private int[][][] dp;
private int max = (int)1e9;

public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//        house id, remaining target, last color
    dp = new int[m+1][target+1][n+1];
    
    int ans = dfs3d(houses,cost,0,target,0,n);
    
    return ans == max?-1:ans;
}

private int dfs3d(int[] houses,int[][] cost, int i,int target,int lastcolor,int n){
//         target requirements doesn't matched.
    if(target<0){
        return max;
    }
//         reached the length so it is a valid one or not according to the target
    if(i >= houses.length){
        return target == 0?target:max;
    }
//         already computed , then memoise
    if(dp[i][target][lastcolor]!=0){
        return dp[i][target][lastcolor];
    }
//         if the house is already painted.
    if(houses[i]!=0){
        if(houses[i]!=lastcolor){
            target = target-1;
        }
        return dfs3d(houses,cost,i+1,target,houses[i],n);
    }
    
//         If the house is not painted so discover all opportunities by assigning different colors here and getting the ans where minimum cost is there meeting the target.
    int ans = max;
    for(int color=1;color<=n;color++){
        ans = Math.min(ans, cost[i][color-1] + dfs3d(houses,cost,i+1,target - ((lastcolor!=color)?1:0),color,n));
    }
    return dp[i][target][lastcolor] = ans;
    
    
}
}

import java.util.List;
import java.util.Arrays;

public class Triangle {
    
    // 120. Triangle
//     tc O(row*col) sc O(row*col)
//      optimized will be done later 
//    DFS will be applied from top to bottom where we ask for the minimum value 
    // minimum = recMin(triangle,dp,row+1,col) and recMin(triangle,dp,row+1,col+1)
//     return triangle.get(row).get(col) + minimum in the dp[row][col]
//     Current node will become correct and that node will be returned to its parent and so in the recursion.
//     Memoisation also to reduce time.
public int minimumTotal(List<List<Integer>> triangle) {
    int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
    for(int[] row:dp){
        Arrays.fill(row,(int)1e9);
    }
    return recMin(triangle,dp,0,0);
}
private int recMin(List<List<Integer>> triangle,int[][] dp,int row,int col){
    if(row == dp.length){
        return 0;
    }
    
    if(dp[row][col]!=(int)1e9){
        return dp[row][col];
    }
    
    int minimum = Math.min(recMin(triangle,dp,row+1,col),recMin(triangle,dp,row+1,col+1));
    
    dp[row][col] = triangle.get(row).get(col) + minimum;
    
    return dp[row][col];
    
}
}

public class whereBallFall{
    
       // 1706. Where Will the Ball Fall
// tc O(n*m) sc O(1)
//  Brute is that traverse for each ball column wise from where the ball drops
//     Then traverse in that row wise for getting down each step, there we find the next position as 
//     current position + the current grid value 
//     if it goes at the boundaries or blockage case comes where grid at cpos != grid at npos 
//     then set its value as -1 and break for that ball
//     Otherwise if the blockage doesn't come cpos will hold the answer where ball will fall.
public int[] findBall(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int[] ans = new int[m];
    for(int j=0;j<m;j++){
        int cpos = j;
        int npos = -1;
        for(int i=0;i<n;i++){
            npos = cpos + grid[i][cpos];
            
            if(npos<0 || npos==m || grid[i][cpos]!=grid[i][npos]){
                cpos = -1;
                break;
            }
            cpos = npos;
        }
        ans[j] = cpos; 
    }
    return ans;
}
}
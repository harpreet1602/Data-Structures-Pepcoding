public class GoldMine {
    
//     1219. Path with Maximum Gold
//     tc O() sc O(n*m) for visited array.
//     Recursion and backtracking has been applied to get the maximum gold.
//     I have taken a global variable as maxGold which will alwqays get updated with whatever maximum gold comes in any possibility at every jump.
//     Call for the recursion from every non zero element as it contains possibilities
    
private int maxGold = 0;
public int getMaximumGold(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    boolean[][] vis = new boolean[n][m];
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]!=0){
                recGetGold(i,j,grid,vis,dirs,grid[i][j]);
            }
        }
    }
    return maxGold;
}
//     In recursion we will have dirs array to go in four directions from current sr,sc
//     with the help of visited array, we will traverse the path effectively and consider one cell for one time in the current possibility.
//     Call only for next valid cell position and add gold of it along with the existing gold.
//     Mark visited and unvisited for the sr and sc cell.

private void recGetGold(int sr,int sc,int[][] grid,boolean[][] vis,int[][] dirs, int gold){
    vis[sr][sc] = true;
    maxGold = Math.max(maxGold,gold);
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];

        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] !=0 && vis[r][c] == false){
          recGetGold(r,c,grid,vis,dirs,gold+grid[r][c]);  
        }
    }
    vis[sr][sc] = false;
}
}

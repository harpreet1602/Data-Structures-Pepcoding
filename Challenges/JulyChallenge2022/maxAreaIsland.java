public class maxAreaIsland{
    
    // 695. Max Area of Island
//     tc O(n*m) sc O(1)
//     So just simple DFS approach is applied keeping in mind the visited thing by marking it as -1 on visiting so that infinite loop does not get created.
//     Rest is basic that go in all four directions once we find 1 and then explore the whole path and return the maximum area.
public int maxAreaOfIsland(int[][] grid) {
    int n = grid.length, m=grid[0].length,maxArea=0;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j] == 1){
                maxArea = Math.max(maxArea,getMaxArea(i,j,grid,dirs));
            }
        }
    }
    return maxArea;
}
private int getMaxArea(int sr,int sc,int[][] grid,int[][] dirs){
    grid[sr][sc] = -1;
    int totalArea = 0;
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];
        if(r>=0 && r<grid.length && c>=0 &&c<grid[0].length && grid[r][c] == 1){
            totalArea += getMaxArea(r,c,grid,dirs);
        }
    }
    return 1+totalArea;
}
}
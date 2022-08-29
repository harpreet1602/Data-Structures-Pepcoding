public class noIsland{
    
    // 200. Number of Islands
//     tc O(n*m*something) sc O(1)  i think
//     graph dfs
//     just count how many times we are calling the dfs method which makes one island all zero in one iteration.
public int numIslands(char[][] grid) {
    int n = grid.length, m = grid[0].length, count = 0;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j] == '1'){
                count++;
                exploreIsland(grid,i,j,dirs);
            }
        }
    }
    return count;
}
private void exploreIsland(char[][] grid,int sr,int sc,int[][] dirs){
    grid[sr][sc] = '0';
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];
        
        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == '1'){
            exploreIsland(grid,r,c,dirs);
        }
    }
}
}
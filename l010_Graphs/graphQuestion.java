public class graphQuestion {

    //200. Number of Islands
    public void dfs(char[][] grid,int[][] dir,int sr,int sc){
        grid[sr][sc]='0';
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1')
            {
                dfs(grid,dir,r,c);
            }
        }
    }
    
    
    public int numIslands(char[][] grid) {
        int componentcount=0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dir={{1,0},{-1,0},{0,-1},{0,1}};
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,dir,i,j);
                    componentcount++;
                }
            }
        }
        return componentcount;
        
    } 

    //695. Max Area of Island
    public int dfs1(int[][] grid,int[][] dir,int sr,int sc){
        grid[sr][sc]=0;
        int size=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1)
            {
                size+=dfs1(grid,dir,r,c);
            }
        }
        return size+1;
    }
    
    
    public int maxAreaOfIsland(int[][] grid){
        int componentcount=0;
        int m=grid.length;
        int n=grid[0].length;
        int size=0;
        int[][] dir={{1,0},{-1,0},{0,-1},{0,1}};
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    int s=dfs1(grid,dir,i,j);
                    componentcount++;
                    size=Math.max(size,s);
                }
            }
        }
        return size;
        
    } 
    

}

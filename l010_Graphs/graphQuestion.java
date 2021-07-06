import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
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
    
    //1 for land and 0 for water

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
    
    //1 for land and 0 for water

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
    //leetcode 785. Is Graph Bipartite?

    public boolean isGraphBipartite(int[][] graph,int src,int[] vis)
    {
        int color=0;
        LinkedList<Integer> que=new LinkedList<>();
        boolean isBipartite=true,cycle=false;
        que.add(src);
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rvtx=que.removeFirst();
                if(vis[rvtx]!=-1)   //cycle present
                {
                    if(vis[rvtx]!=color)  //not bipartite graph
                    {
                        isBipartite=false;
                        break;
                    }
                    else      //bipartite graph but as there is a cycle so continue 
                    {
                        continue;
                    }
                }
                
                vis[rvtx]=color;
                for(int nbr:graph[rvtx])
                {
                    if(vis[nbr]==-1)
                    {
                       que.addLast(nbr); 
                    }
                }
            }
            color=(color+1)%2;
        }
        return isBipartite;
    }
    public boolean isBipartite(int[][] graph) {
        boolean res=true;
        int[] vis=new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<graph.length;i++)
        {
            if(vis[i]==-1)
                res=res&&isGraphBipartite(graph,i,vis);
        }
        return res;
    }

}

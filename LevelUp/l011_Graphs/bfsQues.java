import java.util.Arrays;
import java.util.LinkedList;


public class bfsQues {
    // 994. Rotting Oranges
// tc O(n*m) sc O(1)
// count all the freshapples and put the rotten apples in a queue and apply bfs 
// for whatever cell that gets removed traverse in all four directions
// wherever there is fresh apple then decrement the count and make it rotten
// and add it into the queue
    
    public int orangesRotting(int[][] grid) {
        LinkedList<Integer> que = new LinkedList<>();
        int freshApples = 0,n=grid.length,m=grid[0].length,level=0;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    freshApples++;
                }
                else if(grid[i][j] == 2){
                    que.addLast(i*m+j);
                }
            }
        }
        
        if(freshApples == 0){
            return 0;
        }        
        while(que.size()!=0)
        {
            int size =  que.size();
            while(size-->0){
                int index = que.removeFirst();
                int row = index/m;
                int col = index%m;
                for(int[] d:dir){
                    int r = row + d[0];
                    int c = col + d[1];
                    
                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c] == 1){
                        freshApples--;
                        grid[r][c] = 2;
                        que.addLast(r*m+c);
                    }
                    
                    if(freshApples == 0){
                        return level+1;
                    }
                }
                
            }
            level++;
        }
        return -1;
    }





//     785. Is Graph Bipartite?
//     tc O((n)^2) sc O(n)
//     assign the two colors alternatively on each level and apply bfs 
//     if there exists a ele which get two colors that means it is odd cycle
//     so in a odd cycle it cannot be a bipartite graph
//     in even cycle and no cycle it will be a bipartite graph.
    public boolean bfsBipartite(int src, int[][] graph, int[] colors){
        int c = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int u = que.removeFirst();
                
                if(colors[u]!=-1){
                    if(colors[u]!=c) return false;
                    
                    continue;
                }
                
                colors[u] = c;
                
                for(int v:graph[u]){
                    if(colors[v] == -1){
                        que.addLast(v);
                    }
                }
            }
            c = (c + 1)%2;
        }
        return true;
    }


    public boolean isBipartite(int[][] graph) {
        int n = graph.length, m = graph[0].length;
        int[] colors = new int[n];
        Arrays.fill(colors,-1);
        for(int i=0;i<n;i++){
            if(colors[i] == -1){
                boolean isBipartite = bfsBipartite(i,graph,colors);
                if(!isBipartite) return false;
            }
        }
        return true;
    }

    
    // 1020. Number of Enclaves
//     tc O(n*m*n) sc O(n)
//     boundary to interior
//     make the boundary 1's area as 0 by bfs and then count the remaning 1's
//     area in the matrix
    
    public void bfsEnclave(int i,int j,int[][] grid,int n, int m, int[][] dir){
        LinkedList<Integer> que = new LinkedList<>();
//         mapping of 2d into 1d
        grid[i][j] = 0;
        
        que.addLast(i*m+j);
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int ind = que.removeFirst();
                int row = ind/m;
                int col = ind%m;
                for(int[] d:dir){
                    int r = row + d[0];
                    int c = col + d[1];
                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                    grid[r][c] = 0;
                    que.addLast(r*m+c);
                    }
                }
            }
        }
    }
    public int numEnclaves1(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j == m-1){
                    if(grid[i][j] == 1)
                    bfsEnclave(i,j,grid,n,m,dir);
                }
            }
        }
        int area = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                area += grid[i][j];
            }
        }
        return area;
    }


    
//     interior to boundary 
//     so here whichever has 1 call their bfs and then if the area goes to
//     boundary then it will contribute 0 if it does not then its area will
//     be returned.
//     tc O( n*m*n) sc O(n)
    public int bfsNumEnclave(int i, int j, int[][] grid,int n, int m,int[][] dir){
         LinkedList<Integer> que = new LinkedList<>();
//         mapping of 2d into 1d
        grid[i][j] = 0;
        boolean boundary = false;
        que.addLast(i*m+j);
        int count = 1;
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int ind = que.removeFirst();
                int row = ind/m;
                int col = ind%m;
                for(int[] d:dir){
                    int r = row + d[0];
                    int c = col + d[1];
                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                        if(r == 0 || c == 0 || r == n-1 || c == m-1) boundary = true;
                        grid[r][c] = 0;
                        count++;
                        que.addLast(r*m+c);
                    }
                }
            }
        }
        if(boundary || i == 0 || j == 0 || i == n-1 || j == m-1){
            return 0;
        }
        return count;
    
    }
    
    public int numEnclaves(int[][] grid) {
         int n = grid.length, m = grid[0].length, area =0;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    area += bfsNumEnclave(i,j,grid,n,m,dir);
                }
            }
        }
        return area;
      
    }



}

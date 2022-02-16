import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;


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

    
//     542. 01 Matrix
//     are you going from boundary to interior or interior to boundary
//     so always think that we need to go from where to where
//     as in this ques we can't go from one to zero as we can lost the position 
//     of 1. So we will go from 0 to 1 and we will come to 1 with the minimum
//     distance.
//     tc O(n*m) sc O(n*m)
//     Have a visited array as well and mark while inserting for better
//     efficiency here.
    
    
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<Integer> que = new LinkedList<>();
        int n = mat.length, m = mat[0].length, level = 0;
        boolean[][] vis = new boolean[n][m];
        int[][] dirS = {{-1,0},{0,-1},{1,0},{0,1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    que.addLast(i*m+j);
                    vis[i][j] = true;
                }
            }
        }
        
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int idx = que.removeFirst();
                
                int row = idx/m;
                int col = idx%m;
                for(int[] dir:dirS){
                    int r = row + dir[0];
                    int c = col + dir[1];
                    
                    if(r>=0 && c>=0 && r<n && c<m && !vis[r][c]){
                        mat[r][c] = level+1;
                        vis[r][c] = true;
                        que.addLast(r*m+c);
                    }
                }
                
            }
            level++;
        }
        return mat;
    }

// missing two ques 28 jan
    


    // 329. Longest Increasing Path in a Matrix
//     tc O(n*m) sc O(n*m)
//     level of the bfs = length of the longest path
//     according to the increasing condition we need to apply the bfs
//     so here we are applying topological sort using bfs where we use indegree
//     whose indegree will be 0 from there we will start adding in the queue
//    because they are one of the smallest elements present to start the path from
//     then keep on continuing the bfs and decrease the indegree then the ele
//     gets added in queue 
public int longestIncreasingPath(int[][] matrix) {
    int level = 0, n = matrix.length, m = matrix[0].length;
    int[][] indegree = new int[n][m];   
    LinkedList<Integer> que = new LinkedList<>();
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            for(int[] dir:dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(r>=0 && c>=0 && r<n && c<m && matrix[r][c]>matrix[i][j]){
                    indegree[r][c]++;
                }
            }
        }
    }
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(indegree[i][j] == 0){
                que.addLast(i*m+j);
            }
        }
    }
    
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            int idx = que.removeFirst();
            int row = idx/m;
            int col = idx%m;
            for(int[] dir:dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                if(r>=0 && c>=0 && r<n && c<m && matrix[r][c]>matrix[row][col]){
                    indegree[r][c]--;
                    if(indegree[r][c] == 0){
                        que.addLast(r*m+c);
                    }
                }
            }
        }
        level++;
    }
    return level;
    
}

    
    //  https://www.lintcode.com/problem/787/
    // 787 · The Maze
    // tc O(n) sc O(n)
    // Apply bfs and consider the constraint of the ball that will stop only at the cell
    // before the wall and at this point we will get a chance to ask for the answer from all 
    // the four directions. 
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int n = maze.length, m =maze[0].length;
        boolean[][] vis = new boolean[n][m];
        LinkedList<Integer> que = new LinkedList();
        que.addLast(start[0]*m+start[1]);
        vis[start[0]][start[1]] = true;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        while(que.size()!=0){
            int rind = que.removeFirst();
            int row = rind/m;
            int col = rind%m;
            for(int[] dir:dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                while(r>=0 && c>=0 && r<n && c<m && maze[r][c]!=1){
                    r += dir[0];
                    c += dir[1];
                    // go in the same direction until you find a wall. 
                }
                // moving back one step at the position from where we can go to four directions

                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1]){
                    return true;
                }
                if(vis[r][c]) continue;

                vis[r][c] = true;
                que.addLast(r*m+c);
            }
        }
        return false;

    }

 
    //  https://www.lintcode.com/problem/788/
    // 788 · The Maze II
    // tc O(n) sc O(n)
    // Priority queue with BFS is dijkstra.
    // I will be having a lot of solutions for going to the destination but by using 
    // prioirty queue I will ensure that the smallest distance from source to destination
    // comes out first and when it will come out we will return the answer.
    // When I will come to the destination with indexes coming directly from PriorityQueue
    // then I have explored all the paths and smallest is the current one so return it
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        // dis,vertex
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        
        int n = maze.length,m=maze[0].length;
        pq.add(new int[]{0,start[0]*m+start[1]});
        int[][] vis = new int[n][m];
        for(int[] v:vis){
            Arrays.fill(v,(int)1e9);
        }
        vis[start[0]][start[1]] = 0;
        while(pq.size()!=0){
            int[] rarr = pq.remove();
            int dis = rarr[0];
            int row = rarr[1]/m;
            int col = rarr[1]%m;

            if(row==destination[0] && col == destination[1]) return dis;
            for(int[] dir:dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                int curr = 1;
                while(r>=0 && c>=0 &&r<n && c<m&& maze[r][c]!=1){
                    r += dir[0];
                    c += dir[1];
                    curr++;
                }
                // move back one step
                r -= dir[0];
                c -= dir[1];
                curr--;

                if(vis[r][c]<=dis+curr) continue;

                
                vis[r][c] = dis + curr;
                pq.add(new int[]{vis[r][c],(r*m+c)});
            }
        }
        return -1;
    }


    // https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/successful-marathon-0691ec04/
// done in a different file

    

    


}

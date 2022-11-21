package Matrix;

public class nearestExit {
    
    // 1926. Nearest Exit from Entrance in Maze
    // tc O(n*m) sc O(n*m)
    // BFS will be applied and accordingly when at the level, we reach boundary then we return the level
     
    public int nearestExit(char[][] maze, int[] entrance) {
        LinkedList<int[]> que = new LinkedList<>();
        int n = maze.length, m = maze[0].length;
        boolean[][] vis = new boolean[n][m];
        int level = 1;
        que.addLast(entrance);
        vis[entrance[0]][entrance[1]] = true;
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int[] rpt = que.removeFirst();
                int sr = rpt[0];
                int sc = rpt[1];
                
                for(int[] dir:dirs){
                    int r = sr + dir[0];
                    int c = sc + dir[1];

                    if(r>=0 && c>=0 && r<n && c<m && maze[r][c]!='+' && vis[r][c] == false){
                        vis[r][c] = true;  
                        if(r == 0 || r == n-1 || c == 0 || c == m-1 ){
                            return level;
                        }     
                        que.addLast(new int[]{r,c});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

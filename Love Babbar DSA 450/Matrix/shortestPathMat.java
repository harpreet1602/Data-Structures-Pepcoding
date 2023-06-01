public class shortestPathMat {
    class Solution {
        // 1091. Shortest Path in Binary Matrix
    // tc O(n) sc O(n)
    //     Use BFS to find the shortest path normally and level + 1 gives the result
    //     direction array of 8 size will be created for covering all 8 directions.
    //     that makes it a simple question
        private class Pair{
            int x;
            int y;
            
            public Pair(int x,int y){
                this.x = x;
                this.y = y;
            }
        }
        public int shortestPathBinaryMatrix(int[][] grid) {
            LinkedList<Pair> que = new LinkedList<>();
            int n = grid.length, level = 0;
            
            if(grid[0][0]==1 || grid[n-1][n-1]==1){
                return -1;
            }
            int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};
            
            que.addLast(new Pair(0,0));
            grid[0][0] = 1;
            
            while(que.size()!=0){
                int size = que.size();
                while(size-->0){
                    Pair rpair = que.removeFirst();
                    if(rpair.x == n-1 && rpair.y == n-1){
                        return level+1;
                    }
                    for(int[] dir:dirs){
                        int r = rpair.x + dir[0];
                        int c = rpair.y + dir[1];
                        
                        if(r>=0 && c>=0 && r<n && c<n && grid[r][c] == 0){
                            que.addLast(new Pair(r,c));
                            grid[r][c] = 1;
                        }
                    }
                }
                level++;
            }
            return -1;
        }
    }
}

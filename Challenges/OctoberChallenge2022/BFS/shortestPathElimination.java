public class shortestPathElimination {
        // 1293. Shortest Path in a Grid with Obstacles Elimination
//     tc O(n*m) sc O(n*m)
//     We are not applying DFS here because if the obstacle will be there in the case where
//     obstacle count is already gone then the deep traversal will be a time waste 
//     So that is why we will apply BFS here 
//     We will only add valid entries into the queue, storing it as (row,col,obstacleCount till now)
//     We will be having a visited matrix and obstacleCount matrix for the row,col cell status
//     vis => whether the cell is visited or not in the past & obstacleCount => with what 
//     obstacleCount till now has we reached here.
//     At any point if we reached the end point return the level of the BFS as it is representing the number of steps till now 
//     Now going in all four directions and seeing if the cell is not visited and the obstacleCount till now <= k then add the cell in the queue.
//     One more case, if  it is already visited but with lesser obstacleCount then also add in the queue.
    
public int shortestPath(int[][] grid, int k) {
    int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
    LinkedList<int[]> que =  new LinkedList<>();
    int n = grid.length, m = grid[0].length,level=0;
    int[][] obstacleCount = new int[n][m];
    boolean[][] vis = new boolean[n][m];
    obstacleCount[0][0] = grid[0][0];
    que.addLast(new int[]{0,0,obstacleCount[0][0]});
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            int[] head = que.removeFirst();
            if(head[0] == n-1 && head[1] == m-1){
                return level;
            }
            int currObstacleCount = head[2];
            for(int[] dir:dirs){
                int r = head[0] + dir[0];
                int c = head[1] + dir[1];
                if(r>=0 && c>=0 && r<n && c<m){
                    int oldObstacleCount = obstacleCount[r][c];
                    int newObstacleCount = currObstacleCount + grid[r][c];
                    
                    if(!vis[r][c] && newObstacleCount<=k){
                        que.addLast(new int[]{r,c,newObstacleCount});
                        obstacleCount[r][c] = newObstacleCount;
                        vis[r][c] = true;
                    }
                    if(newObstacleCount<oldObstacleCount && newObstacleCount<=k){
                        que.addLast(new int[]{r,c,newObstacleCount});
                        obstacleCount[r][c] = newObstacleCount;
                    }
                    
                }
            }
        }
        level++;
    }
    return -1;
}
}

import java.util.LinkedList;

public class shortestPathMatrix {
    
    // 1091. Shortest Path in Binary Matrix
//     tc O(n^2) sc O(n^2)
//     Typical  BFS is applied to find the shortest path where we will traverse from one cell
//     in all the 8 directions till the ending cell. We will be marking visited to the 
//     node which is added into the queue. So that infinite loop can be avoided in case 
//     when there is no path. 
//     Edge Case:- When 0,0 is 1 or n-1,n-1 is 1 then return -1.
//     Path discovery is getting done. When we removing the element, level+1 shows the 
//     shortest distance of it from starting index. So this will help when we will
//     reach ending index.
private class Pair{
    private int x;
    private int y;
    
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1},
                    {-1,-1},{1,-1},{1,1},{-1,1}};
    if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
        return -1;
    }
    int level=0;
    LinkedList<Pair> que = new LinkedList<>();
    que.addLast(new Pair(0,0));
    grid[0][0] = 2;
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            Pair rpair = que.removeFirst();
            int sr = rpair.x;
            int sc = rpair.y;
            if(sr == n-1 && sc == n -1){
                return level+1;
            }
            
            // grid[sr][sc] = 2;
            
            for(int[] dir:dirs){
                int r = sr+dir[0];
                int c = sc + dir[1];
                
                if(r>=0 && c>=0 && r<n && c<n && grid[r][c]==0){
                    que.addLast(new Pair(r,c));
                    grid[r][c] = 2;
                }
            }
        }
        level++;
    }
    return -1;
    
}
}

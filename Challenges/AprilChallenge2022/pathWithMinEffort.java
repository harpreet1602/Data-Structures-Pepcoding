import java.util.PriorityQueue;
import java.util.Arrays;
public class pathWithMinEffort {
    
    // 1631. Path With Minimum Effort
//     tc O(n*mlog(n*m)) for total ele priorityqueue sc O(n*m) for efforts array
//     and priorityqueue
//     Dijkstra's Algorithm
//     BFS with priorityQueue
//     Apply the traversal main logic for deciding the nextEffort is maximum of the previous effort or heights difference from where it is coming
//     and after that if it is less than the original efforts at that point then 
//     only change the efforts at that point and add in pq
//     This also does the work of visited array 
    
public int minimumEffortPath(int[][] heights) {
    int n = heights.length, m = heights[0].length;
    int[][] efforts = new int[n][m];
    for(int[] effort:efforts){
        Arrays.fill(effort,(int)1e9);
    }
//         effort, x, y
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
       return a[0]-b[0]; 
    });
    
    efforts[0][0] = 0;
    pq.add(new int[]{0,0,0});
    
    int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
    while(pq.size()!=0){
        int[] rhead = pq.remove();
        int x = rhead[1], y = rhead[2], currEffort = rhead[0];
        if(x==n-1 && y == m-1){
            return efforts[x][y];    
        }
        for(int[] dir:dirs){
            int r = x + dir[0];
            int c = y + dir[1];
            
            if(r>=0 && c>=0 && r<n && c<m){
                int nextEffort = Math.max(currEffort,Math.abs(heights[r][c]-heights[x][y]));
                
                if(nextEffort<efforts[r][c]){
                    efforts[r][c] = nextEffort;
                    pq.add(new int[]{nextEffort,r,c});
                }
            }
        }
    }
    return 0;
    
}
}

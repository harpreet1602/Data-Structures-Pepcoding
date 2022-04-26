import java.util.PriorityQueue;
import java.util.HashSet;

public class minCostPoints {
    
//     1584. Min Cost to Connect All Points
//     Prim's algorithm is applied here.
//     tc O(n^2logn) sc O(n)
//      prim's algorithm is similar to dikjtra's algorithm. 
//    
public int distance(int[][] points,int i,int j){
    return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
}
public int minCostConnectPoints(int[][] points) {
//  Minheap and will return according to the shortest distance
    //         (si,ei,distance)   
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
        return a[2]-b[2];
    });
//         for keeping the visited end point track
    HashSet<Integer> set = new HashSet<>();
//         These starting and ending points are indexes in the points 2d array
//         
    pq.add(new int[]{0,0,0});
    int num = points.length, totalCost = 0;
//    If pq is empty then leave or set is containing all the ending indexes successfully then this means minimum spanning tree is contructed here.
    while(pq.size()!=0 && set.size()<num){
        int[] curr = pq.remove();
        int endId = curr[1];
        int cost = curr[2];
//             If the ending index is present in the set, leave the current iteration
        if(set.contains(endId)) continue;
        set.add(endId);
        totalCost += cost;
//          check for all the unvisited neighours from the ending index
//             Add them with the manhatten distance in the priority queue 
        for(int i=0;i<num;i++){
            if(!set.contains(i)) {
                pq.add(new int[]{endId,i,distance(points,endId,i)});
            }
        }
    }
    return totalCost;
    
}
}

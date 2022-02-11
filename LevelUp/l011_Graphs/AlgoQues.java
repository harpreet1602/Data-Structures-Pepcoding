import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;



public class AlgoQues {
    
    // 743. Network Delay Time
// apply dijkstra algorithm for the shortest time from the source till all nodes/
// If at any index dis the values hasn't changed that means we haven't reached
//   that node so return -1 otherwise the maxmimum time taken to reach all nodes
//    can  be returned. 
    //     tc : O(n + elogn) sc O(n+e)
//    read editorial's approach 3 time and space analysis 
public int dijkstra(ArrayList<int[]>[] graph, int n, int src){
    //         src,wsf       (int[])
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                return a[1]-b[1];
            });
    
            int[] dis = new int[n];
            Arrays.fill(dis,(int)1e9);
    // src, wsf
            pq.add(new int[]{src,0});
            dis[src] = 0;
            while(pq.size()!=0){
                int[] rp = pq.remove();
    
                int rpsrc = rp[0];
                int rpwsf = rp[1];
                if(dis[rpsrc] < rpwsf) continue;
    
                for(int[] nbr:graph[rpsrc]){
                    int nbrv = nbr[0];
                    int nbrw = nbr[1];
                    if(nbrw + rpwsf < dis[nbrv]){
                        dis[nbrv] = nbrw + rpwsf;
                        pq.add(new int[]{nbrv,dis[nbrv]});
                    }
                }
            }
            
            int ans = 0;
            for(int i=0;i<n;i++){
                if(dis[i] == (int)1e9) return -1;
                ans = Math.max(ans,dis[i]);
            }
            return ans;
        }
        public int networkDelayTime(int[][] times, int n, int k) {
            ArrayList<int[]>[] graph = new ArrayList[n];
    //        u -> v,w  (structure of graph)
            for(int i=0;i<n;i++){
                graph[i] = new ArrayList<>();
            }
            
            
            for(int[] time:times){
                int u = time[0]-1;
                int v = time[1]-1;
                int w = time[2];
                
                graph[u].add(new int[]{v,w});
            }
            
            return dijkstra(graph,n,k-1);
        }
    

        
}

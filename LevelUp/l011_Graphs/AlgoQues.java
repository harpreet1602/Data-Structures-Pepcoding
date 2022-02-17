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
    

        
//     787. Cheapest Flights Within K Stops
//     O(nlogn) sc O(nlogk)
// Using Dijkstra algorithm, it will give TLE
// Add src,wsf,steps in the priority queue and apply bfs i.e. dijkstra algo
// make the graph with the flights and the conditions which will be checked in the bfs is
//     if steps>k+1 then continue as it cannot be answer as the stops must be atmost k
//     if our u has reached the destination then return the wsf of src to dst
//     and while adding neightbours, add all the neighbours as the coming out of thos e
//     neighbours are controlled in the priority queue as the comparison is 
//    on the basis of wsf but when wsf is also equal then on the basis of steps 
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k)         {
        //         src,wsf,steps
                PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                   if(a[1] == b[1]) 
                       return a[2]-b[2];
                    return a[1]-b[1];
                });
                
                ArrayList<int[]>[] graph = new ArrayList[n];
                for(int i=0;i<n;i++){
                    graph[i] = new ArrayList<>();
                }
                
                for(int[] flight:flights){
                    int u = flight[0];
                    int v = flight[1];
                    int w = flight[2];
                    
                    graph[u].add(new int[]{v,w});
                }
                
                pq.add(new int[]{src,0,0});
                
                while(pq.size()!=0){
                    int[] rArr = pq.remove();
                    int u = rArr[0];
                    int wsf = rArr[1];
                    int steps = rArr[2];
                    
                    if(steps>k+1) continue;
                    
                    if(u==dst){
                        return wsf;
                    }
                    for(int[] nbr:graph[u]){
        //                 v,w
                        int v = nbr[0];
                        int w = nbr[1];
                        
                        pq.add(new int[]{v,wsf+w,steps+1});
                    }
                    
                }
                return -1;
            }
            
            

// Bellman ford algorithm
 public int bellmanFord(int n, int[][] edges, int src, int dst, int k){
                int[] dis = new int[n];
                Arrays.fill(dis,(int)1e9);
                dis[src] = 0;
                boolean negativeCycle = false;
                
                for(int i=1;i<=n;i++){
                    int[] ndis = new int[n];
                    
                    for(int j=0;j<n;j++){
                        ndis[j] = dis[j];
                    }
                    
                    boolean isUpdate = false;
                    for(int[] edge:edges){
                        int u = edge[0];
                        int v = edge[1];
                        int w = edge[2];
                        
                        if(dis[u] + w < ndis[v]){
                            ndis[v] = dis[u] + w;
                            isUpdate = true;
                        }
                        
                    }
                    
                    if(!isUpdate){
                            break;
                    }
                    
                    if(i == k+1 && isUpdate){
                        negativeCycle = true;
                    }
                    dis = ndis;
                }
                return dis[dst] == (int)1e9?-1:dis[dst];
                
            }




        //     Optimised => Bellman Ford algo
        //     tc O(k*flights.length) sc O(n)
        //  Just run the bellman ford for 1 to k+1 edges as we have the constraint to stop on atmost k
        //     points. With the help of 2 arrays, we can proceed further
        //     Do a dry run to get more insight.
            public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
                int[] dis = new int[n];
                Arrays.fill(dis,(int)1e9);
                dis[src] = 0;
                boolean negativeCycle = false;
                
                for(int i=1;i<=k+1;i++){
                    int[] ndis = new int[n];
                    
                    for(int j=0;j<n;j++){
                        ndis[j] = dis[j];
                    }
                    
                    boolean isUpdate = false;
                    for(int[] edge:flights){
                        int u = edge[0];
                        int v = edge[1];
                        int w = edge[2];
                        
                        if(dis[u] + w < ndis[v]){
                            ndis[v] = dis[u] + w;
                            isUpdate = true;
                        }
                        
                    }
                    
                    if(!isUpdate){
                            break;
                    }
                    
                    if(i == k+1 && isUpdate){
                        negativeCycle = true;
                    }
                    dis = ndis;
                }
                return dis[dst] == (int)1e9?-1:dis[dst];
                
            }
        
            
}

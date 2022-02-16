import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;


public class dijkstraPrims {
        
    public class Edge{
        int v;
        int w;
        
        Edge(int v,int w){
            this.v = v;
            this.w = w;
        }

        // public toString(){
        //     return this.v+", "+this.w;
        // }
    }

    public void addEdge(int u, int v, int w, ArrayList<Edge>[] graph){
        graph[u].add(new Edge(v,w));
    }

    public class pair{
        int src = 0;
        int par = 0;
        int w = 0;
        int wsf = 0;

        pair(int src, int wsf){
            this.src = src;
            this.wsf = wsf;
        }
        
        pair(int src,int par,int w,int wsf){
            this.src = src;
            this.par = par;
            this.w = w;
            this.wsf = wsf;
        }
    }

    // Dijkstra algroithm that is used to find the single source shortest path.

    // we are marking while deleting.
    public void dijkstra(ArrayList<Edge>[] graph, int src){
        int v = graph.length;

        ArrayList<Edge>[] myGraph = new ArrayList[v];

        for(int i=0;i<v;i++){
            myGraph[i] = new ArrayList<>();
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            return a.wsf-b.wsf;
        });

        boolean[] vis = new boolean[v];

        pq.add(new pair(src,-1,0,0));

        while(pq.size()!=0){
            pair rp = pq.remove();

            if(vis[rp.src]) continue;

            if(rp.par!=-1){
                addEdge(rp.src, rp.par, rp.w, myGraph);
            }

            vis[rp.src] = true;

            for(Edge nbr:graph[rp.src]){
                if(!vis[rp.src]){
                    pq.add(new pair(nbr.v,rp.src,nbr.w,rp.wsf+nbr.w));
                }
            }
        }
    }

     // earlier we were using vis array to don't get back to the same vertex as well as we were using it to 
    //  allow us to not add the edges with maximum path weight instead we were only considering the minimum path
    //  weights everywhere.


    // now we are using the distance array to serve the same purpose 
    // we are marking while adding
    public void dijkstra1(ArrayList<Edge>[] graph, int src){
        int v = graph.length;

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            return a.wsf-b.wsf;
        });

        int[] dis = new int[v];
        Arrays.fill(dis,(int)1e9);
        dis[src] = 0;
// src, wsf
        pq.add(new pair(src,0));

        while(pq.size()!=0){
            pair rp = pq.remove();

            if(dis[rp.src] < rp.wsf) continue;

            for(Edge nbr:graph[rp.src]){
                if(nbr.w + rp.wsf < dis[nbr.v]){
                    dis[nbr.v] = nbr.w + rp.wsf;
                    pq.add(new pair(nbr.v,dis[nbr.v]));
                }
            }
        }
    }





    // prims algorithm=> it is used to find the MST, because of the minmum weight edges sorting we will get MST.    
    // same like dijkstra but the sorting of Priority queue is on the basis of weight.
    // so everytime the minimum weight edge comes out.
    
    public void prims(ArrayList<Edge>[] graph, int src){
        int v = graph.length;

        ArrayList<Edge>[] myGraph = new ArrayList[v];

        for(int i=0;i<v;i++){
            myGraph[i] = new ArrayList<>();
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            return a.w-b.w;
        });

        boolean[] vis = new boolean[v];

        pq.add(new pair(src,-1,0,0));

        while(pq.size()!=0){
            pair rp = pq.remove();

            if(vis[rp.src]) continue;

            if(rp.par!=-1){
                addEdge(rp.src, rp.par, rp.w, myGraph);
            }

            vis[rp.src] = true;

            for(Edge nbr:graph[rp.src]){
                if(!vis[rp.src]){
                    pq.add(new pair(nbr.v,rp.src,nbr.w,rp.wsf+nbr.w));
                }
            }
        }
    }


    






}

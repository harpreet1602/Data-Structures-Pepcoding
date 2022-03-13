import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Scanner;

public class codingArea {
    
        
    public static class Edge{
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

    public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph){
        graph[u].add(new Edge(v,w));
    }

    public static class pair{
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

    public static int[] dijkstra1(ArrayList<Edge>[] graph, int src){
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
        return dis;
    }
    public static Scanner scn = new Scanner(System.in);

    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        int n = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=n;i++){

            addEdge(i, scn.nextInt(), 0, graph);
        }
        int src = scn.nextInt();
        int des = scn.nextInt();

        int[] dis = dijkstra1(graph,src);
        if(dis[des]!=(int)1e9)
        System.out.println(dis[des]);
        else 
        System.out.println(-1);

    }



}

package Love Babbar DSA 450.Graphs;

public class primsAlgo {
    
    // Minimum Spanning Tree
    // https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
    // tc O(ElogV) sc O(V^2)
    // Prim's algorithm
    // For all the edges like at 0 => neighbours of 0 we are applying log V operations of PriorityQueue
    // V is the number of Vertices.
    // Space => V^2 is that the array of list of pair => V*V
    // Make Priority queue of pair min heap on the basis of distance
    // So whicever node will come out that will be with shortest distance possible according to minimum spanning tree
    // so we will be tracking our sum with its distance.
    static class Pair{
        int node;
        int distance;
        
        public Pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	   
	    ArrayList<Pair>[] graph = new ArrayList[V];
	    boolean[] vis = new boolean[V];
	    int msum = 0;
	    for(int i=0;i<V;i++){
	        graph[i] = new ArrayList<>();
	    }
        	    
	    for(int[] edge:edges){
	        int u = edge[0];
	        int v = edge[1];
	        int w = edge[2];
	        graph[u].add(new Pair(v,w));
	        graph[v].add(new Pair(u,w));
	    }
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
	        return a.distance-b.distance;
	    });
	    pq.add(new Pair(0,0));
	    
	    while(pq.size()!=0)
	    {
	        Pair rpair = pq.remove();
	        
	        if(vis[rpair.node]) continue;
	        vis[rpair.node] = true;
	        msum += rpair.distance;
	        
	        for(Pair pair:graph[rpair.node]){
	            if(!vis[pair.node]){
	                pq.add(pair);
	            }
	        }
	    }
	    return msum;
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;


public class directedGraph {
    
    public static class Edge{
        int v;
        int w;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        public String toString(){
            return this.v + ", " + this.w;
        }
    }

    public static void addEdge(int u,int v,int w,ArrayList<Edge>[] graph){
        graph[u].add(new Edge(v,w));
    }
    public int findEdge(int u, int v, ArrayList<Edge>[] graph){
        for(int i=0;i<graph[u].size();i++){
            Edge e = graph[u].get(i);

            if(e.v == v){
                return i;
            }
        }
        return -1;
    }
    public void removeEdge(int u, int v, ArrayList<Edge>[] graph){
        int index = findEdge(u,v,graph);
        graph[u].remove(index);
    }

    public  void construct(int n){
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(0,1,2,graph);
        addEdge(1,3,4,graph);
        addEdge(1,2,3,graph);
        addEdge(3,4,5,graph);
        addEdge(2,4,7,graph);
        addEdge(4,9,8,graph);
        addEdge(4,10,10,graph);
        addEdge(9,10,8,graph);
        addEdge(4,6,11,graph);
        addEdge(6,7,3,graph);
        addEdge(5,7,3,graph);
        removeEdge(4,9,graph);
        removeEdge(4, 10, graph);
        removeEdge(2, 4, graph);
        removeEdge(4, 5, graph);
    }

    public static void display(ArrayList<Edge>[] graph){
        int n = graph.length;
        for(int i=0;i<n;i++){
            System.out.print(i+"-> ");
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                System.out.print("{ "+e.v+", "+e.w+" } ");
            }
            System.out.println();
        }
    }

    // topological sorting
    // in u,v => u will come first then v will come so it will be in order from left to right
    public void dfsTopological(int src, ArrayList<Edge>[] graph,boolean[] vis, List<Integer> ans){
        vis[src] = true;

        for(Edge nbr:graph[src]){
            if(!vis[nbr.v]){
                dfsTopological(nbr.v, graph, vis, ans);
            }
        }

        ans.add(src);
    }
    public void dfsTopologicalSort(ArrayList<Edge>[] graph){
        int n = graph.length;
        boolean[] vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfsTopological(i,graph,vis,ans);
            }
        }

        for(int i= ans.size()-1;i>=0;i--){
            System.out.print(ans.get(i)+" ");
        }

    }

    // BFS topological ordering

    List<Integer> bfsTopo(ArrayList<Edge>[] graph){
        int V = graph.length;
        int[] indegree = new int[V];
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            for(Edge e:graph[i]){
                indegree[e.v]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                que.addLast(i);
            }
        }

        while(que.size()!=0){
            int idx = que.removeFirst();
            list.add(idx);

            for(Edge e:graph[idx]){
                indegree[e.v]--;
                if(indegree[e.v] == 0){
                    que.addLast(e.v);
                }
            }
            
        }

        if(list.size()!=V){
            System.out.println("No Solution as cycle exists");
            return new ArrayList<>();
        }

        return list;
    }

    // level orderering bfs topological sort
    List<List<Integer>> bfsTopoLevel(ArrayList<Edge>[] graph){
        int V = graph.length;
        int[] indegree = new int[V];
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(Edge e:graph[i]){
                indegree[e.v]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                que.addLast(i);
            }
        }

        while(que.size()!=0){
            int size = que.size();
            List<Integer> small = new ArrayList<>();
            while(size-->0){
            int idx = que.removeFirst();
            small.add(idx);

            for(Edge e:graph[idx]){
                indegree[e.v]--;
                if(indegree[e.v] == 0){
                    que.addLast(e.v);
                }
            }
            }
            list.add(small);
        }

        return list;
    }

    // Kruskal's algorithm=======================================

    int[] par;

    public int findPar(int u){
        if(par[u]==u) return u;

        return par[u] = findPar(par[u]);
    }
    public ArrayList<Edge>[] kruskal(int[][] edges,int n)
    {
        ArrayList<Edge>[] mst= new ArrayList[n];
        par = new int[n];

        for(int i=0;i<n;i++){
            mst[i] = new ArrayList<>();
        }

        Arrays.sort(edges,(int[] a, int[] b)->{
            return a[2]-b[2];
        }); // sorting on the basis of weight of the edges

        for(int i=0;i<n;i++){
            par[i] = i;
        }

        for(int i=0;i<n;i++){
            int[] edge = edges[i];

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1!=p2){
                addEdge(u, v, w, mst);
                par[p2] = p1;
            }
        }
        return mst;
    }

    public void main(String[] args){
        construct(11);
    }
}

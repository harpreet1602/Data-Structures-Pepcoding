import java.util.ArrayList;

public class l001
{
    public static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt)
        {
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    public static void addEdge(ArrayList<Edge>[] graph,int u,int v,int w){
        graph[u].add(new Edge(u, v ,w));
        graph[v].add(new Edge(u, v ,w));       
    }
    public static void display(ArrayList<Edge>[] graph,int N)
    {
        for(int i=0;i<N;i++){
            System.out.print(i+" -> ");
            // for(int j=0;j<graph[i].size();i++)
            // {
            //     System.out.println("("+graph[i].get(j).nbr+" , "+graph[i].get(j).wt+")");
            // }
                //2nd way
             for(Edge e:graph[i]){
                    System.out.println("(" + e.nbr + "," + e.wt + ")");
             }
            System.out.println();
        }
    }
    public static int findIndex(ArrayList<Edge>[] graph,int u,int v)
    {
        ArrayList<Edge> list=graph[u];
        for(int i=0;i<list.size();i++)
        {
            Edge e=list.get(i);
            if(e.nbr==v)
            return i;
        }
        return -1;
    }
    public static void removeEdge(ArrayList<Edge>[] graph,int u,int v){
        int i1=findIndex(graph,u,v);
        int i2=findIndex(graph,v,u);

        graph[u].remove(i1);         //u sai i1 edge remove 
        graph[v].remove(i2);         //v sai i2 edge remove  
    }
    public static void removeVtx(ArrayList<Edge>[] graph,int u)
    {
        ArrayList<Edge> list = graph[u];
        for(int i=list.size()-1;i>=0;i--)
        {
            Edge e=list.get(i);
            removeEdge(graph,e.src,e.nbr);
        } 
    }
    //dfs
    //1.mark
    //2.visit all the unmarked nodes
    //2.1 call dfs
    public static boolean hasPath(ArrayList<Edge>[] graph,int u,int v,boolean[] vis)
    {
        if(u==v)
        return true;
        
        boolean res=false;
        vis[u]=true;
        
        for(Edge e:graph[u])
        {
            if(!vis[e.nbr])
            {
                res=res||hasPath(graph,e.nbr,v,vis);
            }
        }
        return res;
    }

    public static int printAllPaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis,String psf)
    {
        if(src==dest){
        System.out.println(psf+dest);
        psf="";
        return 1;
        }
        
        vis[src]=true;
        int count=0;
        for(Edge e:graph[src])
        {
            if(!vis[e.nbr])
            count+=printAllPaths(graph,e.nbr,dest,vis,psf+src);
        }
        vis[src]=false;
        return count;
    }
    
    public static void preOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf){
        
        System.out.println(src + "->"+ psf + "@"+wsf);        
        vis[src]=true;
        for(Edge e:graph[src]){
            if(!vis[e.nbr])
            preOrder(graph, e.nbr, vis, wsf+e.wt, psf+src);
        }
        vis[src]=false;
    }

    
    public static void postOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf){
        vis[src]=true;
        for(Edge e:graph[src]){
            if(!vis[e.nbr])
            preOrder(graph, e.nbr, vis, wsf+e.wt, psf+src);
        }
        vis[src]=false;
        
        System.out.println(src + "->"+ psf+src + "@"+wsf);        
        
    }


    public static void construction(){
        int N=7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i=0;i<N;i++)
        {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
        //  display(graph,N);
        boolean[] vis=new boolean[N];
        // System.out.println(printAllPaths(graph, 0, 6, vis, ""));
        preOrder(graph, 0, vis, 0, "");
    }
    public static void main(String[] args)
    {
        construction();
    }
}
import java.util.ArrayList;

public class l001{
    
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
        graph[v].add(new Edge(u,w));
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
        index = findEdge(v,u,graph);
        graph[v].remove(index);
    }

    public static void construct(int n){
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

    public static boolean hasPathHelper(int src,int des,ArrayList<Edge>[] graph,boolean[] vis){
        if(src == des){
            return true;
        }

        vis[src] = true;
        // for(int i=0;i<graph[src].size();i++){
        //     Edge e = graph[src].get(i);
        // }

        for(Edge e:graph[src]){
            if(vis[e.v]) continue;

            if(hasPathHelper(e.v, des, graph, vis)) return true;
        }
        return false;
    }
    public static boolean hasPath(int src,int des,ArrayList<Edge>[] graph){
        int n = graph.length;
        boolean[] vis = new boolean[n];
        return hasPathHelper(src,des,graph,vis);
    }


      // count number of paths between src and des
    public static int countPathHelper(int src,int des,ArrayList<Edge>[] graph,boolean[] vis){
        if(src == des){
            return 1;
        }

        vis[src] = true;
        int count = 0;
        for(Edge e:graph[src]){
            if(vis[e.v]) continue;

            count += countPathHelper(e.v, des, graph, vis);
        }
        vis[src] = false;
        return count;
    }
    public static int countPath(int src,int des,ArrayList<Edge>[] graph){
        int n = graph.length;
        boolean[] vis = new boolean[n];
        return countPathHelper(src,des,graph,vis);
    }

    public static class pair{
        String psf;
        int wsf;

        public pair(String psf,int wsf){
            this.psf = psf;
            this.wsf = wsf;
        }
    }
// maximum weight path (which and with what weight)
    public static pair maxWeightPath(int src, int des, ArrayList<Edge>[] graph, boolean[] vis){
        if(src == des){
            return new pair(" "+des,0);
        }

        vis[src] = true;
        pair myAns = new pair("",-(int)1e9);
        for(Edge e:graph[src]){
            if(vis[e.v]) continue;

            pair recAns = maxWeightPath(e.v, des, graph, vis);
            if(recAns.wsf!=-(int)1e9 && recAns.wsf + e.w > myAns.wsf){
                myAns.wsf = recAns.wsf + e.w;
                myAns.psf = src + " " +recAns.psf;
            }
        }
        vis[src] = false;
        return myAns;
    }

     // minimum weight path (which and with what weight)
    public static pair minWeightPath(int src, int des, ArrayList<Edge>[] graph, boolean[] vis){
        if(src == des){
            return new pair(" "+des,0);
        }

        vis[src] = true;
        pair myAns = new pair("",(int)1e9);
        for(Edge e:graph[src]){
            if(vis[e.v]) continue;

            pair recAns = maxWeightPath(e.v, des, graph, vis);
            if(recAns.wsf!=(int)1e9 && recAns.wsf + e.w < myAns.wsf){
                myAns.wsf = recAns.wsf + e.w;
                myAns.psf = src + " " +recAns.psf;
            }
        }
        vis[src] = false;
        return myAns;
    }


    public static void main(String[] args){
        construct(11);
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
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

    // get all the connected components present in the graph.
    public void dfsConnected(int src, ArrayList<Integer> curr, ArrayList<Edge>[] graph, boolean[] vis){
        vis[src] = true;
        curr.add(src);

        for(Edge e:graph[src]){
            if(!vis[e.v]){
                dfsConnected(e.v, curr, graph, vis);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph,int n){
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> comp = new ArrayList<>();
        int totalComp = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ArrayList<Integer> curr = new ArrayList<>(); 
                dfsConnected(i,curr,graph,vis);
                totalComp++;
                comp.add(curr);
            }
        }
// there are two ways to get the total no of components as whenever dfs will be called that will be for one 
// single component i.e. dfs called = no. of components and the list size can also give  us the total components 
        int noOfComp = comp.size();
        return comp;
    }


    // bfs concepts

    public void bfs(int src,ArrayList<Edge>[] graph){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        int level = 0;
        boolean isCycle = false;
        boolean[] vis = new boolean[graph.length];
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int u = que.removeFirst();
                if(vis[u]){
                    isCycle = true;
                    continue;
                }
                vis[u] = true;
                for(Edge e:graph[u]){
                    if(!vis[e.v]){
                        que.addLast(e.v);
                    }
                }
            }
            level++;
        }
        System.out.println("Is cycle present: "+ isCycle);
    }

    
    public void bfs1(int src,ArrayList<Edge>[] graph){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        int level = 0;
        boolean[] vis = new boolean[graph.length];
        que.addLast(src);

        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int u = que.removeFirst();
                for(Edge e:graph[u]){
                    if(!vis[e.v]){
                        vis[e.v] = true;
                        que.addLast(e.v);
                    }
                }
            }
            level++;
        }
        // cycle detection is not possible here
        // time reduced
    }

    public void main(String[] args){
        construct(11);
    }
}
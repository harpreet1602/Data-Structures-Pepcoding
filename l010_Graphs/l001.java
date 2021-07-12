import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.PriorityQueue;
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
        graph[v].add(new Edge(v, u,w));       
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
    public static int findEdge(ArrayList<Edge>[] graph,int u,int v)
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
        int i1=findEdge(graph,u,v);
        int i2=findEdge(graph,v,u);

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
        
        System.out.println(src + " -> "+ (psf+src) + " @ "+wsf);        
        vis[src]=true;
        for(Edge e:graph[src]){
            if(!vis[e.nbr])
            preOrder(graph, e.nbr, vis, wsf+e.wt, psf+src);
        }
        vis[src]=false;
    }
    //not having the output same as sir

    
    public static void postOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf){
        vis[src]=true;
        for(Edge e:graph[src]){
            if(!vis[e.nbr])
            postOrder(graph, e.nbr, vis, wsf+e.wt, psf+src);
        }
        vis[src]=false;
        
        System.out.println(src + " -> "+ (psf+src) + " @ "+wsf);        
        
    }

    public static class pathPair{
        int wsf=-1;
        String psf="";
    }


    public static pathPair lightiestPath(ArrayList<Edge>[] graph,int src, int dest,boolean[] vis)
    {
        if(src==dest)
        {
            pathPair base=new pathPair();
            base.psf+=src;
            base.wsf=0;
            return base;

        }

        vis[src]=true;
        pathPair myAns=new pathPair();
        myAns.wsf=(int)1e8;
        for(Edge e:graph[src]){
            if(!(vis[e.nbr])){
            pathPair recAns=lightiestPath(graph, e.nbr, dest, vis);    
                if(recAns.wsf!=-1 && recAns.wsf+e.wt<myAns.wsf){
                    myAns.psf=src+recAns.psf;
                    myAns.wsf=recAns.wsf+e.wt;
                }
        
        }
        }
        vis[src]=false;
        return myAns;
    }
    //not working
    public static void lightiestPath(ArrayList<Edge>[] graph,int src,int dest){
        boolean[] vis=new boolean[graph.length];
       pathPair ans=lightiestPath(graph, src, dest, vis);
       System.out.println("Lightiest path of: "+ans.psf+" of width: "+ans.wsf);
    }

    public static pathPair heaviestPath(ArrayList<Edge>[] graph,int src, int dest,boolean[] vis)
    {
        if(src==dest)
        {
            pathPair base=new pathPair();
            base.psf+=src;
            base.wsf=0;
            return base;
        }

        vis[src]=true;
        pathPair myAns=new pathPair();
        for(Edge e:graph[src]){
            if(!(vis[e.nbr])){
            pathPair recAns=heaviestPath(graph, e.nbr, dest, vis);    
                if(recAns.wsf!=-1 && recAns.wsf+e.wt>myAns.wsf){
                    myAns.psf=src+recAns.psf;
                    myAns.wsf=recAns.wsf+e.wt;
                }
        
        }
        }
        vis[src]=false;
        return myAns;
    }
    public static void heaviestPath(ArrayList<Edge>[] graph,int src,int dest){
        boolean[] vis=new boolean[graph.length];
       pathPair ans=heaviestPath(graph, src, dest, vis);
       System.out.println("Heaviest path of: "+ans.psf+" of width: "+ans.wsf);
    }

    public static class ceilAndFloor{
        int ceil=(int)1e9;
        int floor=-(int)1e9;
    }
    public static void ceilAndFloor(ArrayList<Edge>[] graph,int data,int src,boolean[] vis,int wsf,ceilAndFloor pair)
    {
        if(wsf>data){
            pair.ceil = Math.min(wsf,pair.ceil);
        }
        if(wsf<data){
            pair.floor = Math.max(wsf,pair.floor);
        }
        vis[src]=true;
        
        System.out.println("\nCeil is: " + pair.ceil + "\nFloor is: " + pair.floor);
        for(Edge e:graph[src])
        {
            if(!vis[e.nbr])
          ceilAndFloor(graph,data,e.nbr,vis,wsf+e.wt,pair);
        }
        vis[src]=false;
    }

    public static void ceilAndFloor(ArrayList<Edge>[] graph,int src,int data){
        boolean[] vis=new boolean[graph.length];
        ceilAndFloor pair = new ceilAndFloor();
        ceilAndFloor(graph,data,src,vis,0,pair);
        System.out.println("\nCeil is: " + pair.ceil + "\nFloor is: " + pair.floor);
    }

    public static void ceilAndFloor(ArrayList<Edge>[] graph,int data,int src,boolean[] vis,int wsf,int floor,int ceil)
    {
        if(wsf>data){
            ceil = Math.min(wsf,ceil);
        }
        if(wsf<data){
           floor = Math.max(wsf,floor);
        }
        vis[src]=true;
        
        
        System.out.println("\nCeil is: " + ceil + "\nFloor is: " + floor);
        for(Edge e:graph[src])
        {
            if(!vis[e.nbr])
          ceilAndFloor(graph,data,e.nbr,vis,wsf+e.wt,floor,ceil);
        }
        vis[src]=false;
        
    }
    public static void ceilAndFloorArgument(ArrayList<Edge>[] graph,int data,int src)
    {
        boolean[] vis=new boolean[graph.length];
        int wsf=0,floor=-(int)1e9,ceil=(int)1e9;
        ceilAndFloor(graph,data,src,vis, wsf,floor,ceil);
    
    }

    //Get Connected Components Of A Graph
    //har ek vertexrt pai dfs ko call karo aur jitni baari dfs call hoga jis jis vertex pai
    //utne hi connected component honge kyuki unme visited[i] mai false hoga to nya component
    //mil jaega

   public static void dfs(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> ans){
    visited[src]=true;
    ans.add(src);
    for(Edge e:graph[src])
    {
        if(!visited[e.nbr])
        {
            
            dfs(graph,e.nbr,visited,ans);
     
        }
    }
}
public static void dfsgcg(ArrayList<Edge>[] graph,ArrayList<ArrayList<Integer>> ans)
{
    int n=graph.length,gcc=0;
    boolean[] visited=new boolean[n];
   
    for(int i=0;i<n;i++)
    {
        if(!visited[i])
        {
             ArrayList<Integer> smallAns=new ArrayList<>();
            dfs(graph,i,visited,smallAns);
            gcc++;
            ans.add(smallAns);
        }
    }
}

//Is Graph Connected

public static void dfsgcg1(ArrayList<Edge>[] graph,ArrayList<ArrayList<Integer>> ans)
   {
       int n=graph.length,gcc=0;
       boolean[] visited=new boolean[n];
      
       for(int i=0;i<n;i++)
       {
           if(!visited[i])
           {
                ArrayList<Integer> smallAns=new ArrayList<>();
               dfs(graph,i,visited,smallAns);
               gcc++;
               ans.add(smallAns);
           }
       }
       if(gcc==1)
       System.out.println("true");
       else
       System.out.println("false");
   }

   //number of islands
     
   public static void dfs(int[][] grid,int[][] dir,int sr,int sc){
    grid[sr][sc]=1;
    for(int d=0;d<4;d++)
    {
        int r=sr+dir[d][0];
        int c=sc+dir[d][1];
        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==0)
        {
            dfs(grid,dir,r,c);
        }
    }
}
//0 for land and 1 for water


public static int numIslands(int[][] grid) {
    int componentcount=0;
    int m=grid.length;
    int n=grid[0].length;
    int[][] dir={{1,0},{-1,0},{0,-1},{0,1}};
    
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]==0)
            {
                dfs(grid,dir,i,j);
                componentcount++;
            }
        }
    }
    return componentcount;
} 

    //Hamiltonian path => har ek vertex ek baar travel hoti hai
    //Hamiltonian cycle=> hamiltonian path mai hi ek edge agar terminal ki original source sai ho
    
   public static void HamiltonianPathCycle(ArrayList<Edge>[] graph,int src,int orsrc,boolean[] vis,int edgeCount,String ans)
   {
       if(edgeCount==graph.length-1)
       {
           int ind=findEdge(graph,src,orsrc);
           if(ind!=-1)
           {
               System.out.println(ans+src+"*");
           }
           else
           {
               
               System.out.println(ans+src+".");
           }
           return;
           
       }
       
       vis[src]=true;
       
       for(Edge e:graph[src])
       {
           if(!vis[e.nbr])
           {
               
         HamiltonianPathCycle(graph,e.nbr,orsrc,vis,edgeCount+1,ans+src);
           }
       }
       
       vis[src]=false;
       
       
       
   }

   public static void HamiltonianPathCycle(ArrayList<Edge>[] graph,int src)
     {
         int n=graph.length;
         boolean[] vis=new boolean[n];
         int orsrc=src;
         int edgeCount=0;
         String ans="";
         HamiltonianPathCycle(graph,src,orsrc,vis,edgeCount,ans);
     
         
     }

     //BFS
     public static void BFS(ArrayList<Edge>[] graph,int src,int dest){
        LinkedList<Integer> que=new LinkedList<>();
        int n=graph.length;
        int level=0;
        int shortestPath=0;
        boolean isCyclePresent=false;
        boolean[] vis=new boolean[n];
        que.addLast(src);
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rvtx=que.removeFirst();
                //for cycle ,continue from here by setting a variable to true that cycle is present
                //but we can't tell how many no. of cycles through this algo


                if(vis[rvtx])
                {
                    isCyclePresent=true;
                    continue;
                }       
                if(rvtx==dest){
                    shortestPath=level;
                }         

                vis[rvtx]=true;
                for(Edge e:graph[rvtx])
                {
                    if(!vis[e.nbr])
                    que.addLast(e.nbr);
                }
            }
            level++;
        }

        System.out.println("\nCycle is present:" + isCyclePresent);
        System.out.println("\nShortest Path is : " + shortestPath );
     }




     public static boolean isCyclic(ArrayList<Edge>[] graph,int src)
     {
          LinkedList<Integer> que=new LinkedList<>();
          que.addLast(src);
          boolean[] vis=new boolean[graph.length];
          while(que.size()!=0)
          {
              int size=que.size();
              while(size-->0)
              {
                  int rvtx=que.removeFirst();
                  if(vis[rvtx])
                  {
                      return true;
                  }
                  vis[rvtx]=true;
                  for(Edge e:graph[rvtx])
                  {
                      if(!vis[e.nbr])
                      {
                          que.addLast(e.nbr);
                      }
                  }
                  
              }
              
          }
          return false;
     }
      public static void iscyclic(ArrayList<Edge>[] graph,int src)
      {
          boolean isCyclic=false;
          for(int i=src;i<graph.length;i++)
          {
          isCyclic=isCyclic||isCyclic(graph,i);
          }
          System.out.println(isCyclic);
      }


    //using class show the weights and paths and vertex

    public static class bfsPair{
        int vtx;
        String psf;
        int wsf;
        bfsPair(int vtx,String psf,int wsf)
        {
            this.vtx=vtx;
            this.psf=psf;
            this.wsf=wsf;
        }
    }
    public static void printBfsPaths(ArrayList<Edge>[] graph,int src){
        boolean[] vis=new boolean[graph.length];
        LinkedList<bfsPair> que=new LinkedList<>();
        que.add(new bfsPair(src,src+"",0));
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                bfsPair rp=que.removeFirst();
                if(vis[rp.vtx])
                continue;

                System.out.println(rp.vtx+" -> "+rp.psf+" @ "+rp.wsf);
                vis[rp.vtx]=true;
                for(Edge e:graph[rp.vtx])
                {
                    if(!vis[e.nbr])
                    {   
                        que.add(new bfsPair(e.nbr,rp.psf+e.nbr,rp.wsf+e.wt));
                    }
                }
            }
        }
    }


    public static void spreadInfection(ArrayList<Edge>[] graph,int infectedPerson,int noOfDays)
    {
        boolean[] vis=new boolean[graph.length];
        LinkedList<Integer> que=new LinkedList<>();
        que.add(infectedPerson);
        int day=1;
        int infectedCount=0;
        while(que.size()!=0)
        {
            if(day>noOfDays)
            break;
            int size=que.size();
            while(size-->0)
            {
                int ip=que.removeFirst();
                if(vis[ip])
                {
                    continue;
                }
                vis[ip]=true;
                infectedCount++;
                for(Edge e:graph[ip])
                {
                    if(!vis[e.nbr])
                    {
                        que.addLast(e.nbr);
                    }
                }
            }
            day++;
        }
        System.out.println(infectedCount);
    }

    
    //colouring ka concept hai 0 for red and 1 for green and pehle for no colour sab mai -1
    //ab isme concept ye hai ki bfs lagate hue jab cycle detect hogi to agar vha pai rvtx vala vis pehle sai koi hor
    //colour leke aaya to ye ek conflict hai to non bipartite graph hai otherwise bi partite graph hai
    //odd length cycle vala non bipartite graph hota hai
    //acyclic ya even length cycle vala bipartite graph hota hai
    public static boolean isGraphBipartite(ArrayList<Edge>[] graph,int src,int[] vis)
    {
        int color=0;
        LinkedList<Integer> que=new LinkedList<>();
        boolean isBipartite=true,cycle=false;
        que.add(src);
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rvtx=que.removeFirst();
                if(vis[rvtx]!=-1)   //cycle present
                {
                    cycle=true;
                    if(vis[rvtx]!=color)  //not bipartite graph
                    {
                        isBipartite=false;
                        break;
                    }
                    else      //bipartite graph but as there is a cycle so continue 
                    {
                        continue;
                    }
                }
                
                vis[rvtx]=color;
                for(Edge e:graph[rvtx])
                {
                    if(vis[e.nbr]==-1)
                    {
                       que.addLast(e.nbr); 
                    }
                }
            }
            color=(color+1)%2;
        }
        if(cycle){
        if(isBipartite)
        {
            System.out.println("Even length cycle");
        }
        else{
            System.out.println("Odd length cycle");
        }
        }
        else{
            System.out.println("Acyclic graph");
        }
        return isBipartite;
    }

    public static void isGraphBipartite(ArrayList<Edge>[] graph,int src)
    {
        int[] vis=new int[graph.length];
        Arrays.fill(vis,-1);
        boolean res=true;
        for(int i=0;i<graph.length;i++)
        {
        if(vis[i]==-1)
        res=res&&isGraphBipartite(graph,i,vis);
        }
        System.out.println(res);
    }


    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;
  
        Pair(int wsf, String psf){
           this.wsf = wsf;
           this.psf = psf;
        }
  
        public int compareTo(Pair o){
           return this.wsf - o.wsf;
        }
     }
    static String spath;
   static Integer spathwt = Integer.MAX_VALUE;
   static String lpath;
   static Integer lpathwt = Integer.MIN_VALUE;
   static String cpath;
   static Integer cpathwt = Integer.MAX_VALUE;
   static String fpath;
   static Integer fpathwt = Integer.MIN_VALUE;
   static PriorityQueue<Pair> pq = new PriorityQueue<>();
   public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
      if(src==dest)
      {
          if(wsf<spathwt)
          {
              spath=psf;
              spathwt=wsf;
          }
          if(wsf>lpathwt)
          {
              lpath=psf;
              lpathwt=wsf;
          }
          if(wsf>criteria && wsf<cpathwt)
          {
              cpath=psf;
              cpathwt=wsf;
          }
          if(wsf<criteria && wsf>fpathwt)
          {
              fpath=psf;
              fpathwt=wsf;
          }
          
          if(pq.size()<k)
          {
              pq.add(new Pair(wsf,psf));
          }
          else
          {
              if(wsf > pq.peek().wsf)
              {
                  pq.remove();
                  pq.add(new Pair(wsf,psf));
              }
          }
          return;
      }
      
      visited[src]=true;
      for(Edge e:graph[src])
      {
          if(!visited[e.nbr])
          {
              multisolver(graph,e.nbr,dest,visited,criteria,k,psf+e.nbr,wsf+e.wt);
          }
      }
      visited[src]=false;
      
      
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
        // preOrder(graph, 0, vis, 0, "");
        // postOrder(graph, 0, vis, 0, "");
        // heaviestPath(graph, 0, 6);
        // lightiestPath(graph, 0, 6);
        // ceilAndFloor(graph, 0, 42);
        // ceilAndFloorArgument(graph, 42, 0);
        // BFS(graph, 0, 6);
        printBfsPaths(graph, 0);
    }
    public static void main(String[] args)
    {
        construction();
    }
}
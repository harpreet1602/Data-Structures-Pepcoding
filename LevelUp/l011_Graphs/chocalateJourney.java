import java.util.*;
import java.io.*;
public class chocalateJourney {
    /* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


    public static class Edge{
        int v;
        int w;
        Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void addEdge(int u,int v,int w,ArrayList<Edge>[] graph)    {
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static void dijkstra(int[] dis,int src,ArrayList<Edge>[] graph){
        dis[src] = 0;
        // dis,vtx
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });

        pq.add(new int[]{0,src});

        while(pq.size()!=0){
            int[] rArr = pq.remove();
            int chocDis = rArr[0];
            int u = rArr[1];

            for(Edge nbr:graph[u]){
                int v = nbr.v;
                int w = nbr.w;
                if(chocDis + w <dis[v]){
                    dis[v] = chocDis + w;
                    pq.add(new int[]{dis[v],v});
                }
            }  
        }

    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
// https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/successful-marathon-0691ec04/
    // Friend takes the chocolate starting from A wherever available from
    // the k cities and then he will go to b by keeping in mind the expiry
    // date.
    // find the shortest distance path from a to all points and 
    // b to all points and only the points with the chocolate will matter
    // Scanner scn = new Scanner(System.in);

    FastReader scn = new FastReader();

    int n = scn.nextInt();
    int m = scn.nextInt();
    int k = scn.nextInt();
    int x = scn.nextInt();
    
    boolean[] chocolate = new boolean[n+1]; // vertices 1 to n so size n+1
    for(int i=0;i<k;i++){
        int num = scn.nextInt();
        chocolate[num] = true;
    }

    ArrayList<Edge>[] graph = new ArrayList[n+1];
    for(int i=0;i<=n;i++){
        graph[i] = new ArrayList<>();
    }

    for(int i=0;i<m;i++){
        int u = scn.nextInt();
        int v = scn.nextInt();
        int w = scn.nextInt();

        addEdge(u,v,w,graph);
    }

    int src = scn.nextInt();
    int des = scn.nextInt();
    
    int[] srcDis = new int[n+1];
    int[] desDis = new int[n+1];

    Arrays.fill(srcDis,(int)1e9);
    Arrays.fill(desDis,(int)1e9);

    dijkstra(srcDis,src,graph);
    dijkstra(desDis,des,graph);

    int ans = (int)1e9;

    for(int i=0;i<=n;i++){
        if(chocolate[i]==true){
            if(desDis[i]<x && srcDis[i]!=(int)1e9){
                ans = Math.min(ans,srcDis[i]+desDis[i]);
            }
        }
    }
    if(ans==(int)1e9){
        System.out.println(-1);
    }else{
        System.out.println(ans);
    }

    }

}

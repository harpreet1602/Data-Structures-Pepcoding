import java.util.ArrayList;
import java.util.List;


public class unionFind {
    private int[] par;
    private int[] size;
    
    private int findPar(int  u){
        if(par[u] == u){
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    private void merge(int p1,int p2){
        if(size[p1]<=size[p2]){
            par[p1] = p2;
            size[p2] += size[p1];
        }
        else{
            par[p2] = p1;
            size[p1] += size[p2];
        }
    }

    private int union_find(int n,List<List<Integer>> edges){
        par = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++)
        {
            par[i] = i;
            size[i] = 1;
        }

        for(List<Integer> edge:edges){
            int u = edge.get(0);
            int v = edge.get(1);

            int p1 =  findPar(u);
            int p2 = findPar(v);

            if(p1!=p2){
                merge(p1,p2);
            }
        }

        int number_of_components = 0;

        for(int i=0;i<n;i++){
            int p = findPar(i);

            if(i == p){
                number_of_components++;
            }
        }

        return number_of_components;
    }

    
    // 684. Redundant Connection
// tc O(n) => the merge and findPar gives the answer in less iterations like 3-4 
// iterations so it takes O(1) and rest the iteration takes O(n) time.
// sc O(n) => for maintaining the arrays of par and size.
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        par = new int[n];
        size = new int[n];
        
        for(int i=0; i<n; i++){
            par[i] = i;
            size[i] = 1;
        }
        
        for(int[] edge:edges){
            int p1 = findPar(edge[0]);
            int p2 = findPar(edge[1]);
            if(p1==p2){
                return edge;
            }
            merge(p1,p2);
        }
        
        return new int[]{};
    }

    

    
    // 1319. Number of Operations to Make Network Connected
// tc O(n) sc O(n)
    
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){    // to connect n vertices we need n-1 edges
            return -1;
        }

        par = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){    // union find starting 
            par[i] = i;
            size[i] = 1;
        }
        
        for(int[] conn:connections){ // for every edge do the work of union find
            int p1 = findPar(conn[0]);
            int p2 = findPar(conn[1]);
            
            if(p1!=p2){
                merge(p1,p2);
            }
        }
        int comp = 0;
        for(int i=0;i<n;i++){          // find the number of components
            int p = findPar(i);
            if(p == i){
                comp++;
            }
        }
        return comp-1;          // for connecting n components we need n-1 edges
    }




    
}

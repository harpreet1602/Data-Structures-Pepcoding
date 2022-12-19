public class graph {

//     1971. Find if Path Exists in Graph
// tc O(n) sc O(n)
//     Simple implementation of graph and then apply BFS to see whether we can reach the destination or not
//     Array of ArrayList is used for a graph. 
//     starting from the source.
public boolean validPath(int n, int[][] edges, int source, int destination) {
    ArrayList<Integer>[] graph = new ArrayList[n];
    
    for(int i=0;i<n;i++){
        graph[i] = new ArrayList<>();
    }
    
    for(int[] edge:edges){
        int u = edge[0], v = edge[1];
        graph[u].add(v);
        graph[v].add(u);
    }
    
    LinkedList<Integer> que = new LinkedList<>();
    boolean[] vis = new boolean[n];
    
    que.addLast(source);
    vis[source] = true;
    
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            int rnode = que.removeFirst();
            if(rnode == destination){
                return true;
            }
            for(int v:graph[rnode]){
                    if(!vis[v]){
                        vis[v] = true;
                        que.addLast(v);
                    }
            }
        }
    }
    return false;
}

}

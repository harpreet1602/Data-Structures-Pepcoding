import java.util.ArrayList;
import java.util.LinkedList;

public class bfs {
        // https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bfs_of_graph
        // tc O(V+E) sc O(V)
    // Traverse breadth wise but the thing to remember here is that adjacency list has been given to us
    // Which means that corresponding to 0 will be its children present i.e. 1,2,3 in the example.
    // As it is a directed graph, so we have to inculcate the visited check that if a particular vertex is already visited then 
    // don't process it again otherwise cycle will get created.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        LinkedList<Integer> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        que.addLast(0);
        vis[0] = true;
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int rvertex = que.removeFirst();
                ans.add(rvertex);
                
                ArrayList<Integer> slist = adj.get(rvertex);
                for(int v:slist){
                    if(vis[v] == false){
                        vis[v] = true;
                        que.addLast(v);
                    }
                }    
            }
        }
        return ans;
    }
}

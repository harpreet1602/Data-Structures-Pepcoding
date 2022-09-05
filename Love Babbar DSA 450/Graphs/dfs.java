import java.util.ArrayList;

public class dfs {
        
    // https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=dfs_of_graph
    // tc O(V+E) sc O(V)
    // Recursively go to leftmost child then explore it till the end and then go to other children and do the same process with the visited array
    // So that cycle does not get created.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(vis,0,adj,ans);
        return ans;
    }
    private void dfs(boolean[] vis,int vertex,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        vis[vertex] = true;
        ans.add(vertex);
        
        for(int v:adj.get(vertex)){
            if(vis[v]==false){
                dfs(vis,v,adj,ans);
            }
        }
    }
}

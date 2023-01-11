public class minTime {
    
    // 1443. Minimum Time to Collect All Apples in a Tree
// tc O(n) sc O(n)
//     Make a graph from the edges and then apply dfs 
//     If it is the starting node return apple count of the children only
//     But in that DFS what we have to consider is that if the node has Apple or the case where postive value is coming from the child then return apple count from the child+2 for current node as well because it becomes the part
//     If it is leaf node with apple count as 0 return apple count of the children that is 0.
public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    ArrayList<Integer>[] graph = new ArrayList[n];
    boolean[] vis = new boolean[n];
    for(int i=0;i<n;i++){
        graph[i] = new ArrayList<>();
    }
    for(int[] edge:edges){
        int u = edge[0];
        int v = edge[1];
        graph[u].add(v);
        graph[v].add(u);
    }
    return dfs(graph,hasApple,vis,0);
}
private int dfs(ArrayList<Integer>[] graph,List<Boolean> hasApple,boolean[] vis,int index){
    if(vis[index]) return 0;
    
    vis[index] = true;
    int appleCount = 0;
    for(int v:graph[index]){
        if(!vis[v]){
            appleCount += dfs(graph,hasApple,vis,v);
        }
    }
    if(index == 0){
        return appleCount;
    }
    if(hasApple.get(index) || appleCount>0){
        return appleCount + 2;
    }
    return appleCount;
}
}

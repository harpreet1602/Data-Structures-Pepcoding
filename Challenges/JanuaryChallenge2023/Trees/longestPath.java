public class longestPath {
    
    // 2246. Longest Path With Different Adjacent Characters
// ṭc O(n) sc O(n)
//     DFS is applied and accordingly what we are doing is to maximize the global dis through which we will get the answer
//     Start the distance at current minimum as 1.
//     At the current position we will either prev ans or current distance + neighhbour distance is maximum
//     At the current => either current or neighbour +1 is maximum
//     
    
private int ans = 1;
public int longestPath(int[] parent, String s) {
    int n = parent.length;
    ArrayList<Integer>[] graph = new ArrayList[n];
//         directed graph => one edge from parent to child.
    for(int i=0;i<n;i++){
        graph[i] = new ArrayList<>();
    }
    for(int i=1;i<n;i++){
        graph[parent[i]].add(i);
    }
    int[] dis =  new int[n];
    dfs(graph,dis,0,s);
    return ans;
}
private void dfs(ArrayList<Integer>[] graph,int[] dis,int index,String s){
    dis[index] = 1;
    
    for(int v:graph[index]){
        dfs(graph,dis,v,s);
        
        if(s.charAt(index) != s.charAt(v)){
            ans = Math.max(ans,dis[index]+dis[v]);
            dis[index] = Math.max(dis[index],dis[v]+1);
        }
    }
}
}

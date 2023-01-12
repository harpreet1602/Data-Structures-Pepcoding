public class numNodes {
    
    // 1519. Number of Nodes in the Sub-Tree With the Same Label
//     tc  O(n) sc O(n)
//     DFS will be applied
//     the template of these type of questions is first of all make a graph
//     and then apply DFS with visited array 
//     But here the trick was in storing the prevCount of the current character at the index
//     and the updated frequency which will come after its call of  children and accordingly
//     we add the ans at the current index as updated freq - prevCount of this character.
public int[] countSubTrees(int n, int[][] edges, String labels) {
    boolean[] vis = new boolean[n];
    int[] ans = new int[n];
    ArrayList<Integer>[] graph = new ArrayList[n];
    for(int i=0;i<n;i++){
        graph[i] = new ArrayList<>();
    }
    int[] freq = new int[26];
    for(int[] edge:edges){
        int u = edge[0];
        int v = edge[1];
        graph[u].add(v);
        graph[v].add(u);
    }
    dfs(graph,freq,labels,ans,vis,0);
    return ans;
}
private void dfs(ArrayList<Integer>[] graph,int[] freq,String labels,int[] ans,boolean[] vis,int index){
    vis[index] = true;
    char ch = labels.charAt(index);
    int prevCount = freq[ch-'a'];
    freq[ch-'a']++;
    for(int v:graph[index]){
        if(!vis[v]){
            dfs(graph,freq,labels,ans,vis,v);
        }
    }
    ans[index] = freq[ch-'a']-prevCount;
}
}

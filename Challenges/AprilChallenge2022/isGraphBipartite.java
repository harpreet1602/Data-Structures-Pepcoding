import java.util.LinkedList;
import java.util.Arrays;
public class isGraphBipartite{
    
//     785. Is Graph Bipartite?
//     tc O(n^2) sc O(n)
//     Graph colouring problem if we assign two colors and adjacent colors must not be equal for the graph to be bipartite.
//     from every source loop is run to ensure all the connected components that may be possible 
//     in one BFS traversal, component will be checked and will return the answer
public boolean isBipartite(int src,int[][] graph,int[] colors){
    int c = 0;
    LinkedList<Integer> que = new LinkedList<>();
    que.addLast(src);
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            int rind = que.removeFirst();
            
            if(colors[rind]!=-1){
                if(colors[rind] != c){
                    return false;
                }
                continue;
            }
            colors[rind] = c;
            
                for(int v:graph[rind]){
                if(colors[v]==-1){
                    que.addLast(v);
                }
                }
            
        }
        c=(c+1)%2;
    }
    return true;
}

public boolean isBipartite(int[][] graph) {
    int n = graph.length, m = graph[0].length;
    int[] colors = new int[n];
    
    Arrays.fill(colors,-1);
    
    for(int i=0;i<n;i++){
        if(colors[i]==-1){
        boolean isBipartite = isBipartite(i,graph,colors);
        if(!isBipartite) return false;
        }
    }
    
    return true;
    
}
}
public class isGraphBipartite {
    class Solution {
        // 785. Is Graph Bipartite?
        // tc O(n*n) sc O(n)
        //     Apply bfs with graph colouring technique and do dry run to understand the code.
            
            private boolean isBipartite(int src,int[][] graph,int[] color){
                LinkedList<Integer> que = new LinkedList<>();
                int currColor = 0;
                que.addLast(src);
                color[src] = currColor;
                
                while(que.size()!=0){
                    int size = que.size();
                    currColor = (currColor+1)%2;
                    while(size-->0){
                        int rnode = que.removeFirst();
                        
                        for(int v: graph[rnode]){
                            if(color[v]!=-1){
                                if(color[v]!=currColor){
                                    return false;
                                }
                            }
                            else{
                                que.addLast(v);
                                color[v] = currColor;
                            }
                        }
                    }
                }
                return true;
            }
            public boolean isBipartite(int[][] graph) {
                int n = graph.length;
                int[] color = new int[n];
                Arrays.fill(color,-1);
                boolean bipartite = true;
                
                for(int i=0;i<n;i++){
                    if(color[i]==-1){
                        bipartite = isBipartite(i,graph,color);
                        if(!bipartite) return false;
                    }
                }
                return true;
            }
            
        } 
}

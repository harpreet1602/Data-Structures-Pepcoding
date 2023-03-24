public class reorderRoutes {
    class Solution {
        // 1466. Reorder Routes to Make All Paths Lead to the City Zero
    // tc O(n) sc O(n)
    //     this is a graph question as the nodes edges are given and accordingly that edges need to be calculated that are in opposite direction from root.
    //     BFS can be applied here
    //     graph[i] will store list of (neighbour,sign) where normal bfs can be applied
    //     count += sign can be done for the unvisited neighbour 
    //     with this oen thing can be ensured that where we are going in the positive direction add 1 in the count and when we are going in the negative direction add 0 because from the neighbour I can reach myself.
        
        private class Pair {
            int v;
            int sign;
            Pair(int v,int sign){
                this.v = v;
                this.sign = sign;
            }
        }
        public int minReorder(int n, int[][] connections) {
            ArrayList<Pair>[] graph = new ArrayList[n];
          
            for(int i=0;i<n;i++){
                graph[i] = new ArrayList<>();
            }
            
            for(int[] connection:connections){
                int u = connection[0];
                int v = connection[1];
                graph[u].add(new Pair(v,1));
                graph[v].add(new Pair(u,0));
            }
            
            return bfs(graph,n);
        }
        private int bfs(ArrayList<Pair>[] graph,int n){
            LinkedList<Integer> que = new LinkedList<>();
            int count = 0;
            boolean[] vis = new boolean[n];
            
            que.add(0);
            while(que.size()!=0){
                int size = que.size();
                while(size-->0){
                int rnode = que.removeFirst();
                vis[rnode] = true;
                
                for(Pair pair:graph[rnode]){
                    if(!vis[pair.v]){
                        count += pair.sign;
                        que.addLast(pair.v);
                    }
                }
                }
            }
            return count;
        }
    }
}

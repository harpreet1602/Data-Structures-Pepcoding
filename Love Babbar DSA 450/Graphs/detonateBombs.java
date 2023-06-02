public class detonateBombs {
    class Solution {
        // 2101. Detonate the Maximum Bombs
    // tc O(n*m) sc O(n*m) i think
        
    //     Build a graph appropriately
    //     then apply bfs from every node and calculate the maximum ans out of it.
    //     First of two loops will be applied in the bombs array to make the graph connection of one bomb to all other bombs which can be deonated by the bomb
    //     through the formula ((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1))<=r1*r1
    //     then apply bfs and see how many nodes can be reached from me so taken a set for that purpose
        
        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length, max=1;
            ArrayList<Integer>[] graph = new ArrayList[n];
            
            for(int i=0;i<n;i++){
                ArrayList<Integer> neighbours = new ArrayList<>();
                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];
                for(int j=0;j<n;j++){
                    long x2 = bombs[j][0];
                    long y2 = bombs[j][1];
                
                    if(i!=j){
                        long dis = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
                        if(dis<=r1*r1){
                            neighbours.add(j);
                        }
                    }
                }
                graph[i] = neighbours;
            }
            
            for(int i=0;i<n;i++){
                max = Math.max(max,bfsDetonation(graph,i));
            }
            return max;
        }
        
        private int bfsDetonation(ArrayList<Integer>[] graph,int src){
            LinkedList<Integer> que = new LinkedList<>();
            HashSet<Integer> reachable =new HashSet<>();
            que.addLast(src);
            reachable.add(src);
            
            while(que.size()!=0){
                int size = que.size();
                while(size-->0){
                    int rnode = que.removeFirst();
                    
                    for(int v:graph[rnode]){
                        if(!reachable.contains(v)){
                            reachable.add(v);
                            que.addLast(v);
                        }
                    }
                }
            }
            return reachable.size();
        }
    }
}

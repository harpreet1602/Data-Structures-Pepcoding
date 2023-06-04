public class NumProvince {
    class Solution {
        // 547. Number of Provinces
    // tc O(n^2) sc O(n)
    //     No need to make a new graph this 2d array can also work like a graph
    //     Can be done using BFS, DFS or union find
    //     but we are going with the most comfortable one BFS
    //     Maitain a visited array and call bfs
    //     the number of times BFS is called that is equal to number of provinces.
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length,count=0;
            boolean[] vis = new boolean[n];
            
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    count++;
                    bfsGraph(vis,i,isConnected);
                }
            }
            return count;
        }
        private void bfsGraph(boolean[] vis,int src,int[][] isConnected){
            LinkedList<Integer> que = new LinkedList<>();
            que.addLast(src);
            vis[src] = true;
            
            while(que.size()!=0){
                int size = que.size();
                while(size-->0){
                    int rnode = que.removeFirst();
                    
                    for(int j=0;j<isConnected.length;j++){
                        if(isConnected[rnode][j] == 1 && !vis[j]){
                            vis[j] = true;
                            que.addLast(j);
                        }
                    }
                }
            }
        }
    }
}

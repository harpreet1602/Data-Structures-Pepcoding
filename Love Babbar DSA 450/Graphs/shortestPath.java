public class shortestPath{

    // Shortest path in Undirected Graph having unit distance
    // https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/0
    // tc O(n) sc O(n)
    // Make a graph adjacency list and apply simple BFS and the arr which we have to return is
    // based on the concept that the minimum distance of me from the src
    // then if we get a smaller distance while traversing then add that vertex in the queue and update its distance in answer array.
    // in the end see all the vertex's distances which haven't been updated this means they are not connected with src
    // then mark them as -1.
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int[] ans = new int[n];
        
        Arrays.fill(ans,(int)1e9);
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        LinkedList<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        que.addLast(src);
        ans[src] = 0;
        
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int rnode = que.removeFirst();
                
                for(int v:list.get(rnode)){
                    if(ans[rnode] + 1 <= ans[v]){
                        ans[v] = ans[rnode] + 1;
                        que.addLast(v);
                    }
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(ans[i] == (int)1e9){
                ans[i]=-1;
            }
        }
        return ans;
    }
}
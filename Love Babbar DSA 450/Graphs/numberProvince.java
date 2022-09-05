public class numberProvince {
    
    // 547. Number of Provinces
//     tc O(n) sc O(n)
//     BFS, the number of times the bfs is called while maintaining visited is the number of connected components available in the graph.
public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length, m = isConnected[0].length, count = 0;
    boolean[] vis = new boolean[n];
    for(int i=0;i<n;i++){
        if(vis[i] == false){
            bfs(vis,i,isConnected);
            count++;
        }
    }
    return count;
}

private void bfs(boolean[] vis,int vertex,int[][] isConnected){
    LinkedList<Integer> que = new LinkedList<>();
    
    que.addLast(vertex);
    
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            int rvertex = que.removeFirst();
            
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[rvertex][j] == 1 && vis[j] == false){
                    vis[j] = true;
                    que.addLast(j);
                }
            }
        }
    }
}

// tc O(n) sc O(n)
// DFS, no. of times dfs is called = no of components.
public int findCircleNum1(int[][] isConnected) {
    int n = isConnected.length, m = isConnected[0].length, count = 0;
    boolean[] vis = new boolean[n];
    for(int i=0;i<n;i++){
        if(vis[i] == false){
            dfs(vis,i,isConnected);
            count++;
        }
    }
    return count;
}

private void dfs(boolean[] vis,int vertex,int[][] isConnected){
    vis[vertex] = true;
    for(int j=0;j<isConnected.length;j++){
        if(isConnected[vertex][j] == 1 && vis[j] == false){
            vis[j] = true;
            dfs(vis,j,isConnected);
        }
    }
}
}

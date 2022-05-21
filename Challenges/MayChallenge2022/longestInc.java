public class longestInc {
    
//     329. Longest Increasing Path in a Matrix
//         tc O((n*m)^2) sc O(n*m)
    // it would be (M x N) ^ 2 if its only in one static direction. but we have to consider traversing M x N points in all the 4 directions, remember every point can traverse in 4 different directions, once you traverse to the next element there are 4 more ways that you can traverse so as you traverse the possible number of paths keeps growing.
//     We can apply any graph traversal here BFS/DFS/Union Find.
//     and get the increasing path from the graph.
//     So this time we are applying DFS here with DP
//     We will be having a cache 2d matrix to store the increasing path starting from
//     the index in the matrix.
//     From every index of the matrix, dfs will be applied to get the increasing path
//     starting from that index and store it in the cache 2d array.
//     In the dfs function, if the value is already stored in cache then return it.
//     otherwise go in four directions from the current index and if the new index
//     is in the range as well as current is less than the new one then call dfs
//    and get max(currlength,dfs()+1) because maximum can come from any direction
//     and minmum value that will be stored in cache is 1 of the current index.
//     return cache[sr][sc] = currlength as it will store what is the increasing path that is getting started from sr,sc.
    
private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
private int dfs(int sr,int sc,int n,int m,int[][]matrix,int[][] cache){
    int currlength=1;
    if(cache[sr][sc]!=0){
        return cache[sr][sc];
    }
    
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];
        
        if(r>=0 && c>=0 && r<n && c<m && matrix[sr][sc]<matrix[r][c]){
            currlength = Math.max(currlength,1+dfs(r,c,n,m,matrix,cache));
        }
        
    }
    return cache[sr][sc] = currlength;
    
    
}
                
    

public int longestIncreasingPath(int[][] matrix) {
    if(matrix == null) return 0;
    int n = matrix.length,m = matrix[0].length,currlength=-1;
    if(n==0 || m==0) return 0;
    int[][] cache = new int[n][m];
    
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
           currlength = Math.max(currlength,dfs(i,j,n,m,matrix,cache));
       }
    }
    
    return currlength;
        
    }
}

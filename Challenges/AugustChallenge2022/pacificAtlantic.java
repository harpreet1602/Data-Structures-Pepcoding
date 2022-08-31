public class pacificAtlantic{
    
    // 417. Pacific Atlantic Water Flow
//     tc O(3*n^2) => O(n^2) sc O(2*n^2) => O(n^2)
//     The boundary of left and top is with pacific ocean so start the dfs from their ask can I reach current node from the next node 
//    similarly for atlantic do the process from right and bottom
//   then check from the current node can we reach both the oceans.  
public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> ans = new ArrayList<>();
    int n = heights.length,m=heights[0].length;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] pacific = new boolean[n][m];
    boolean[][] atlantic = new boolean[n][m];
    
    for(int i=0;i<n;i++){
        dfs(i,0,pacific,heights,dirs);
        dfs(i,m-1,atlantic,heights,dirs);
    }       
    for(int j=0;j<m;j++){
        dfs(0,j,pacific,heights,dirs);
        dfs(n-1,j,atlantic,heights,dirs);
    }        
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(pacific[i][j] && atlantic[i][j]){
                List<Integer> small = new ArrayList<>();
                small.add(i);
                small.add(j);
                ans.add(small);
            }
        }
    }
    return ans;
}

private void dfs(int sr,int sc,boolean[][] canReach,int[][] heights,int[][] dirs){
    canReach[sr][sc] = true;
    for(int[] dir:dirs){
        int r = sr + dir[0];
        int c = sc + dir[1];
        
        if(r>=0 && c>=0 &&r<canReach.length && c<canReach[0].length && canReach[r][c] == false && heights[r][c]>=heights[sr][sc]){
            dfs(r,c,canReach,heights,dirs);
        }
    }
}
}
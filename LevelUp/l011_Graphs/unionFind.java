import java.util.ArrayList;
import java.util.List;


public class unionFind {
    private int[] par;
    private int[] size;
    
    private int findPar(int  u){
        if(par[u] == u){
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    private void merge(int p1,int p2){
        if(size[p1]<=size[p2]){
            par[p1] = p2;
            size[p2] += size[p1];
        }
        else{
            par[p2] = p1;
            size[p1] += size[p2];
        }
    }

    private int union_find(int n,List<List<Integer>> edges){
        par = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++)
        {
            par[i] = i;
            size[i] = 1;
        }

        for(List<Integer> edge:edges){
            int u = edge.get(0);
            int v = edge.get(1);

            int p1 =  findPar(u);
            int p2 = findPar(v);

            if(p1!=p2){
                merge(p1,p2);
            }
        }

        int number_of_components = 0;

        for(int i=0;i<n;i++){
            int p = findPar(i);

            if(i == p){
                number_of_components++;
            }
        }

        return number_of_components;
    }

    
    // 684. Redundant Connection
// tc O(n) => the merge and findPar gives the answer in less iterations like 3-4 
// iterations so it takes O(1) and rest the iteration takes O(n) time.
// sc O(n) => for maintaining the arrays of par and size.
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;     // for n edges here in this case we need to store the indexes of the vertices
        par = new int[n];             // from 1 to n that is why the array of size n+1 should be taken.
        size = new int[n];
        
        for(int i=0; i<n; i++){
            par[i] = i;
            size[i] = 1;
        }
        
        for(int[] edge:edges){
            int p1 = findPar(edge[0]);
            int p2 = findPar(edge[1]);
            if(p1==p2){
                return edge;
            }
            merge(p1,p2);
        }
        
        return new int[]{};
    }

    

    
    // 1319. Number of Operations to Make Network Connected
// tc O(n) sc O(n)
    
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){    // to connect n vertices we need n-1 edges
            return -1;
        }

        par = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){    // union find starting 
            par[i] = i;
            size[i] = 1;
        }
        
        for(int[] conn:connections){ // for every edge do the work of union find
            int p1 = findPar(conn[0]);
            int p2 = findPar(conn[1]);
            
            if(p1!=p2){
                merge(p1,p2);
            }
        }
        int comp = 0;
        for(int i=0;i<n;i++){          // find the number of components
            int p = findPar(i);
            if(p == i){
                comp++;
            }
        }
        return comp-1;          // for connecting n components we need n-1 edges
    }

    // https://www.codingninjas.com/codestudio/problems/smallest-equivalent-string_1381859?leftPanelTab=1
    // leetcode premium
    //  tc O(n) sc O(n)
    // make the parent array of 26 letters then accordingly whichever character will be smaller that will become
    // the parent when we have to take the decision between two vertices's parent. After mapping the vertex to its
    // parent we can traverse and get each character of str's parent and make our ans string.
    public String smallestString(String s, String t, String str) {
		// Write your code here.
        int size = 26, n = s.length();
        par = new int[size];
//         for all the 26 letters and characters will be mapped from 0 to 25
        for(int i=0;i<size;i++){
            par[i] = i;
        }
        
        for(int i=0;i<n;i++){
            int u = s.charAt(i) - 'a';
            int v = t.charAt(i) - 'a';
            
            int p1 = findPar(u);
            int p2 = findPar(v);
            
            if(p1!=p2){
                par[p1] = Math.min(p1,p2);
                par[p2] = Math.min(p1,p2);
            }
        }
        
        String ans = "";
        
        for(int i=0;i<str.length();i++){
            int num = str.charAt(i) - 'a';
            int p = findPar(num);
            ans = ans + (char)(p + 'a');
        }
        return ans;
	}


    
    // 695. Max Area of Island
// tc O(n) sc O(n)
//     union find
//     Its best way to solve was dfs.
//     Do the 2d to 1d mapping and apply the union find for grid 1 cells 
//     which are together so they will keep increasing the size of their parent.
//      after that you can see the grid 1 cell where the vertex will be its own
//     parent then that can be the candidate of the answer
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        par = new int[n*m];
        size = new int[n*m];
        
        for(int i=0;i<n*m;i++){
            par[i] = i;
            size[i] = 1;
        }
        int maxAns = 0;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    for(int[] dir:dirs){
                        int r = i + dir[0];
                        int c = j + dir[1];
                        
                        if(r>=0 && c>=0 && r<n && c<m && grid[r][c] == 1){
                            int p1 = findPar(i*m+j); // here p1 can also change using the merge function so you need to calculate again and again
                            int p2 = findPar(r*m+c);
                            if(p1!=p2){
                                merge(p1,p2);
                            }
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int p = findPar(i*m+j);
                    if(p == i*m+j){
                        maxAns = Math.max(maxAns,size[i*m+j]);
                    }
                    
                }
            }
        }
        
        return maxAns;
    }


    
//     990. Satisfiability of Equality Equations
//     tc O(n) sc O(n)
//     we have done the character mapping and applied union find by adding the 
    // edge whenever there is "==" relation and check if they have the same parent
//     when there is "!=" relation if it is then it is invalid expression so 
    // return false otherwise it is true
    public boolean equationsPossible(String[] equations) {
        int n = 26;
        par = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
        
        for(String eq:equations){
            if(eq.charAt(1) == '='){
                int u = eq.charAt(0)-'a';
                int v = eq.charAt(3)-'a';
                
                int p1 = findPar(u);
                int p2 = findPar(v);
                
                if(p1!=p2){
                    merge(p1,p2);
                }
            }
        }
        
        for(String eq:equations){
            if(eq.charAt(1) == '!'){
                int u = eq.charAt(0)-'a';
                int v = eq.charAt(3)-'a';
                
                int p1 = findPar(u);
                int p2 = findPar(v);
                
                
                if(p1==p2){
                    return false;
                }
            }
        }
        return true;
    }

    // 1202. Smallest String With Swaps
    // pending




    
}

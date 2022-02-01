import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

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


    
    // 721. Accounts Merge
//     tc O(n) sc O(n)
//     So here we need to make the structure ṭo solve the question
//     for every email we need to have a Unique id and 
//     the record of each email's name. Accordingly apply union find
//     union find will ensure that the common email list will become
//     one list. 
//     and then for a parent add all the emails corresponding to it
//     then make your answer out of this 
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> etui = new HashMap<>();
        Map<String,String> etn = new HashMap<>();
        
        int uid = 0;
        par = new int[10001];
        for(int i=0;i<10001;i++){
            par[i] = i;
        }
        
        for(List<String> account:accounts){
            String name = account.get(0);
            for(int i=1;i<account.size();i++){
                String email = account.get(i);
                
                if(!etui.containsKey(email)){
                    etui.put(email,uid);
                    uid++;
                }
                
                etn.put(email,name);
//                 first email who will be the group leader
                int p1 = findPar(etui.get(account.get(1)));
//                 parent of other emails in the list
                int p2 = findPar(etui.get(email));
                
                if(p1!=p2){
                    par[p2] = p1;
                }
            }
        }
        // now the full structure is ready so find the answer by putting the 
// emails on the parent of their uids
        
        List<List<String>> ans = new ArrayList<>();
        Map<Integer,List<String>> res = new HashMap<>();
        
        // for(int i=0;i<accounts.size();i++){
        //     ans.add(new ArrayList<>());
        // }
//         On the specified parent the list of string will be generated
// in the hashmap res.
        for(String email:etui.keySet()){
            int p = findPar(etui.get(email));
            if(!res.containsKey(p)){
                res.put(p,new ArrayList<>());
            }
            res.get(p).add(email);
            
        }
        
//         from the hashmap make the list of list string
        // System.out.println(etn);
        for(int key:res.keySet()){
            List<String> list = res.get(key);
            
            Collections.sort(list);
            
            list.add(0,etn.get(list.get(0)));
            // System.out.println(list);
            ans.add(list);
        }
        return ans;
    }


    
//     839. Similar String Groups
//     Important ques
//     tc O(n^2) sc O(n)
//     run nested loop and check if the strings are similar then merge them
//     then all path compression will take place and after that we can count 
//     the components and then that will give us distinct groups
    
    
    Map<String,String> par1 = new HashMap<>();
    
    private String findPar(String u){
        if(u.equals(par1.get(u))){
            return u;
        }
        par1.put(u,findPar(par1.get(u)));
        return par1.get(u);
    }
    
    private boolean isSimilar(String s1,String s2){
        int diff = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;   
            }
            if(diff>2) return false;
        }
        if(diff==0 || diff==2)
        return true;
        
        return false;
    }
    public int numSimilarGroups(String[] strs) {
//         constructing union find
        for(String str:strs){
            par1.put(str,str);
        }
        int n = strs.length;
        for(int i=0;i<n;i++){
            String p1 = findPar(strs[i]);
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j])){    
                String p2 = findPar(strs[j]);
                
                if(!p1.equals(p2)){
                    par1.put(p2,p1);
                } 
                }
            }
        }
        // System.out.println(par);
        int comp = 0;
        for(String str:par1.keySet()){
            String p = findPar(str);
            if(str.equals(p)){
                comp++;
            }
        }
        return comp;
        
    }


    // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/optimize-water-distribution-official/ojquestion
    // tc O(nlogn) sc O(n) 
    // so make an assumptions of the cost of well as edges that can be added in pipes as {0,idx+1,wells[idx]}
    // ṭhen apply kruskal's algo in which first sort on the basis of cost then apply the union find
    // if there is a same parent then that edge will be discarded and if not then it will add to our cost
    // we will get a minimum spanning tree and minimum cost in this case
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        par = new int[n+1];
        
        for(int i=0;i<=n;i++){
            par[i] = i;
        }
        
        int[][] newPipes = new int[pipes.length+wells.length][3];
        for(int i=0;i<pipes.length;i++){
            int[] newPipe = newPipes[i];
            int[] pipe = pipes[i];
            
            newPipe[0] = pipe[0];
            newPipe[1] = pipe[1];
            newPipe[2] = pipe[2];
        }
        int idx=0, cost=0;
        for(int i=pipes.length;i<pipes.length+wells.length;i++){
            int[] newPipe = newPipes[i];
            newPipe[0] = 0;
            newPipe[1] = idx+1;
            newPipe[2] = wells[idx];
            idx++;
        }
        
        Arrays.sort(newPipes,(int[] a, int[] b)->{
           return a[2] - b[2]; 
        });
        
        for(int i=0;i<newPipes.length;i++){
            int[] newPipe = newPipes[i];
            int u = newPipe[0];
            int v = newPipe[1];
            int c = newPipe[2];
          //   System.out.println(u+" " +v+" "+c);
            int p1 = findPar(u);
            int p2 = findPar(v);
            
            if(p1!=p2){
                par[p2] = p1;
                cost += c;
            }
        }
        return cost;
        
  
    }




// leet 1584 ============================================================
// pending tle with kruskal's 
// mixture of kruskal and prim is required


    // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/number-of-island-2-official/ojquestion
    // tc O(n*m) sc O(n*m)
    // With the help of extra space of grid we will be storing the 1s and 
    // when new 1 will be added count will be increased
    // when their parent will be same so count of the components will get decreased.
    // after each position iteration add the count in your list of integer.
  public List<Integer> numIslands2(int n, int m, int[][] positions) {
      
      int[][] grid = new int[n][m];
      par = new int[n*m];
      for(int i=0;i<n*m;i++){
          par[i] = i;
      }
      List<Integer> ans= new ArrayList<>();
      int count = 0;
      int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
      for(int[] position:positions){
          int x = position[0];
          int y = position[1];
          
          if(grid[x][y] == 1){
              ans.add(count);
              continue;
          }
          
          grid[x][y] = 1;
          count++;
          int p1 = findPar(x*m+y);
          for(int[] dir:dirs){
              int r = x + dir[0];
              int c = y + dir[1];
              if(r>=0 && c >=0 && r<n && c<m && grid[r][c] == 1){
                  int p2 = findPar(r*m+c);
                  if(p1!=p2){
                      par[p2] = p1;
                      count--;
                  }
              }
          }
          ans.add(count);
      }
      return ans;
  }


// Optimised space solution 
//   another method which don't use grid
  public List<Integer> numIslands21(int n, int m, int[][] positions) {
    par = new int[n*m];
    for(int i=0;i<n*m;i++){
        par[i] = -1;
    }
    List<Integer> ans= new ArrayList<>();
    int count = 0;
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    for(int[] position:positions){
        int x = position[0];
        int y = position[1];
        
        if(par[x*m+y] != -1){
            ans.add(count);
            continue;
        }
        
        par[x*m+y] = x*m+y;
        count++;
        int p1 = findPar(x*m+y);
        for(int[] dir:dirs){
            int r = x + dir[0];
            int c = y + dir[1];
            if(r>=0 && c >=0 && r<n && c<m && par[r*m+c] != -1){
                int p2 = findPar(r*m+c);
                if(p1!=p2){
                    par[p2] = p1;
                    count--;
                }
            }
        }
        ans.add(count);
    }
    return ans;
}

   // 924. Minimize Malware Spread
// tc O(n*m) sc O(n)
//         typical union find to connect the same parent't group together and 
//         then check by removing which ele of initial we will fet profit.
    
public int[] par;
public int[] size;

public int findPar(int u){
    if(u == par[u]) return u;
    return par[u] = findPar(par[u]);
}
public void merge(int p1,int p2){
    if(size[p1]<=size[p2]){
        par[p1] = p2;
        size[p2] += size[p1];
    }
    else{
        par[p2] = p1;
        size[p1] += size[p2];
    }
}

public int minMalwareSpread(int[][] graph, int[] initial) {
    int n = graph.length,m=graph[0].length;
    par = new int[n];
    size = new int[n];
    
    for(int i=0;i<n;i++){
        par[i] = i;
        size[i] = 1;
    } 
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(graph[i][j] == 0 || i==j) continue;
            
            int p1 = findPar(i);
            int p2 = findPar(j);
            
            if(p1!=p2){
                merge(p1,p2);
            }
        }
    }
    
// to store the parent's frequency and if it is 1 then only it will be considered
    
    int[] freq = new int[n];
    Arrays.sort(initial);
//         consider smallest value if they both give same answer
    for(int i=0;i<initial.length;i++){
        int p = findPar(initial[i]);
        
        freq[p]++;
    }
    
    int ans = -1, max = 0;
    
    for(int i=0;i<initial.length;i++){
        int p = findPar(initial[i]);
        
        if(freq[p]!=1) continue;
        
        if(size[p]>max){
            max = size[p];
            ans = initial[i];
        }
    }
    
    return ans == -1?initial[0]:ans;
}
    
}

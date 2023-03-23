public class opMakeNetConn {
    class Solution {
        // 1319. Number of Operations to Make Network Connected
    // tc O(n) sc O(n)
    //     striver video
    //     https://www.youtube.com/watch?v=FYrl7iz9_ZU&ab_channel=takeUforward
    //     Here in this question, we need to find the extra edges that are available to us and then in the end our requirement of ans = number of components - 1 should be matched
    //   if extra edges >= ans then return ans otherwise -1
    //     Union Find / Disjoint set will be used in this scenario.
        
    //     you should know how union find works practically.
    //     
        private class UnionFind{
            private int[] parent;
            private UnionFind(int n){
                parent = new int[n];
                for(int i=0;i<n;i++){
                    parent[i] = i;
                }
            }
            private int getAbsoluteParent(int i){
                if(parent[i] == i){
                    return i;
                }
                
                parent[i] = getAbsoluteParent(parent[i]);
                return parent[i];
            }
            private void unify(int i,int j){
                int absParI = getAbsoluteParent(i);
                int absParJ = getAbsoluteParent(j);
                
                if(absParI!=absParJ){
                    parent[absParJ] = absParI;
                }
            }
        }
        public int makeConnected(int n, int[][] connections) {
            UnionFind uf = new UnionFind(n);
            int extraEdges = 0,ans=0;
            for(int[] connection:connections){
                int absParI = uf.getAbsoluteParent(connection[0]);
                int absParJ = uf.getAbsoluteParent(connection[1]);
                
                if(absParI == absParJ){
                    extraEdges++;
                }
                else{
                    uf.unify(connection[0],connection[1]);
                }
            }
            
            for(int i=0;i<n;i++){
                if(uf.parent[i] == i){
                    ans++;
                }
            }
            ans = ans-1;
            if(extraEdges>=ans){
                return ans;
            }
            return -1;
        }
    }
}

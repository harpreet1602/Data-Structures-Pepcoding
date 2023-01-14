package Challenges.JanuaryChallenge2023.Graphs.UnionFind;

public class lexicoEquiStr {
    class Solution {
        // 1061. Lexicographically Smallest Equivalent String
    // tc O(n) sc O(1)
    //     So here if you look at the intuition so what is happening is that you need a group kind of thing where the smallest character should come out while making the answer.
    //    So for acheiving this purpose the solution is UnionFind, that make the union of characters that are interconnected and the smallest of them will be the parent of the whole component.
    //     Accordingly when you will make your answer string your work will be done automatically because of the power of Union Find.
        
    //     Union Find Explanation
    //     Make a class with the parent array of size 26 in this case because we are dealing with alphabets
    //     Then in the constructor every number's parent is number itself initially
    //      Now for getting absolute Parent we will keep on looking for the parent of i
    //     till the time ultimate parent of that group is not identified
    //     and in between every child will get that parent while coming back from the recursion.
    //     For unifying, what we will do is absolute parent of i and absolute parent of j is found and if whosever parent is small that will become the parent of another one.
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
                int absParentI = getAbsoluteParent(i);
                int absParentJ = getAbsoluteParent(j);
                
                if(absParentI<absParentJ){
                    parent[absParentJ] = absParentI;
                }else{
                    parent[absParentI] = absParentJ;
                }
            }
        }
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            UnionFind uf = new UnionFind(26);
            
            StringBuilder sb = new StringBuilder();
            int n = s1.length(), m = baseStr.length();
            for(int i=0;i<n;i++){
                int num1 = s1.charAt(i) - 'a';
                int num2 = s2.charAt(i) - 'a';
                
                uf.unify(num1,num2);
            }
            
            for(int i=0;i<m;i++){
                int num = uf.getAbsoluteParent(baseStr.charAt(i)-'a');            
                sb.append((char)(num+'a'));
            }
            return sb.toString();
        }
    }
}

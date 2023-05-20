public class evaluateDiv {
    class Solution {
    
        // 399. Evaluate Division
    // tc O(n) sc O(n)
    //  Map needs to be used for building the graph.
    //  string to the list of pair 
    //   BFS will be applied and if we get to the destination then return the value till now for reaching out.
    //     graph is also made u, v => val
    //     v,u => 1/val.
    //     
        
        private class Pair{
            String v;
            double val;
            
            public Pair(String v,double val){
                this.v = v;
                this.val = val;
            }
        }
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            // List<Pair>[] graph = new List[26];
            HashMap<String,List<Pair>> graph = new HashMap<>();
            
            int n = equations.size();
            double[] ans = new double[queries.size()];
           
            
            for(int i=0;i<n;i++){
                List<String> equation = equations.get(i);
                double value = values[i];
                String u = equation.get(0);
                String v = equation.get(1);
                
                List<Pair> list1 = graph.getOrDefault(u,new ArrayList<>());
                list1.add(new Pair(v,value));
                graph.put(u,list1);
                List<Pair> list2 = graph.getOrDefault(v,new ArrayList<>());
                list2.add(new Pair(u,1/value));
                graph.put(v,list2);
            }
            
            for(int i=0;i<queries.size();i++){
                List<String> query = queries.get(i);
                String u = query.get(0);
                String v = query.get(1);
                if(!graph.containsKey(u)){
                   ans[i] = -1;
                }
                else
                ans[i] = bfs(u,v,graph);
            }
            return ans;
        }
        
        private double bfs(String src,String dest,HashMap<String,List<Pair>> graph){
            LinkedList<Pair> que = new LinkedList<>();
            HashSet<String> vis = new HashSet<>();
            
            que.add(new Pair(src,1));
            vis.add(src);
            double ans = 1;
            while(que.size()!=0){
                int size = que.size();
                
                while(size-->0){
                    Pair rpair = que.removeFirst();
                    ans = rpair.val;
                    
                    if(rpair.v.equals(dest)){
                        return ans;
                    }
                    
                    for(Pair p:graph.get(rpair.v)){
                        if(!vis.contains(p.v)){
                            vis.add(p.v);
                            que.addLast(new Pair(p.v,ans*p.val));
                        }
                    }
                }
            }
            return -1.0;
        }
        
    }
}

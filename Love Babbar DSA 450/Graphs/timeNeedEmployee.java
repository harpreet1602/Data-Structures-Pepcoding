public class timeNeedEmployee {
    class Solution {
        // 1376. Time Needed to Inform All Employees
    // tc O(n) sc O(n)
    //    because manager to employee relation cannot be reversed that it can't be employee to manager that is why O(n) time not O(n^2) or O(nlogn). 
        
    //     this is a graph problem as we have to make the connections of manager to all the employees under manager
    //     and then apply bfs in which we update the informtime like it is ok that i will have this much time from me to reach other subordinate nodes but also add the time required to reach me
    // in the end one of the leaf node will have the answer stored as maximum time required to reach me in the inform time so keep the track of maximum inform time      
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            int max = informTime[headID];
            ArrayList<Integer>[] graph = new ArrayList[n];
            LinkedList<Integer> que = new LinkedList<>();
            
            for(int i=0;i<n;i++){
                graph[i] = new ArrayList<>();
            }
            
            for(int i=0;i<n;i++){
                if(i!=headID){
                    graph[manager[i]].add(i);
                }
            }
            
            que.addLast(headID);
            
            while(que.size()!=0){
                int size = que.size();
                while(size-->0){
                    int curr = que.removeFirst();
                    
                    for(int next:graph[curr]){
                        que.addLast(next);
                        informTime[next] = informTime[next] + informTime[curr];
                        max = Math.max(max,informTime[next]);
                    }
                }
            }
            return max;
        }
    }
}

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class criticalConn {
    
    // 1192. Critical Connections in a Network
//     tc O(E) sc O(E)
//     Make a bidirected graph from the connections available and then apply tarzon's algorithm
//     where nextIds are assigned when we are going forward to the neighbours
//     but when we backtrack so we assign the current node's id as the minimum of the two i.e.
//     current node's id and neighbour's node id
//     if current node's id is happen to be smaller then this means this is the critical edge 
//     if this edge will be broken then the graph will be divided into different components
//     otherwise it is not critical edge if current node's id is greater or equal to neighbour's id
//     which means the nodes are connected in a way where there will be no effect if the edge will be removed.i . e. not critical.
    
    
private int nextId = 0; 
public void tarzonAlgo(List<Integer>[] graph,int parentId,int nodeId,List<List<Integer>> ans,boolean[] visited,int[] lowestId){
    visited[nodeId] = true;
    lowestId[nodeId] = nextId;
    nextId++;
    int currentLowestId = lowestId[nodeId];
    
    for(int neighbourId:graph[nodeId]){
        if(parentId == neighbourId){
            continue;
        }
        
        if(!visited[neighbourId]){
            tarzonAlgo(graph,nodeId,neighbourId,ans,visited,lowestId);
        }
        lowestId[nodeId] = Math.min(lowestId[nodeId],lowestId[neighbourId]);
        
        if(currentLowestId < lowestId[neighbourId]){
            ans.add(Arrays.asList(nodeId,neighbourId));
        }
    }
    
}
public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<Integer>[] graph = new ArrayList[n];
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited = new boolean[n];
    int[] lowestId = new int[n];
    
    for(int i=0;i<n;i++) graph[i] = new ArrayList<>();
    
    for(List<Integer> connection:connections){
        graph[connection.get(0)].add(connection.get(1));
        graph[connection.get(1)].add(connection.get(0));
    }
    
    tarzonAlgo(graph,-1,0,ans,visited,lowestId);
    return ans;
}
}

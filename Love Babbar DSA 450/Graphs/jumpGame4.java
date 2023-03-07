
public class jumpGame4 {
    
    // 1345. Jump Game IV
// tc O(n) sc O(n)
//     Good question to test abilities of Graph
//     BFS will be applied in the sense that a node is connected to 
//     i-1,i+1, and a j where a[i] == a[j] and i!=j
//     Accordingly the things will go 
//     Make a map for equal values where list can be called if it is already present if not empty list will come and add the curr index in it and put it back as arr[i].list
//     This work will be done in O(n) [important to note]
    
//     Then no need to actually make a graph just apply the conditions accordingly and remove the key after traversing it as well. [BFS]

//     return the level where we reach the last index.
public int minJumps(int[] arr) {
    int n = arr.length, level = 0;
    
    boolean[] vis = new boolean[n];
    
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    
    for(int i=0;i<n;i++){
        ArrayList<Integer> list = map.getOrDefault(arr[i],new ArrayList<>());
        list.add(i);
        map.put(arr[i],list);
    }
    
    LinkedList<Integer> que = new LinkedList<>();
    vis[0] = true;
    que.addLast(0);
    
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            int rnode = que.removeFirst();
            if(rnode == n-1){
                return level;
            }
            if(rnode>0 && !vis[rnode-1]){
                vis[rnode-1] = true;
                que.addLast(rnode-1);
            }
            if(rnode<n && !vis[rnode+1]){
                vis[rnode+1] = true;
                que.addLast(rnode+1);
            }
            if(map.containsKey(arr[rnode])){
            for(int v:map.get(arr[rnode])){
                if(!vis[v]){
                    vis[v] = true;
                    que.addLast(v);
                }
            }
            }
            map.remove(arr[rnode]);
        }
        level++;
    }
    return -1;
}
}

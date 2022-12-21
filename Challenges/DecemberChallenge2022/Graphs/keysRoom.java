public class keysRoom{
    
// 841. Keys and Rooms
    //    tc O(n^2) sc O(n)
//     So we have to check are we visiting all the rooms in the end or not
//     So simple at the index list is there which shows the next room where we can go so accordingly BFS is applied to see that whether we will be able to visit all rooms or not
//     DFS can also be appplied, think about it.
public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    LinkedList<Integer> que = new LinkedList<>();
    HashSet<Integer> vis = new HashSet<>();
    
    que.addLast(0);
    vis.add(0);
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
        int ridx = que.removeFirst();
        
        for(int v:rooms.get(ridx)){
            if(!vis.contains(v)){
                que.addLast(v);
                vis.add(v);
            }
        }
        }
    }
    return vis.size() == rooms.size();
}
}
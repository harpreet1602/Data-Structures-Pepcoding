public class nAryTree{
    
//     429. N-ary Tree Level Order Traversal
//     tc O(n) sc O(n)
//     Just simply apply BFS template onto it 
//     All the children of the node will get added from left to right
public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> list = new ArrayList<>();
    if(root == null){
        return list;
    }
    LinkedList<Node> que = new LinkedList<>();
    que.addLast(root);
    while(que.size()!=0){
        int size = que.size();
        List<Integer> nodeAtLevel = new ArrayList<>();
        while(size-->0){
            Node rnode = que.removeFirst();
            nodeAtLevel.add(rnode.val);
            for(Node child:rnode.children){
                que.addLast(child);
            }
        }
        list.add(nodeAtLevel);
    }
    
    return list;
}
}
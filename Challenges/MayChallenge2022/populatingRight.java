import java.util.LinkedList;

public class populatingRight {
    

    // 117. Populating Next Right Pointers in Each Node II
//     tc O(n) sc O(n)
//     Cakewalk BFS can be applied that the nodes next things is to be acheived
//     This thing is getting done by level by level so this is BFS.
//     So simple BFS can be applied and If the size > 0 then assign the rnode.next = que.getFirst()
//      
//     
    class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public Node connect(Node root) {
    if(root == null)
    {
        return root;
    }
    LinkedList<Node> que = new LinkedList<>();
    que.addLast(root);
    
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            Node rnode = que.removeFirst();
            if(size!=0){
                rnode.next = que.getFirst();
            }
            if(rnode.left!=null){
                que.addLast(rnode.left);
            }
            if(rnode.right!=null){
                que.addLast(rnode.right);
            }
        }
    }
    return root;
}
}

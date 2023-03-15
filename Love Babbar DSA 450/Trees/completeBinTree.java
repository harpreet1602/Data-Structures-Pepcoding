public class completeBinTree {
    
    // 958. Check Completeness of a Binary Tree
// tc O(n) sc O(n)
//     Level order traversal will be done in order to keep the track that if a null
// comes and after that any node is getting retrieved this means it is not a complete tree 
//     otherwise it is a complete tree if this situation doesn't arise.
public boolean isCompleteTree(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<>();
    boolean flag = false;
    que.addLast(root);
    
    while(que.size()!=0){
        TreeNode rnode = que.removeFirst();
        
        if(rnode == null) flag = true;
        else{
            if(flag){
                return false;
            }
            que.addLast(rnode.left);
            que.addLast(rnode.right);
        }
    }
    return true;
}
}

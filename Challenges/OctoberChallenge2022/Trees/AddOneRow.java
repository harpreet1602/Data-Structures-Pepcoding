public class AddOneRow{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    // 623. Add One Row to Tree
//     tc O(logn) sc O(n) for queue
//     Apply BFS till depth -1 height of the tree
// then for the remaining elements present in the queue
//     store the left and right childs and then make new children of val and then correspondly make their child the reserved ones
//     handle the special case of depth = 1 explicitely. 
public TreeNode addOneRow(TreeNode root, int val, int depth) {
    if(depth == 1){
        TreeNode newRoot = new TreeNode(val);
        newRoot.left = root;
        return newRoot;
    }
    LinkedList<TreeNode> que = new LinkedList<>();
    int level = 1;
    que.addLast(root);
    
    while(que.size()!=0){
        int size = que.size();
        if(level == depth-1){
            break;
        }
        while(size-->0){
            TreeNode rnode = que.removeFirst();
            
            if(rnode.left!=null){
                que.addLast(rnode.left);
            }
            if(rnode.right!=null){
                que.addLast(rnode.right);
            }
        }
        level++;
    }
    
    while(que.size()!=0){
        TreeNode rnode = que.removeFirst();
        
        TreeNode left = rnode.left;
        TreeNode right = rnode.right;
        
        rnode.left = new TreeNode(val);
        rnode.right = new TreeNode(val);
        
        rnode.left.left = left;
        rnode.right.right = right;
    }
    return root;
}
}
import java.util.LinkedList;
public class increasingST {
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
    // 897. Increasing Order Search Tree
//     tc O(n) sc O(n)
//     Take a stack and inorderly traverse and add in the stack the treenodes
//     after that take a node out of the stack and see if head is null then set the head
//     then top.left = null and if prev != null then prev.right = top
//     with this current node and previous node scenario will be cleared.
//     after that prev will go to top's position and curr will go to top's right
//     which is telling us going in left and then parent and then go in right. (Inorder traversal) and  in the end return the new head
public TreeNode increasingBST(TreeNode root) {
    LinkedList<TreeNode> st = new LinkedList<>();
    TreeNode curr =root, prev = null, head = null;
    
    while(!st.isEmpty() || curr!=null){
        while(curr!=null){
            st.addFirst(curr);
            curr = curr.left;
        }
        
        TreeNode top = st.removeFirst();
        if(head==null){
            head = top;
        }
        top.left = null;
        if(prev!=null){
            prev.right = top;
        }
        prev = top;
        curr = top.right;
    }
    
    return head;
    
}
}

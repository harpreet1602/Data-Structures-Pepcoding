import java.util.LinkedList;

public class bstIterator{
     
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
// 173. Binary Search Tree Iterator

// First of all brute force can be done by storing all the inorder traversal in an array
//     then maintain a pointer and return next and hasNext answers
//     but tc = O(n) sc = O(n)
//     Optimised
//     with help of stack O(1) time and O(h) space, we can acheive the task
//     In inorder first left nodes are visited so store all the left nodes first of all after stack gets initialised
//     After that when next is called return stack's top ele and after
//     that get the right node of the top and add all the ele of left subtree
//     Because of the inorder traversal
//     hasNext can just be checked with the stack's size
    LinkedList<TreeNode> st;
    public void addAllLeft(TreeNode node){
        while(node!=null){
            st.addFirst(node);
            node = node.left;
        }
    }
    
    public BSTIterator(TreeNode root) {
        st = new LinkedList<>();
        addAllLeft(root);
    }
    //     tc O(1) sc O(h)
    public int next() {
        TreeNode top = st.removeFirst();
        addAllLeft(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return st.size()!=0;
    }
}
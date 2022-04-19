public class recoverBST{
    
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
    
    // 99. Recover Binary Search Tree
//     tc O(n) sc O(log n)
//     Find out the inorder traversal and while traversing just keep on checking the dip
//     if the we get the dip for the first time so first = prev and second = curr
//     if we get the dip later on then first will not get reset again but second will reset to curr
//     this is because perfect match should be made that which two nodes should be swapped to get a BST.
TreeNode prev = null;
TreeNode first = null;
TreeNode second = null;

public void inorderTraversal(TreeNode curr){
    if(curr == null){
        return;
    }
    inorderTraversal(curr.left);
//         checking dip
    if(prev!=null && prev.val>curr.val){
//             first dip
        if(first == null){
            first = prev;
        }
        second = curr;
    }
    prev = curr;
    inorderTraversal(curr.right);
}
public void recoverTree(TreeNode root) {
    inorderTraversal(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}


}
public class validateBST {
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

     // 498. Validate Binary Search Tree
    // tc O(n) sc O(1) 
    // sc O(logn) recursive space
//     check if the current node is in range and then pass the range to left and right child 
//     if from anywhere false is returned then it binary tree is not a bst.
    
public boolean isValidBST(TreeNode root) {
    return isValidBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
}
private boolean isValidBst(TreeNode root,long min,long max){
    if(root == null){
        return true;
    }
    if(root.val<=min || root.val>=max){
        return false;
    }
    return isValidBst(root.left,min,root.val) && isValidBst(root.right,root.val,max);
}
}

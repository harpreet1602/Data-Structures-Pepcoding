public class BSTtoGST {
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
    // 538. Convert BST to Greater Tree
//     tc O(n) sc O(log n)
//     Reverse inorder traversal is needed here 
//     because we need to go in right then parent and then left
//     so we will exactly do the same right then parent then left
//     In this manner global variable greateNodeSum will be maintained 
//     that will be added with the current node's value to assign the new value to the node
//     In this way greater tree will be made.
   
int greateNodeSum = 0;
public TreeNode convertBST(TreeNode root) {
     if(root == null){
        return null;
    }
    convertBST(root.right);
    greateNodeSum+=root.val;
    root.val = greateNodeSum;
    convertBST(root.left);
    return root;
}
}

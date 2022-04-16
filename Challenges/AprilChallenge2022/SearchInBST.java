public class SearchInBST {
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
//     700. Search in a Binary Search Tree
//     TC O(log n) SC O(log n) for recursive stack
//     Just keep on going where there is a possibility of finding the val
//     in left subtree or right subtree and if you find val then return that root.
//     if you encounter null then there is no val in BST.
public TreeNode searchBST(TreeNode root, int val) {
    if(root == null){
        return null;
    }
    
    if(val==root.val){
        return root;
    }
    else if(val<root.val){
        return searchBST(root.left,val);
    }
    else{
        return searchBST(root.right,val);
    }
    // return root;
}
}

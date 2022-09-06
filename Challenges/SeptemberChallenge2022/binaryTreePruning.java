public class binaryTreePruning{
    
//     tc O(n) sc O(log n)
//     jUST traverse in postorder fashion LRS 
//     So that bottom to up traversal
//     Where when we will see a leaf node as 0 then we return null from there
//     If not then a normal node in this way we manage to remove the subtrees not containing 1
public TreeNode pruneTree(TreeNode root) {
    if(root == null){
        return null;
    }
    
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    
    if(checkRemTree(root)){
        return null;
    }
    return root;
}
private boolean checkRemTree(TreeNode root){
    if(root.left == null && root.right == null && root.val == 0){
        return true;
    }
    return false;
}
}
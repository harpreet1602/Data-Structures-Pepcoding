public class FlattenBinaryTreeList {
    // 114. Flatten Binary Tree to Linked List\
//     tc O(logn) sc O(logn) I think
    // receive left and right child first in postorder fashion
//     then apply this strategy that extreme right of the left child will point to right child
//     root's right will point to left child and root.left will become null and return root from this situation.
//     this will flatten the list.
    
public void flatten(TreeNode root) {
    flattenHelper(root);
}
private TreeNode flattenHelper(TreeNode root){
    if(root == null){
        return null;
    }
    TreeNode leftChild = flattenHelper(root.left);
    TreeNode rightChild = flattenHelper(root.right);
    
    TreeNode extremeRightOfLC = leftChild;
    while(extremeRightOfLC!=null && extremeRightOfLC.right!=null){
        extremeRightOfLC = extremeRightOfLC.right;
    }
    if(extremeRightOfLC!=null){
        extremeRightOfLC.right = rightChild;
        root.right = leftChild;
    }
    root.left = null;
    return root;
}
}

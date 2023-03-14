public class symmtree {
        // 101. Symmetric Tree
//     tc O(n) sc O(log n) recursive space
//     Root's left and right child will go to be checked for mirror case 
//     Then go with the check that if any of the node is null then return true if both are null otherwise one null and not null return false
//     if the val does not match return false
//     call for p1's left child with p2's right child.
//     call for p1's right child with p2's left child.
//     return and of both the calls.
public boolean isSymmetric(TreeNode root) {
    return isSymmHelp(root.left,root.right);
}
private boolean isSymmHelp(TreeNode p1, TreeNode p2){
    if(p1 == null || p2==null){
        return p1 == p2;
    }
    if(p1.val!=p2.val)
    {
        return false;
    }
    return isSymmHelp(p1.left,p2.right) && isSymmHelp(p1.right,p2.left);
}
}

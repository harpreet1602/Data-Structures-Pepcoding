public class lowestCommonAncester {
    
    // 236. Lowest Common Ancestor of a Binary Tree\
//     tc O(log n) sc O(log n) recursive space I think
//     if root goes to null return null only and if the answer is not coming from any side then also return null.
//     First of all check if Iit is one of the nodes then return it.
//     if not then ask in its left and right subtree
//     if we find not null from left and right then return root in that case i.e. parent
//     if left is not null so return left 
//     if right is not null so return right
//     so that once any node is set it should get returned to get the LCA.
//     Otherwise return null, that the answer is not coming from here.
//     Do a dry run to understand tree working
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || p == null || q==null){
        return null;
    }
    if(root == p || root == q){
        return root;
    }
    
    TreeNode left = lowestCommonAncestor(root.left,p,q);
    TreeNode right = lowestCommonAncestor(root.right,p,q);
    
    if(left!=null && right!=null){
        return root;
    }
    if(left!=null){
        return left;
    }
    if(right!=null){
        return right;
    }
    return null;
}
}

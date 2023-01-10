public class sameTree {
    
    // 100. Same Tree
// tc O(n) sc O(logn)
//     Check the false conditions  one true condition and go for its left and then right
    // So this is a preorder traversal
//     true is like when both reaches null together return true
//     if any one reaches null return false
//     if the value is not equal at current stage then return false.
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q==null){
        return true;
    }
    if(p==null || q == null){
        return false;
    }
    if(p.val!=q.val){
        return false;
    }
    boolean left = isSameTree(p.left,q.left);
    boolean right = isSameTree(p.right,q.right);
    return left && right;
}
}

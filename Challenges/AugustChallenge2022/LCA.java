public class LCA{
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
    // 235. Lowest Common Ancestor of a Binary Search Tree
//     tc O(log n) sc O(1) 
    // sc O(log n) recursive space
//     If p and q are lying in left return future answer from left
//    If p and q are lying in right return future answer from right
//     If it is the first node that comes in the range then that is the LCA of p and q.
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(p.val<root.val && q.val<root.val){
        return lowestCommonAncestor(root.left,p,q);
    }
    else if(p.val>root.val && q.val>root.val){
        return lowestCommonAncestor(root.right,p,q);
    }
    else{
    return root;
    }
}
}
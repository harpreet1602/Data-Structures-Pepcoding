package Trees;

public class PathSum {
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
    // 112. Path Sum
//     tc O(n) sc recursive O(log n)
//     So jus traverse in the preorder fashion and keep a track of the path sum when we get the desired path sum at the leaf node we return true
//     from there on true will be returned from every state.
public boolean hasPathSum(TreeNode root, int targetSum) {
    if(root == null){
        return false;
    }
    targetSum -= root.val;
    if(root.left == null && root.right == null){
        if(targetSum == 0){
            return true;
        }
    }
    boolean leftAns = hasPathSum(root.left,targetSum);
    boolean rightAns = hasPathSum(root.right,targetSum);
    
    return leftAns || rightAns;
}    
}

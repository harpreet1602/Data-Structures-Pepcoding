public class BinaryTreeCloneSearch {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    // 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
//     tc O(n) sc O(log n) recursive space.
//     Just use any traversal, find the target node by node not value. sO FOLLOW UP
//     of duplicate values is also handled in the solution.
//     In the recursion we are asking the answers from left and right 
//     so if we get it then we will be returning that node only from everywhere.
    
public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if(original == null){
        return original;
    }
    
    if(original == target){
        return cloned;
    }
    
    TreeNode left = getTargetCopy(original.left,cloned.left,target);
    if(left!=null){
        return left;
    }
    TreeNode right = getTargetCopy(original.right,cloned.right,target);
    if(right!=null){
        return right;
    }
    return null;
}
}

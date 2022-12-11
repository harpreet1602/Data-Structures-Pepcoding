public class MaxSumPath {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 124. Binary Tree Maximum Path Sum
// tc O(n) sc O(logn) recursive
//     DP on trees can also be applied on these type of questions by just adding the memoisation in this logic
//     By keeping Map<TreeNode,Integer> for node, maxSumTillNode.
//     Simple DFS is applied right now.
    // Otherwise simple concept is to get leftSubTree max sum, right Sub tree max sum
//     add it with root's val to see Max sum so far till this node
//     and then go out for max(left,right) + root's val as there will be one path which can be returned to the parent node for further processing.
    private int msf = -(int)1e9;
    
    public int maxPathSum(TreeNode root) {
        dfsMaxPath(root);
        return msf;
    }
    private int dfsMaxPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSubTree = dfsMaxPath(root.left);
        int rightSubTree = dfsMaxPath(root.right);
        leftSubTree = leftSubTree<0?0:leftSubTree;
        rightSubTree = rightSubTree<0?0:rightSubTree;
        
        int currVal = leftSubTree + rightSubTree + root.val;
        msf = Math.max(msf,currVal);
        
        return root.val + Math.max(leftSubTree,rightSubTree);
    }
}
}

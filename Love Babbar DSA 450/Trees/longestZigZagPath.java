public class longestZigZagPath {
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
    // 1372. Longest ZigZag Path in a Binary Tree
// tc O(n+n)=>O(n) sc O(n+n)=>O(n)
//     DFS can be applied here, by taking a leftDirection variable in the sense that are we supposed to go in left direction or not according to the ongoing zigzag path
//     if yes then continue the pathsteps+1 with leftdirection for the next iteration as false, other option in that will be to go in right direction by restarting the pathsteps from 1 and leftdirection as true
//     simlarly for when are supposed to go in right direction, in that also we have to write the cases for going in left child and right child
//    keep the track of maximum path steps seen till the process is going on.
    private int max=0;
    public int longestZigZag(TreeNode root) {
        maxZigZag(root,true,0);
        maxZigZag(root,false,0);
        return max;
    }
    
    private void maxZigZag(TreeNode node,boolean leftDir,int pathSteps){
        if(node==null){
            return;
        }
        
        max = Math.max(max,pathSteps);
        
        if(leftDir){
            maxZigZag(node.left,false,pathSteps+1);
            maxZigZag(node.right,true,1);
        }
        else{
            maxZigZag(node.right,true,pathSteps+1);
            maxZigZag(node.left,false,1);
        }
    }
}
}

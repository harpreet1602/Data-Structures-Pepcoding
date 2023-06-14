public class minAbsDifference {
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
    // 530. Minimum Absolute Difference in BST
// tc O(log n) sc O(1)
    
//     BST question
// So brute can be make an inorder traversal and store it in list and try to find the adjacent difference, from there we will get the minimum difference from all the adjacent differences.
    
//optimised     
//     Apply BST property
//     Inorder traversal is already sorted, maintain a previous pointer
//     call on left side
//     processing in the current node val - prev val, change the prev to current node
//     call on right side
//     return min of all the left, processing of current node and right to parent.
    
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return (int)1e9;
        }
        
        int min = (int)1e9;
        min = Math.min(min,getMinimumDifference(root.left));
        
        if(prev!=null){
        min = Math.min(root.val - prev.val,min);
        }
        prev = root;
        
        min = Math.min(min,getMinimumDifference(root.right));
        
        return min;
    }
}
}

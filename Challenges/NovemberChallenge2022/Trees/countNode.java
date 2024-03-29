package Trees;

public class countNode {
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
    // 222. Count Complete Tree Nodes
// tc O(n) sc O(1)
// Count the nodes => in the base case return 0 and in the leaf node return 1
// get the answer from left and right + current tree's 1

public int countNodes(TreeNode root) {
    if(root == null){
        return 0;
    }
    if(root.left == null && root.right == null){
        return 1;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
}
}

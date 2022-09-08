public class binTreeInorder {
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
    // 94. Binary Tree Inorder Traversal
//     tc O(n) sc O(log n)
//     Traverse inorderly recursively
//     left then parent then right
//     Do it with stack as well.
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    inorderTraversal(root,ans);
    return ans;
}
private void inorderTraversal(TreeNode root,List<Integer> ans){
    if(root == null){
        return;   
    }
    inorderTraversal(root.left,ans);
    ans.add(root.val);
    inorderTraversal(root.right,ans);
}

}

public class questiomsBST {
  //leetcode 450 delete node in a bst
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
  public static int maximum(TreeNode node)
    {
        return node==null?-(int)1e9:Math.max(Math.max(maximum(node.left),maximum(node.right)),node.val);
    }

    public TreeNode deleteNode(TreeNode node, int data) {
    // write your code here
    if(node==null) return null;
    if(node.val>data)
    node.left=deleteNode(node.left,data);
    else if(node.val<data)
    node.right=deleteNode(node.right,data);
    else
    {
        // 0 child and 1 child case is handled
        if(node.left==null || node.right==null)
        {
            return node.left!=null?node.left:node.right;
        }
        else
        {
            int leftmax=maximum(node.left);
            node.val=leftmax;
            node.left=deleteNode(node.left,leftmax);
        }
    }
    return node;

    }  
}

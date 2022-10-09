package BST;
import java.util.Set;
import java.util.HashSet;
public class twoSUm4 {
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
    // 653. Two Sum IV - Input is a BST
//     Brute 
//     tc O(2*n)=>O(n) sc O(n)
//   Put the inorder traversal of the BST in an arraylist and then apply two pointer to
//     check the target exists or not with sum of two numbers.
    
//     Optimised
//     tc O(n) sc O(n)
//     Preorder traverse and check if target-val exists return true 
//     otherwise add it and go to check in left and then right.
public boolean findTarget(TreeNode root, int k) {
    Set<Integer> set = new HashSet<>();
    return preorder(root,set,k);
}

private boolean preorder(TreeNode root, Set<Integer> set,int k){
    if(root == null){
        return false;
    }
    if(set.contains(k-root.val)){
        return true;
    }
    set.add(root.val);
    return preorder(root.left,set,k) || preorder(root.right,set,k); 
}
}

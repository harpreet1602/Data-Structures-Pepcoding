public class TrimBST {
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
//     669. Trim a Binary Search Tree
//     Tc O(log n) SC O(log n)
//     so if it is valid then current root's left and right will be made by calling in both the directions,
    // here the root is valid so it is returned
//     but if the val is not in range and then accordingly other branch data is send to get attached by returning the other subbranch
public TreeNode trimBST(TreeNode root, int low, int high) {
    if(root==null){
        return null;
    }
    
    if(root.val<low){
        
        return trimBST(root.right,low,high);
    }
    else if(root.val>high){
        
        return trimBST(root.left,low,high);
    }
    else{
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
}

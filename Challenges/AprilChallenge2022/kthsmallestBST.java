public class kthsmallestBST {
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
     // 230. Kth Smallest Element in a BST
//     tc O(n) for traversing the k=n in the worst case 
    // sc O(log n) for the height of the BST that is getting made recursively.
//     Just keep two variables one for counting the point where we have 
    // reached in the inorder traversal and one for storing the result
//     Run an inorder traversal and then when at the parent our count will become k store the result and return 
int count = 0;
int num = 0;
public void helperkthsmallest(TreeNode root,int k){
    if(root == null){
        return;
    }
    helperkthsmallest(root.left,k);
    
    count++;
    if(count == k){
        num = root.val;
        return;
    }
    helperkthsmallest(root.right,k);
    
}
public int kthSmallest(TreeNode root, int k) {
    helperkthsmallest(root,k);
    return num;
}
}

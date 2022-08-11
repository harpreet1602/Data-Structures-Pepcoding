public class sortedArrTobst{
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
//     108. Convert Sorted Array to Binary Search Tree
// tc O(n) sc O(n)=> recursive space I think     
//     Middle element is the root at the current stage and similarly repeat the process for left and right children
//     if at any case start becomes greater than end return null.
public TreeNode sortedArrayToBST(int[] nums) {
    return arrToBST(nums,0,nums.length-1);
}
private TreeNode arrToBST(int[] nums,int start,int end){
    if(start>end){
        return null;
    }
    int mid = (start+end)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = arrToBST(nums,start,mid-1);
    root.right = arrToBST(nums,mid+1,end);
    return root;
}
}
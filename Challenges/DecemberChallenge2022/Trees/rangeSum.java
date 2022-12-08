public class rangeSum{
    
    // 938. Range Sum of BST
// tc O(n) sc O(log n) recursive
// Going for seaarching in left and right according to the range and adding the current value in the answer if it is in the range.
public int rangeSumBST(TreeNode root, int low, int high) {
    if(root == null){
        return 0;
    }
    int sum = 0;
    if(root.val>=low && root.val<=high){
        sum += root.val;
        sum += rangeSumBST(root.left,low,root.val);
        sum += rangeSumBST(root.right,root.val,high);
    }
    else if(root.val<low){
        sum += rangeSumBST(root.right,low,high);
    }
    else if(root.val>high){
        sum += rangeSumBST(root.left,low,high);
    }
    return sum;
}
}
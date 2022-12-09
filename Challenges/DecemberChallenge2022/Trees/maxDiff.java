public class maxDiff{
    
    // 1026. Maximum Difference Between Node and Ancestor
// tc O(n) sc O(logn) recursive
// from left and right subtree we will ask for the (min,max) as an array
// Then we will check its difference with current node and keep the track in the global variable of the maximum difference seen till now. 
private int maxDiff = 0;
public int maxAncestorDiff(TreeNode root) {
    maxAncDiff(root);
    return maxDiff;
}
// {min,max}
private int[] maxAncDiff(TreeNode root){
    if(root == null){
        return new int[]{(int)1e9,-(int)1e9};
    }
    int[] left = maxAncDiff(root.left);
    int[] right = maxAncDiff(root.right);

    int leftMin = left[0];
    int rightMin = right[0];
    int min = Math.min(root.val,Math.min(leftMin,rightMin));
    
    int leftMax = left[1];
    int rightMax = right[1];
    int max = Math.max(root.val,Math.max(leftMax,rightMax));

    maxDiff = Math.max(maxDiff,Math.max(root.val-min,max-root.val));
    return new int[]{min,max};
}
}
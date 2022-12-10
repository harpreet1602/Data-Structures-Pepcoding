public class maxProd{
    
    // 1339. Maximum Product of Splitted Binary Tree
// tc O(n) sc O(logn) recursive
// FInd the total sum
//     then at each node subtree sum * totatsum-subtree sum
//     this needs to be maximized.
private long totalSum=0,maxProd = 0;
public int maxProduct(TreeNode root) {
    int mod = (int)1e9+7;
    dfs(root);
    calProduct(root);
    return (int)(maxProd%mod);
}
private void dfs(TreeNode root){
    if(root == null){
        return;
    }
    dfs(root.left);
    dfs(root.right);
    
    totalSum += (long)root.val;
}
private long calProduct(TreeNode root){
    if(root == null){
        return 0;
    }
    
    long left = calProduct(root.left);
    long right = calProduct(root.right);
    
    long sum = left+right+root.val;
    
    maxProd = Math.max(maxProd,sum*(totalSum-sum));
    return sum;
}
}
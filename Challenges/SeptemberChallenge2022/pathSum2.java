public class pathSum2{
    
    // 113. Path Sum II
// tc O(n) sc O(logn) => O(height of tree) worst case sc O(n)  recursive space 
//     Template of ans and smallAns here
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> smallAns = new ArrayList<>();
    if(root == null){
        return ans;
    }
    pathSumHelper(root,targetSum,0,ans,smallAns);
    
    return ans;
}

private void pathSumHelper(TreeNode root, int targetSum,int sum, List<List<Integer>> ans, List<Integer> smallAns){
    if(root == null){
        return;
    }
// Preorder traversal
//         First of all add me then check with currsum + root.val in the leaf node case
//         if it equals target sum then add the small list in the ans otherwise don't      
    smallAns.add(root.val);
    if(root.left == null && root.right == null){
        if(sum+root.val == targetSum){
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
        }
    }     
//         then go in the left and right subtree by adding the curr ele in the list and curr sum
    pathSumHelper(root.left,targetSum,sum+root.val,ans,smallAns);
    pathSumHelper(root.right,targetSum,sum+root.val,ans,smallAns);
//         remove the last element of the list while backtracking to go for other possible results.
    smallAns.remove(smallAns.size()-1);
}
}
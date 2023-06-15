public class maxLevelSumTree {
    
    // 1161. Maximum Level Sum of a Binary Tree
// tc O(n) sc O(n)
//     Apply BFS which is also known level order traversal and maintain the maximum sum with the level.
//     return the level with the maximum sum.
    
public int maxLevelSum(TreeNode root) {
    int max = -(int)1e9, level = 1, ans=0;
    
    LinkedList<TreeNode> que = new LinkedList<>();
    que.addLast(root);
        
    while(que.size()!=0){
        int size = que.size();
        int sum = 0;
        while(size-->0){
            TreeNode rnode = que.removeFirst();
            sum += rnode.val;
            if(rnode.left!=null){
                que.addLast(rnode.left);
            }
            
            if(rnode.right!=null){
                que.addLast(rnode.right);
            }
        }
        if(sum>max){
            max = sum;
            ans = level;
        }
        level++;
    }
    return ans;
}
}

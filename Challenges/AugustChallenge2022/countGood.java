public class countGood {
    
    // 1448. Count Good Nodes in Binary Tree
//    tc O(n) sc O(logn)
//    DFS has been applied by passing the max so far seen in the path from root to that node we check and accordingly change our count.
    // Then go in left and right directions.
    private int count = 0;
    public int goodNodes(TreeNode root) {
        nodes(root,-(int)1e9);
        return count;
    }
    private void nodes(TreeNode root,int max){
        if(root == null){
            return;
        }
        if(root.val>=max){
            count++;
        }
        max = Math.max(max,root.val);
        nodes(root.left,max);
        nodes(root.right,max);        
    }
}

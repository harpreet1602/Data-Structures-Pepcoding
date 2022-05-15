import java.util.LinkedList;

public class deepestLevel {
    
//     1302. Deepest Leaves Sum
//  tc O(n) as we are traversing the n elements
//     sc O(n) for maintaining the queue.
//     Calculate the sum for each level in the bfs and in the end we will get the last
//     level's sum of nodes.
    
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
    // private int getHeight(TreeNode root){
    //     if(root == null) return 0;
    //     return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    // }
    public int deepestLeavesSum(TreeNode root) {
        // int height = getHeight(root);
    
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int level = 1,sum=0;
        while(que.size()!=0){
            int size = que.size();
            sum=0;
            while(size-->0){
                TreeNode rnode = que.removeFirst();
                // if(level == height){
                    sum+=rnode.val;
                // }
                if(rnode.left!=null){
                    que.addLast(rnode.left);
                }
                if(rnode.right!=null){
                    que.addLast(rnode.right);
                }
            }
            level++;
        }
        return sum;
    }
}

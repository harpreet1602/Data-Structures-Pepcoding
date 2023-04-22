public class maxWidthBt {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 662. Maximum Width of Binary Tree
// tc O(n) sc O(n)
//     BFS can be applied here to find the maximum width of Binary tree.
//     In the left child give weight as 2*weight of parent 
//     In the right child give weight as 2*weight of parent+1
//     with this weight factor we will be able to see weight-weight if the leftmost child +1
    public int widthOfBinaryTree(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        
        que.addLast(root);
        map.put(root,0);
        
        int maxWidth = 0,weight=0;
        
        while(que.size()!=0){
            int size = que.size();
            int left = map.get(que.getFirst());
            
            while(size-->0){
                TreeNode rnode = que.removeFirst();
                weight = map.get(rnode);
                maxWidth = Math.max(maxWidth,weight-left+1);
                
                if(rnode.left!=null){
                    que.addLast(rnode.left);
                    map.put(rnode.left,2*weight);
                }
                if(rnode.right!=null){
                    que.addLast(rnode.right);
                    map.put(rnode.right,(2*weight)+1);
                }
            }
        }
        return maxWidth;
    }
}
}

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class binTreeRight{
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
    // 199. Binary Tree Right Side View
//     tc O(n) sc O(most number of elements on one level) => O(n) I think
//     BFS
//     Add first right and then left on one level
//    So whatever is the first ele on the level will be the part of right side view. 
public List<Integer> rightSideView(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
    if(root == null){
        return ans;
    }
    que.addLast(root);
    while(que.size()!=0){
        int size = que.size();
        boolean isFirst = true;
        while(size-->0){
            TreeNode rnode = que.removeFirst();
            if(isFirst){
                ans.add(rnode.val);
                isFirst = false;
            }
            if(rnode.right!=null){
                que.addLast(rnode.right);
            }
            if(rnode.left!=null){
                que.addLast(rnode.left);
            }
        }
    }
    
    return ans;
}
}
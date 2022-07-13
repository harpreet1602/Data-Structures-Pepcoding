import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
public class levelOrder{

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
    // 102. Binary Tree Level Order Traversal
//    tc O(n) sc O(n)
//    Simple BFS is applied to get the level order traversal.
public List<List<Integer>> levelOrder1(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<TreeNode> que = new LinkedList<>();
    if(root == null){
        return ans;
    }
    que.add(root);
    while(que.size()!=0){
        int size = que.size();
        List<Integer> smallAns = new ArrayList<>();
        while(size-->0){
            TreeNode rnode = que.removeFirst();
            smallAns.add(rnode.val);
            
            if(rnode.left!=null){
                que.addLast(rnode.left);
            }
            if(rnode.right!=null){
                que.addLast(rnode.right);
            }
        }
        ans.add(smallAns);
    }
        return ans;   
    }

// DFS
//     tc O(n) sc O(n) recursive space
//     Elements will be added on the particular heights from left to right.
//     So level order traversal will be acheived through DFS as well.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
                    
        dfsLevel(root,ans,0);
        return ans;
    }
    private void dfsLevel(TreeNode root,List<List<Integer>> ans,int height){
        if(root == null){
            return;
        }
        if(ans.size() == height){
            ans.add(new ArrayList<>());
        }
        
        ans.get(height).add(root.val);
        dfsLevel(root.left,ans,height+1);
        dfsLevel(root.right,ans,height+1);
    }
}
public class binTreeTraversal {
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
    // 144. Binary Tree Preorder Traversal
// tc O(n) sc O(logn) recursive space
//     recursion => parent, left , right
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        preorder(root,list);
        return list;
    }
    private void preorder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
    
//     tc O(n) sc O(n) in case of skew tree.
//     Iterative approach
//     Stack => add the node into the the stack then pop it out and add in the answer 
//     add the right and then left => because right will come into consideration after left because of stack priority. 
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        LinkedList<TreeNode> st = new LinkedList<>();
        if(root == null){
            return ans;
        }
        st.addFirst(root);
        
        while(st.size()!=0){
            TreeNode rnode = st.removeFirst();
            ans.add(rnode.val);
            if(rnode.right!=null){
                st.addFirst(rnode.right);
            }
            if(rnode.left!=null){
                st.addFirst(rnode.left);
            }
        }
        return ans;
    }
}
}

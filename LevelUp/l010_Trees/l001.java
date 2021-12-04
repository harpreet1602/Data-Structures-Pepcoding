import java.util.List;
import java.util.ArrayList;


public class l001{
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    // 589. N-ary Tree Preorder Traversal
    // before traversal we are doing some task and then we will go for its children recursively 
    public void preorder(Node root, List<Integer> ans){
        ans.add(root.val);
        for(Node child:root.children){
            preorder(child,ans);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root!=null) 
        preorder(root,ans);
        return ans;
    }

    // 590. N-ary Tree Postorder Traversal
    // we first of all do the work for children then our own work in postorder traversal
    public void postorder(Node root,List<Integer> ans){
        for(Node child:root.children){
            postorder(child,ans);
        }
        ans.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root!=null){
            postorder(root,ans);
        }
        return ans;
    }

    // https://www.pepcoding.com/resources/online-java-foundation/generic-tree/are-trees-mirror-in-shape-official/ojquestion
    // shape wise is to be considered not ata values
    // so simple concept is to check the children's size and then check the left of the first tree to the right of
    // second tree.
    // the pattern will be like 0,n-1 and 1, n-2 and so on
    public static boolean areMirror(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size()) return false;
        // if(n1.data!=n2.data) return false;
        
        int size = n1.children.size();
        for(int i=0;i<size;i++){
            if(!areMirror(n1.children.get(i),n2.children.get(size-i-1))) return false;
        }
        return true;
      }


      public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    //   236. Lowest Common Ancestor of a Binary Tree
    private boolean find(TreeNode root,TreeNode data){
        if(root == null || data == null) return false;

        if(root == data) return true;

        return find(root.left,data) || find(root.right,data);
    }


    //     time O(n) as in the worst i might be travelling the whole binary tree, space O(n) as in the case of 
//     skewed binary tree.
    public boolean nodeToRootPath(TreeNode root,TreeNode data, List<TreeNode> ntr){
        if(root == null || data == null) return false;
        
        if(root == data){
            ntr.add(root);
            return true;
        }
//      if  I am not data then ask for it from the left and right 
        boolean ans = nodeToRootPath(root.left,data,ntr) || nodeToRootPath(root.right,data,ntr);
        
        if(ans){
            ntr.add(root);
        }
        
        return ans;
    } 
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ntr1 = new ArrayList<>();
        nodeToRootPath(root,p,ntr1);
        List<TreeNode> ntr2 = new ArrayList<>();
        nodeToRootPath(root,q,ntr2);
        
        int i = ntr1.size()-1;
        int j = ntr2.size()-1;
        while(i>=0 && j>=0 && ntr1.get(i) == ntr2.get(j)){
            i--;
            j--;
        }
        i++;
        return ntr1.get(i);
    }
    
    private TreeNode lca;
    private boolean find(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
             return false;
         }
         
         boolean left = find(root.left,p,q);
         boolean right = find(root.right,p,q);
         
         if(left && right){
             lca = root;
         }
         
         else if(root == p || root == q) {
             if(left || right){
                 lca = root;
             }
             return true;
         }
         
         return left || right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         find(root,p,q);
         return lca;
     }

    //  k down in binary tree
    private void kdown(TreeNode root,List<Integer> ans,int k){
        if(root == null) return;
        if(k==0){
            ans.add(root.val);
            return;
        }
        kdown(root.left,ans,k-1);
        kdown(root.right,ans,k-1);
    }

    public List<Integer> kdown(TreeNode root,int k){
        List<Integer> ans = new ArrayList<>();
        kdown(root, ans, k);
        return ans;
    }


     // 863. All Nodes Distance K in Binary Tree
    // time O(n) space O(n)
    // For current node call kdown and then in the node to root path go k-1 down and k-2 down and so one by blocking
    // the latest one to get the whole list of answer
    private void kfill_down(TreeNode root,List<Integer> ans,int k,TreeNode blocker){
        if(root==null || k<0 || root == blocker){
            return;
        }
        if(k==0){
            ans.add(root.val);
            return;
        }
        kfill_down(root.left,ans,k-1,blocker);
        kfill_down(root.right,ans,k-1,blocker);
    }
    public List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
        List<TreeNode> ntr = new ArrayList<>();
        nodeToRootPath(root,target,ntr);
        
        TreeNode blocker = null;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<ntr.size();i++){
            kfill_down(ntr.get(i),ans,k-i,blocker);
            blocker = ntr.get(i);
        }
        return ans;
    }


    // Optimized space
    // time O(n) space O(1)
//     -1 will be taken to show that this cannot be the part of answer. if i have reached
//     the node which is target then call kdown and after that return 1 because for the upper 
//    level it will be k-1 down . For blocking we can see that where the answer is coming 
//     either it is from left or right so block that respectively and return to the upper level
//     the respective distance +1 like k-2 down and so on.
    private int distanceKOpt(TreeNode root, TreeNode target, int k,List<Integer> ans){
        if(root == null) return -1;
        
        if(root == target){
            kfill_down(root,ans,k,null);
            return 1;
        }
        
        int leftDist = distanceKOpt(root.left,target,k,ans);
        int rightDist = distanceKOpt(root.right,target,k,ans);
        
        if(leftDist>=0){
            kfill_down(root,ans,k-leftDist,root.left);
            return leftDist+1;
        }
        
        if(rightDist>=0){
            kfill_down(root,ans,k-rightDist,root.right);
            return rightDist+1;
        }
        
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        distanceKOpt(root,target,k,ans);
        return ans;
    }    


    

}
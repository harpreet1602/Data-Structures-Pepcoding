import java.util.*;
public class questionsBinaryTree {
    //Definition for a binary tree node.
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
    class Solution {
        //leetcode 94 inorder traversal
       public List<Integer> inorderTraversal(TreeNode root) {
           if(root==null)
           {
               return new ArrayList<>();
           }
           List<Integer> MyAns=new ArrayList<>();
           List<Integer> left=inorderTraversal(root.left);
           for(int ele: left) MyAns.add(ele);
           MyAns.add(root.val);
           List<Integer> right=inorderTraversal(root.right);
           for(int ele:right) MyAns.add(ele);
           return MyAns;
       }
       //leetcode 144 preorder traversal
       public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
        {
            return new ArrayList<>();
        }
        List<Integer> MyAns=new ArrayList<>();
        MyAns.add(root.val);
        List<Integer> left=preorderTraversal(root.left);
        for(int ele:left) MyAns.add(ele);
        List<Integer> right=preorderTraversal(root.right);
        for(int ele:right) MyAns.add(ele);
        return MyAns;
    }
    //leetcode 145
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
        {
            return new ArrayList<>();
        }
        List<Integer> myAns=new ArrayList<>();
        List<Integer> left=postorderTraversal(root.left);
        for(int ele:left)
        {
            myAns.add(ele);
        }
        List<Integer> right=postorderTraversal(root.right);
        for(int ele:right)
        {
            myAns.add(ele);
        }
        myAns.add(root.val);
        return myAns;
    }
        //leetcode 110 balanced binary tree
    public int height(TreeNode node)
    {
        
        return node==null?-1:Math.max(height(node.left),height(node.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        if(!isBalanced(root.left))
            return false;
        if(!isBalanced(root.right))
            return false;
        if(Math.abs(height(root.left)-height(root.right))>1)
            return false;
        
        return true;
        }
   } 
   //leetcode 110 2nd method O(n) solution baar height nhi nikalni pad rhi that is why linear time mai
   // ek node ko ek baar visit karte hue kaam hojaega
   public class isBalPair{
    int height=-1;
    boolean isBal=true;
}
public isBalPair bal(TreeNode node)
{
    if(node==null)
    {
        return new isBalPair();
    }
    isBalPair left=bal(node.left);
    if(!left.isBal)
        return left;
    isBalPair right=bal(node.right);
    if(!right.isBal)
        return right;
    isBalPair myans=new isBalPair();
    if(Math.abs(left.height-right.height)>1)
    {
        myans.isBal=false;
        return myans;
    }
    myans.height=Math.max(left.height,right.height)+1;
    return myans;
    
}
public boolean isBalanced(TreeNode root) {
 isBalPair ans=bal(root);
    return ans.isBal;
}

//3rd method less readable kaam chalau -2 represents ki balanced tree nhi hai to vapsi karlo -2 return karte karte 
public int bal1(TreeNode node)
{
    if(node==null)
    {
        return -1;
    }
    int left=bal1(node.left);
    if(left==-2)
    {
        return left;
    }
    int right=bal1(node.right);
    if(right==-2)
    {
        return right;
    }
    int diff=Math.abs(left-right);
    if(diff>1)
    {
        return -2;
    }
    return Math.max(left,right)+1;
}
  public boolean isBalanced1(TreeNode root) {
  int res=bal1(root);
      return res!=-2?true:false;
  }
  //leetcode 236  lca
  public ArrayList<TreeNode> nodeToRootPath(TreeNode root,int data)
    {
        if(root==null)
            return null;
        if(root.val==data)
        {
            ArrayList<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
       
       ArrayList<TreeNode> myAnsl=nodeToRootPath(root.left,data);
        if(myAnsl!=null)
        {
            myAnsl.add(root);
            return myAnsl;
        }
             
      ArrayList<TreeNode>  myAnsr=nodeToRootPath(root.right,data);
            if(myAnsr!=null)
            {
            myAnsr.add(root);
            return myAnsr;
            }
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;
        ArrayList<TreeNode> ansp=nodeToRootPath(root,p.val);
        
        ArrayList<TreeNode> ansq=nodeToRootPath(root,q.val);
        
        int i=ansp.size()-1;
        
        int  j=ansq.size()-1;
        TreeNode lca=null;
        while(i>=0 && j>=0 )
        {
            if(ansp.get(i)!=ansq.get(j))
                break;
            lca=ansp.get(i);
            i--;
            j--;
        }
        return lca;
    }



    //leetcode 102
    // Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
       
        que.addLast(root);
        while(que.size()!=0)
        {
            int size = que.size();
            List<Integer> smallAns=new ArrayList<>(); 
            while(size-->0)
            {
                TreeNode rn=que.removeFirst();
                smallAns.add(rn.val);
                if(rn.left!=null)
                    que.addLast(rn.left);
                if(rn.right!=null)
                    que.addLast(rn.right);
        }
            ans.add(smallAns);
        }
        return ans;
    }
    //leetcode 103
    //Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> ans=new ArrayList<>();
    if(node==null)
        return ans;
        // write your code here
    int level=0;
    LinkedList<TreeNode> que=new LinkedList<>();
    LinkedList<TreeNode> st=new LinkedList<>();
    que.addLast(node);
    while(que.size()!=0)
    {
        int size=que.size();
        List<Integer> smallAns=new ArrayList<>();
        while(size-->0)
        {
            TreeNode rn=que.removeFirst();
            smallAns.add(rn.val);
            if(level%2==0)
            {
                if(rn.left!=null)
                st.addFirst(rn.left);
                if(rn.right!=null)
                st.addFirst(rn.right);
            }
            else
            {
                
                if(rn.right!=null)
                st.addFirst(rn.right);
               
                if(rn.left!=null)
                st.addFirst(rn.left);
            }
        }
        level++;
        LinkedList<TreeNode> temp=st;
        st=que;
        que=temp;
        ans.add(smallAns);
  }
        return ans;
    }
}

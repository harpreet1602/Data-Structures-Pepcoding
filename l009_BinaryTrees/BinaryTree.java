import java.util.*;
public class BinaryTree{
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right)
        {
            this.data=data;
            this.left=left;
            this.right=right;
        }
        Node(int data)
        {
            this(data,null,null);
        }
    }
    public static void preOrder(Node root,ArrayList<Integer> ans)
    {
        if(root==null)
        return;

        ans.add(root.data);
        preOrder(root.left,ans);
        preOrder(root.right,ans);
    }
    public static void inOrder(Node root,ArrayList<Integer> ans){
        if(root == null)
        return;
        inOrder(root.left,ans);
        ans.add(root.data);
        inOrder(root.right,ans);
    }
    public static void postOrder(Node root,ArrayList<Integer> ans)
    {
        if(root==null)
        return;
        postOrder(root.left,ans);
        postOrder(root.right,ans);
        ans.add(root.data);
    }
    
  public static int size(Node node) {
    // write your code here
    if(node==null)
    return 0;
    int leftSize=size(node.left);
    int rightSize=size(node.right);
    return leftSize+rightSize+1;
    // return node==null?0:size(node.left)+size(node.right)+1;
    // one liner code for finding the size , first find the size of left subtree and then right subtree and add  for current node and return the sum
  }

  public static int sum(Node node) {
    // write your code here
    return node==null?0:sum(node.left)+sum(node.right)+node.data;
  }

  public static int max(Node node) {
    // write your code here
    return node==null?-(int)1e9:Math.max(Math.max(max(node.left),max(node.right)),node.data);
  }
  public static int min(Node node)
  {
      if(node==null)
      {
          return (int)1e9;
      }
      int leftmin=min(node.left);
      int rightmin=min(node.right);
      int min=Math.min(leftmin,rightmin);
      int finalmin=Math.min(min,node.data);
      return finalmin;
  }
  public static int height(Node node) {
    // write your code here
    return node==null?-1:Math.max(height(node.left),height(node.right))+1;
  }
  //gfg count leaf nodes in a binary tree
  //https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
  int countLeaves(Node node) 
    {
         // Your code  
         if(node==null)
         return 0;
         if(node.left==null && node.right==null)
         {
             return 1;
         }
        //  int count=0;
        //  count+=countLeaves(node.left);
        //  count+=countLeaves(node.right);
        //  return count;
        return countLeaves(node.left)+countLeaves(node.right);
    }
    public static void exactlyOneChild(Node node,ArrayList<Integer> ans)
    {
        if(node==null || (node.left==null && node.right==null))
        return;
        exactlyOneChild(node.left,ans);
        
        exactlyOneChild(node.right,ans);
        if(node.left==null || node.right==null)
        ans.add(node.data);
    }
    //https://www.geeksforgeeks.org/print-the-nodes-having-exactly-one-child-in-a-binary-tree/
    public static int countExactlyOneChild(Node node)
    {
        if(node==null || (node.left==null&&node.right==null))
        return 0;
        int count=0;
        count+=countExactlyOneChild(node.left);
        count+=countExactlyOneChild(node.right);
        if(node.left==null || node.right==null)
        count+=1;
        return count;
    }
    public static boolean findData(Node node,int data){
        if(node==null)
        return false;
        
        if(node.data==data)
        return true;

        return findData(node.left,data) || findData(node.right,data);
    }
    public static boolean nodeToRootPath(Node node,int data,ArrayList<Node> ans)
    {
        if(node==null)
        return false;

        if(node.data==data)
        {
            ans.add(node);
            return true;
        }

        boolean res=nodeToRootPath(node.left,data,ans) || nodeToRootPath(node.right,data,ans);
        if(res)
        {
            ans.add(node);
        }
        return res;
    }
    public static ArrayList<Node> nodeToRootPath(Node root, int data)
    {
            ArrayList<Node> ans=new ArrayList<>();
            boolean check=nodeToRootPath(root,data,ans);
            return ans;
    }
    public static ArrayList<Node> nodeToRootPath01(Node node,int data)
    {
        if(node==null)
        return null;

        if(node.data==data)
        {
            ArrayList<Node> ans=new ArrayList<>();
            ans.add(node);
            return ans;
        }

        ArrayList<Node> left=nodeToRootPath01(node.left,data);
        if(left!=null)
        {
            left.add(node);
            return left;
        }
        ArrayList<Node> right=nodeToRootPath01(node.right,data);
        if(right!=null)
        {
            right.add(node);
            return right;
        }
        return null;
    }
    public static ArrayList<Node> nodeToRootPath02(Node node, int data){
        ArrayList<Node> ans=nodeToRootPath01(node,data);
        return (ans!=null)?ans:new ArrayList<>();
        }
    public static void KLevelsDown(Node node , int k,Node block,ArrayList<Integer> ans)
    {
        if(node==null || k<0 || node==block)
        return;

        if(k==0)
        {
            ans.add(node.data);
            return;
        }

        KLevelsDown(node.left,k--,block,ans);
        KLevelsDown(node.right,k--,block,ans);
    }
    public static ArrayList<Integer> printKNodesFar(Node node, int data, int k) {
        // write your code here
        ArrayList<Node> list=new ArrayList<>();
        nodeToRootPath(node, data, list);
        
        Node block=null;
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<list.size();i++)
        {
            KLevelsDown(list.get(i), k-i ,block, ans);
            block=list.get(i);
        }
        return ans;
      }

}
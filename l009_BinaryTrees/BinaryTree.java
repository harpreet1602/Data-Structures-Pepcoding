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
}
import java.util.*;
public class questions {
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

   } 
}

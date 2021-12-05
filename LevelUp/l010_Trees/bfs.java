import java.util.ArrayList;
import java.util.LinkedList;
public class bfs {
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
    
    public class Node
    {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
    }

    // https://practice.geeksforgeeks.org/problems/level-order-traversal/1#
 //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder1(Node node) 
    {
        // Your code here
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);
        ArrayList<Integer> ans = new ArrayList<>();
        if(node==null) return ans;
        while(que.size()!=0)
        {
            Node rnode = que.removeFirst();
            
            if(rnode.left!=null){
                que.addLast(rnode.left);
            }
            
            if(rnode.right!=null){
                que.addLast(rnode.right);
            }
            // if(rnode!=null)
            ans.add(rnode.data);
        }
        return ans;
    }
    
    static ArrayList <Integer> levelOrder2(Node node) 
    {
        // Your code here
        LinkedList<Node> que = new LinkedList<>();
        
        que.addLast(node);
        que.addLast(null);
        int level = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(que.size()!=0)
        {
            Node rnode = que.removeFirst();
            
            if(rnode == null){
                // System.out.println("<- Level "+level);
                level++;
                if(que.size()>1)
                que.addLast(null);
                continue;
            }
            // System.out.print(rnode.data+" ");
            if(rnode.left!=null){
                que.addLast(rnode.left);
            }
            
            if(rnode.right!=null){
                que.addLast(rnode.right);
            }
            // if(rnode!=null)
            ans.add(rnode.data);
        }
        return ans;
    }    
    static ArrayList <Integer> levelOrder(Node node) 
    {
         LinkedList<Node> que = new LinkedList<>();
        
        que.addLast(node);
        int level = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(que.size()!=0)
        {
            int size = que.size();
            // System.out.println("level "+level);
            while(size-->0){
            Node rnode = que.removeFirst();
            
            // System.out.print(rnode.data+" ");
            if(rnode.left!=null){
                que.addLast(rnode.left);
            }
            
            if(rnode.right!=null){
                que.addLast(rnode.right);
            }
            ans.add(rnode.data);
            }
            // System.out.println();
            level++;
        }
        return ans;
    }

    // vertical order =============

    

       
}

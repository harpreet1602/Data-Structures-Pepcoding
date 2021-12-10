import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    // https://www.hackerrank.com/challenges/tree-level-order-traversal/problem?isFullScreen=false
    
	public static void levelOrder4(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Node rnode = que.removeFirst();
                System.out.print(rnode.data + " ");
                if(rnode.left!=null){
                    que.addLast(rnode.left);
                }
                if(rnode.right!=null){
                    que.add(rnode.right);
                }
            }
        }
        
      }

    // https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1#
    //Function to return list containing elements of left view of binary tree.
    // When we reach the level for the firt time then only add the node's val in the ans 
    // this will give me the left view
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans = new ArrayList<>();
      if(root == null)
      return ans;
      LinkedList<Node> que = new LinkedList<>();
      que.addLast(root);
      while(que.size()!=0){
          int size = que.size();
          boolean first = true;
          while(size-->0){
              Node rnode= que.removeFirst();
              if(first){
                  ans.add(rnode.data);
                  first = false;
              }
              if(rnode.left!=null){
                  que.addLast(rnode.left);
              }
              
              if(rnode.right!=null){
                  que.addLast(rnode.right);
              }
              
          }
          
      }
      return ans;
    }

    // without space, using recursion space
    void leftView(ArrayList<Integer> ans,Node root,int level){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(root.data);
        }
        leftView(ans,root.left,level+1);
        leftView(ans,root.right,level+1);
    }
    ArrayList<Integer> leftView1(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        leftView(ans,root,0);
        return ans;
    }


    // 199. Binary Tree Right Side View
//     time O(n) space O(n)
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        if(root == null)
            return ans;
        que.addLast(root);
        while(que.size()!=0){
            int size = que.size();
            boolean first = true;
            while(size-->0){
                TreeNode rnode = que.removeFirst();
                if(first){
                    ans.add(rnode.val);
                    first = false;
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
    
//     time O(n) space O(1)
     public void rightSideView(List<Integer> ans,TreeNode root,int level) {
         if(root == null){
                return;
         }
         if(ans.size() == level){
             ans.add(root.val);
         }
         rightSideView(ans,root.right,level+1);
         rightSideView(ans,root.left,level+1);
     }
     public List<Integer> rightSideView(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
         rightSideView(ans,root,0);
         return ans;
     }


    // vertical order =============

    //Function to find the vertical order traversal of Binary Tree.
    static class Pair{
        Node node;
        int vl;
        public Pair(Node node,int vl){
            this.node = node;
            this.vl = vl;
        }
    }
    static void findShift(Node root,int[] minMax,int level){
        if(root == null){
            return;
        }
        minMax[0] = Math.min(minMax[0],level);
        minMax[1] = Math.max(minMax[1],level);
        
        findShift(root.left,minMax,level-1);
        findShift(root.right,minMax,level+1);
    }
    // with recursion order will not be followed
    static void recVerticalOrder(Node root,ArrayList<ArrayList<Integer>> bigAns, int vl,int shift){
        if(root == null) return;
        bigAns.get(shift+vl).add(root.data);
        
        recVerticalOrder(root.left,bigAns,vl-1,shift);
        recVerticalOrder(root.right,bigAns,vl+1,shift);
    }
    static ArrayList <Integer> verticalOrder(Node root)
    {
        LinkedList<Pair> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> bigAns = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        que.addLast(new Pair(root,0));
        int[] minMax = new int[2];
     
        findShift(root,minMax,0);
        int width = minMax[1] - minMax[0] + 1;
        for(int i=0;i<width;i++){
            bigAns.add(new ArrayList<>());
        }
        int shift = Math.abs(minMax[0]);
        
        recVerticalOrder(root,bigAns,0,shift);
        
        
        
        for(ArrayList<Integer> small:bigAns){
            for(Integer ele: small){
                ans.add(ele);
            }
        }
        return ans;
    }

    // without recursion using level order traversal 
    // insert those elements in vertcial order first which are coming first in level order 
    static ArrayList <Integer> verticalOrder1(Node root)
    {
        // add your code here
        // to maintain the order we need to use BFS
        LinkedList<Pair> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> bigAns = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        que.addLast(new Pair(root,0));
        int[] minMax = new int[2];
     
        findShift(root,minMax,0);
        int width = minMax[1] - minMax[0] + 1;
        for(int i=0;i<width;i++){
            bigAns.add(new ArrayList<>());
        }
        int shift = Math.abs(minMax[0]);
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Pair rpair = que.removeFirst();
                bigAns.get(rpair.vl + shift).add(rpair.node.data);
                if(rpair.node.left!=null){
                    que.addLast(new Pair(rpair.node.left,rpair.vl-1));
                }
                if(rpair.node.right!=null){
                    que.addLast(new Pair(rpair.node.right,rpair.vl+1));
                }
            }
        }
        for(ArrayList<Integer> small:bigAns){
            for(Integer ele: small){
                ans.add(ele);
            }
        }
        return ans;
    }



    // https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree
   
    // get the first ele in vertical order traversal
    static ArrayList<ArrayList<Integer>> verticalOrder2(Node root)
    {
        // add your code here
        // to maintain the order we need to use BFS
        LinkedList<Pair> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> bigAns = new ArrayList<>();
        
        que.addLast(new Pair(root,0));
        int[] minMax = new int[2];
     
        findShift(root,minMax,0);
        int width = minMax[1] - minMax[0] + 1;
        for(int i=0;i<width;i++){
            bigAns.add(new ArrayList<>());
        }
        int shift = Math.abs(minMax[0]);
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Pair rpair = que.removeFirst();
                bigAns.get(rpair.vl + shift).add(rpair.node.data);
                if(rpair.node.left!=null){
                    que.addLast(new Pair(rpair.node.left,rpair.vl-1));
                }
                if(rpair.node.right!=null){
                    que.addLast(new Pair(rpair.node.right,rpair.vl+1));
                }
            }
        }
        return bigAns;
    }
    
    static ArrayList<Integer> topView1(Node root)
    {
        // add your code
        ArrayList<ArrayList<Integer>> bigAns =  verticalOrder2(root);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<bigAns.size();i++)
        {
            ans.add(bigAns.get(i).get(0));
        }
        return ans;
        
    }



    // 2nd approach

    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        LinkedList<Pair> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        que.addLast(new Pair(root,0));
        int[] minMax = new int[2];
     
        findShift(root,minMax,0);
        int width = minMax[1] - minMax[0] + 1;
        for(int i=0;i<width;i++){
            ans.add(null);
        }
        int shift = Math.abs(minMax[0]);
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Pair rpair = que.removeFirst();
                 
                 if(ans.get(rpair.vl+shift) == null){
                     ans.set(rpair.vl+shift,rpair.node.data);
                 }
                if(rpair.node.left!=null){
                    que.addLast(new Pair(rpair.node.left,rpair.vl-1));
                }
                if(rpair.node.right!=null){
                    que.addLast(new Pair(rpair.node.right,rpair.vl+1));
                }
            }
        }
        return ans;   
    }

    

       
}

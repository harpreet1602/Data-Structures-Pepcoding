import java.util.*;
public class l002_BST{
    public static class Node{
        public static int size(Node node) {
            // write your code here
            return node==null?0:size(node.left)+size(node.right)+1;
          }
        
          public static int sum(Node node) {
            // write your code here
            return node==null?0:sum(node.left)+sum(node.right)+node.data;
          }
        
          public static int max(Node node) {
            // write your code here
            while(node.right!=null)
            {
                node=node.right;
            }
            return node.data;
          }
        
          public static int min(Node node) {
            // write your code here
            while(node.left!=null)
            {
                node=node.left;
            }
            return node.data;
          }
        
          public static boolean find(Node node, int data){
            // write your code here
            while(node!=null)
            {
                if(node.data==data)
                {
                    return true;
                }
                else if(node.data<data)
                {
                    node=node.right;
                }
                else
                {
                    node=node.left;
                }
            }
            return false;
          }  
        public static ArrayList<Node> nodeToRootPath(Node node,int data)
        {
            ArrayList<Node> path=new ArrayList<>();
            while(node!=null)
            {
                if(node.data==data)
                {
                    path.add(node);
                    return list;
                }
                else if(node.data<data)
                {
                    path.add(node);
                    node=node.right;
                }
                else
                {
                    path.add(node);
                    node=node.left;
                }
            }
            return null;
        }
    }
}
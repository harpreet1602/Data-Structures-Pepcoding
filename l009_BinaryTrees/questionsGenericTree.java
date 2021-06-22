import java.util.*;
public class questionsGenericTree {
    

// Definition for a Node.
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
}
    
public int maxDepth_(Node root) {
       
    int height=0;
    for(Node child:root.children)
    {
        height=Math.max(height,maxDepth_(child));
    }
    return height+1;
}

public int maxDepth(Node root){
 if(root==null)
        return 0;
   return  maxDepth_(root);
}

}

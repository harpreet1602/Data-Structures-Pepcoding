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

//leetcode 429
//N-ary Tree Level Order Traversal

public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> ans=new ArrayList<>();
    if(root==null)
        return ans;
    LinkedList<Node> que=new LinkedList<>();
    que.add(root);
    while(que.size()!=0)
    {
        int size=que.size();
        List<Integer> smallAns=new ArrayList<>();
        while(size-->0)
        {
            Node rn=que.removeFirst();
            smallAns.add(rn.val);
            for(Node child:rn.children)
            {
                que.addLast(child);
            }
        }
        ans.add(smallAns);
    }
    return ans;
}
//leetcode 103
//Binary Tree Zigzag Level Order Traversal
}

public class stringTree {
    
//     606. Construct String from Binary Tree
//     tc O(n) sc O(logn)
//     Go in preorder fashion and solve the purpose by using a stringbuilder
//     then check for base case then add the root.val
//     then if it is a leaf node again return from there
//     check if the node's left child is not empty then go for the answer
//     check if the node's right child is not empty and check for the edge case to add empty parenthesis
//     and then go for the search.
public String tree2str(TreeNode root) {
    StringBuilder str = new StringBuilder();
    makeString(root,str);
    return str.toString();
}
private void makeString(TreeNode root,StringBuilder str){
    if(root == null){
        return;
    }
    str.append(root.val);
    
    if(root.left == null && root.right == null){
        return;
    }
    if(root.left!=null){
        str.append("(");
        makeString(root.left,str);
        str.append(")");
    }
    if(root.right!=null){
        if(root.left==null){
            str.append("()");                
        }
        str.append("(");
        makeString(root.right,str);
        str.append(")");
    }
    
}
}

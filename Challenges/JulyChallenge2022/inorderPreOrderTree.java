public class inorderPreOrderTree {
    
    // 105. Construct Binary Tree from Preorder and Inorder Traversal
//     tc O(n) sc O(n)
//     Iterate over preorder array and recursively reduce the search space in inorder array
//     At every step, preorder's index will become the root of the subtree
//     then its index will be found in the inorder if it's found then call for its left and right and attach it the results to its child.
//   handling the cases like preorder's length has reached so return null as no root can be made now because the whole preorder is traversed and tree is made
//     If search space length is not 1 then also return null
private int preOrderIdx = 0;
    
public TreeNode buildTree(int[] preorder, int[] inorder) {
    TreeNode root = buildTreeHelper(preorder,inorder,0,inorder.length-1);
    return root;   
}

private TreeNode buildTreeHelper(int[] preorder,int[] inorder, int inorderStart,int inorderEnd){
    if(preOrderIdx>=preorder.length){
        return null;
    }
    
    TreeNode node = new TreeNode(preorder[preOrderIdx]);
    
    int inorderIdx = searchInorderIdx(inorder,preorder[preOrderIdx],inorderStart,inorderEnd);
    
    if(inorderIdx == -1){
        return null;
    }
    preOrderIdx++;
    node.left = buildTreeHelper(preorder,inorder,inorderStart,inorderIdx-1);
    node.right = buildTreeHelper(preorder,inorder,inorderIdx+1,inorderEnd);
    
    return node;
}

private int searchInorderIdx(int[] inorder,int target,int start,int end){
    while(start<=end){
        if(inorder[start] == target ){
            return start;
        }
        start++;
    }
    return -1;
}
}

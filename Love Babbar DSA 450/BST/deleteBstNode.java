public class deleteBstNode{
    
//    450. Delete Node in a BST
//     tc O(log n) sc O(log n)
//     the links will be attached like this that ask for the answer from the sides and
//     it gets connected by the node which is returned through which the node can be deleted.
//     all the links can be maintained.
    
public TreeNode deleteNode(TreeNode root, int key) {
    //         Base case
            if(root==null){
                return root;
            }
    //         Find where is the key in the bst and ask for the answer and attach the returned answer to its respective sides i.e. lhs and rhs
            
            if(key < root.val){
                root.left = deleteNode(root.left,key);
            }
            else if(key>root.val){
                root.right = deleteNode(root.right,key);
            }
    //         Handle the case when the key is found.
            else{
    //            key == root.val
    //             Handle the case when one node is null so the other other node will be
    //             returned so that the current node can be deleted.
                if(root.left==null){
                    return root.right;
                }
                else if(root.right==null){
                    return root.left;
                }
                
                else{
    //                 both are not null => general case
    //                 Ask for the inorder succesor => which will be found by starting from the node's right 
    //                 go to its left till the leaf node.
    //                 So that inorder succesor's value will come to the current node's value
    //                 But now we have to delete the inorder successor from its previous position as well
    //                 Ask for the answer from right hand side by recursively calling
    //                 for the root of node.right and key as minNode.val
    //                 So all the bst will be made properly after deletion recursively
    //                 Do dry run to understand it.
                    TreeNode minNode = minimumNode(root.right);
                    root.val = minNode.val;
                    root.right = deleteNode(root.right,minNode.val);
                }
                
            }
            return root;
        }
        
        private TreeNode minimumNode(TreeNode node){
            if(node == null) {
                 return node;
            }
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }
}
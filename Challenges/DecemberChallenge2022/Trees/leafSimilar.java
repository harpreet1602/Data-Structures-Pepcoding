public class leafSimilar {
    
    // 872. Leaf-Similar Trees
// tc O(n) sc O(log n) recursive.
// Simple preorder traversal to go and store the leaf nodes value in a list
// then compare both the lists.
// 
public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    findLeaf(root1,list1);
    findLeaf(root2,list2);
    if(list1.size()!=list2.size()){
        return false;
    }

    for(int i=0;i<list1.size();i++){
        if(list1.get(i)!=list2.get(i)){
            return false;
        }
    }
    return true;
}
private void findLeaf(TreeNode root, List<Integer> list){
    if(root == null){
        return;
    }
    if(root.left == null && root.right == null){
        list.add(root.val);
    }
    findLeaf(root.left,list);
    findLeaf(root.right,list);        
}
}

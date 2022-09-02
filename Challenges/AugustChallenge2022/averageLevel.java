public class averageLevel {
    
    // 637. Average of Levels in Binary Tree
//     tc O(n) sc O(logn)
//     Apply bfs in trees to get the simple answer, add the sum of all the values at one level divded by total number of elements present at that level
public List<Double> averageOfLevels(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<>();
    
    que.addLast(root);
    Double ans = 0.0;
    List<Double> list = new ArrayList<>();
    
    while(que.size()!=0){
        int size= que.size();
        int val = size;
        ans = 0.0;
        while(size-->0){
            TreeNode rnode = que.removeFirst();
            ans += rnode.val;                    
            if(rnode.left!=null)
            que.addLast(rnode.left);
            if(rnode.right!=null)
            que.addLast(rnode.right);
        }
        list.add(ans/val);
    }
    return list;
}

}

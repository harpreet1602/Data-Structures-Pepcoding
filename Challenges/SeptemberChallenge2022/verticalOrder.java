public class verticalOrder{
    
    // 987. Vertical Order Traversal of a Binary Tree
//     tc O(n) sc O(n)
//     Apply DFS with priority queue of a class and assign the x and y coordinates accordingly
//     Make the prioriy queue in such a way that vertical order can be made
//     If same index is going on so one smallList
//     otherwise new smallList is made for new x index.
private class Point {
    int value;
    int x;
    int y;
    
    Point(int value,int x,int y){
        this.value = value;
        this.x = x;
        this.y = y;
    }
}
PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->{
    if(a.x!=b.x){
        return a.x-b.x;      //lowest x value
    } 
    else{
        if(a.y!=b.y){
            return b.y-a.y;   //higher y value
        }
        else{ 
            return a.value-b.value; // smaller normal value
        }
    }
});
public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> ans= new ArrayList<>();
    
    treeTraversal(root,0,0);
    Integer prevXInd = null;
    List<Integer> smallList = new ArrayList<>();
    while(pq.size()!=0){
        Point rpoint = pq.remove();
        
        if(prevXInd!=null && prevXInd!=rpoint.x){
            ans.add(smallList);
            smallList = new ArrayList<>();
        }
        smallList.add(rpoint.value);
        prevXInd = rpoint.x;
    }
    if(smallList.size()!=0){
        ans.add(smallList);
    }
    return ans;
}

private void treeTraversal(TreeNode root,int x,int y){
    if(root == null){
        return;
    }
    
    pq.add(new Point(root.val,x,y));
    treeTraversal(root.left,x-1,y-1);
    treeTraversal(root.right,x+1,y-1);
}
}
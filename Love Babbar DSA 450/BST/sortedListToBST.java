public class sortedListToBST{
    
// 109. Convert Sorted List to Binary Search Tree
// tc O(nlogn) sc O(logn) recursive space.
//     nlogn because n for finding the middle everytime and tree length goes till logn 
//     Find the middle node through fast and slow pointers
//     place end one node ahead so that start == end base case can be included for returning null => do dry run.
//     start to slow on the left hand side and slow.next to end on right hand side.
//     In the start also we are starting from head and end is null.
    
public TreeNode sortedListToBST1(ListNode head) {
    if(head == null){
        return null;
    }
    return sortedListToBST(head,null);
}
private TreeNode sortedListToBST1(ListNode start,ListNode end){
    ListNode slow, fast;
    slow = fast = start;
    
    if(start == end){
        return null;
    }
    while(fast!=end && fast.next!=end){
        slow = slow.next;
        fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(start,slow);
    root.right = sortedListToBST(slow.next,end);
    
    return root;
}
}
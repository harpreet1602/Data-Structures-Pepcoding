public class deleteNode{
    
    // 237. Delete Node in a Linked List
//     tc O(1) sc O(1)
//     so just copy the value of the next node to the current node
//     set the next of current node to the next of the next node.
//     done the purpose is acheived as it will appear like we have deleted the node to which the pointer was given
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}
}
public class delMidNode{
        // 2095. Delete the Middle Node of a Linked List
//     Brute 
//     O(2*n) => O(n) sc O(1)
//  Traverse the linked list and get the size and then traverse till its middle again to delete the node.   
    
//     Optimised
//     tc O(n) sc O(1)
//     prev slow pointer and fast pointer will be used to traverse the linkedlist
//     and when fast stops at its condition then change the pointers to delete the middle node.
public ListNode deleteMiddle(ListNode head) {
    if(head == null || head.next==null){
        return null;
    }
    
    ListNode prev,fast;
    fast = head;
    prev = new ListNode(-1);
    prev.next = head;
    while(fast!=null && fast.next!=null){
        fast = fast.next.next;
        prev = prev.next;
    }
    prev.next = prev.next.next;
    return head;
}
}
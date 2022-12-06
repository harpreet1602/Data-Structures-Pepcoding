public class middleNode{
    
    // 876. Middle of the Linked List
// tc O(n) sc O(1)
// Just fast and slow pointer game after analysing the case of odd and even length list.
public ListNode middleNode(ListNode head) {
    if(head == null || head.next == null){
        return head;
    }
    ListNode slow, fast;
    slow = fast = head;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
}
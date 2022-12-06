public class evenOdd{
    
    // 328. Odd Even Linked List
// tc O(n) sc O(1)
// Segregate the even index and odd index linkedlist separately and then join them together.
public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null || head.next.next == null){
        return head;
    }
    ListNode even=head.next, odd=head;
    ListNode evenhead = even;

    while(odd.next!=null && even.next!=null){
        odd.next = even.next;
        odd = odd.next;
        if(odd != null){
            even.next = odd.next;
            even = even.next;
        }
    }
    odd.next = evenhead;
    return head;
}
}
public class l001{
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    // 206. Reverse Linked List
public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null)
        return head;
    ListNode prev=null,curr=head,forw=head.next;
    while(forw!=null){
        curr.next=prev;
        prev=curr;
        curr=forw;
        forw=forw.next;
    }
    curr.next=prev;
    return curr;
}
}
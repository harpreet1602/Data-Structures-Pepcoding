public class reverseList2{

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
     // 92. Reverse Linked List II
//     tc O(n) sc O(1)
//     3 passes
//     2 passes to place the four pointers on their respective positions.
//    After that one pass to reverse the list in between start and end 
public ListNode reverseBetween1(ListNode head, int left, int right) {
    if(head == null || head.next == null){
        return head;
    }
    int i = 1,j=0;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev, start, end,forw;
    prev = end = dummy;
    start = forw = head;
    while(i<left){
        i++;
        prev = start;
        start = start.next;
    }
    while(j<right){
        j++;
        end = forw;
        forw = forw.next;
    }
    // ListNode newHead = 
    reverseNode(start,end);
    prev.next = end;
    start.next = forw;
    return dummy.next;
}

private void reverseNode(ListNode s, ListNode e){
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy,curr = s, forw;
    e.next = null;
    while(curr!=null){
        forw = curr.next;
        curr.next = prev;
        prev = curr;
        curr = forw;
    }
}
//     Optimised 
//     2 passes
//     one to get the start node and then run a loop to reverse then place the pointers.
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if(head == null || head.next == null){
        return head;
    }
    int i = 1,j=0;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev, start,pr,it,forw;
    prev = dummy;
    start = head;
    while(i<left){
        i++;
        prev = start;
        start = start.next;
    }
    pr = prev;
    it = start;
    
    for(j=left;j<=right;j++){
        forw = it.next;
        it.next = pr;
        pr = it;
        it = forw;
    }
    prev.next = pr;
    start.next = it;
    return dummy.next;
}
}
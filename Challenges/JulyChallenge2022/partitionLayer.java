public class paritionLayer{
        // 86. Partition List
//     tc O() sc O()
//     
//     Wrong solution,after segregating , keeps on going = > TLE
public ListNode partition1(ListNode head, int x) {
    if(head == null || head.next == null){
        return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy, curr = head,forw,tail=head;
    while(tail.next!=null){
        tail = tail.next;
    }
    while(curr!=null){
        forw = curr.next;
        if(curr.val>=x){
            prev.next = forw;
            curr.next = null;
            tail.next = curr;
            tail = curr;
        }else{
            prev = curr;
        }
        curr = forw;
    }
    return dummy.next;
}

// 86. Partition List
//     tc O(n) sc O(1)
//     Make the segragation like 0 and 1 in small and large values than x
// and return the appproapriate result.
public ListNode partition(ListNode head, int x) {
     if(head == null || head.next == null){
        return head;
    }
    ListNode small, large,s,l,curr = head;
    small = new ListNode(-1);
    large = new ListNode(-1);
    s = small;
    l = large;
    while(curr!=null){
        if(curr.val>=x){
            l.next = curr;
            l = curr;
        }else{
            s.next = curr;
            s = curr;
        }
        curr = curr.next;
    }
    l.next = null;
    s.next = large.next;
    return small.next;
}
}
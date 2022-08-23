public class palindromeLinked {
    
//     tc O(n) sc O(1)
//     find the mid and then reverse from its next node
//     and then simply check whether the two halves are equal or not
//     If you want the list back then again find the mid and reverse the list from its next node
public boolean isPalindrome(ListNode head) {
    ListNode slow,fast;
    slow = fast = head;
    while(fast.next!=null && fast.next.next!= null){
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode rhead = reverse(slow.next);
    slow = rhead;
    ListNode dummy = head;
    while(slow!=null){
        if(slow.val != dummy.val){
            return false;
        }
        slow = slow.next;
        dummy = dummy.next;
    }
    return true;
}
private ListNode reverse(ListNode head){
    ListNode prev = null,curr = head,forw;
    while(curr!=null){
        forw = curr.next;
        curr.next = prev;
        prev = curr;
        curr = forw;
    }
    return prev;
}
}

package LinkedList;

public class linkedListCycle2 {
    
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    //     142. Linked List Cycle II
    //     tc O(n) sc O(1)
    //     Slow and fast pointer approach will be used to detect the cycle and once the cycle is found.
    //    The distance from the point of meeting and from the start we will travel with two pointers one step at a time
    //     and now when they will meet that will be the start of the linkedlist cycle.
    //     Proof is also important=> coding decoded.
    //   slow => a+b
    //     fast => a+b+c+b= a+2b+c
    //    fast = 2*slow
    //     (a+2b+c) = 2*(a+b) 
        // => a=c
    //     Hence proved run pointer from a starting point and one from first meeting point.
    //     when they will meet that will be start of cycle.
        public ListNode detectCycle(ListNode head) {
            ListNode slow,fast;
            boolean cycle = false;
            slow = fast = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    cycle = true;
                    break;
                }
            }
            if(!cycle){
                return null;
            }
            
            fast = head;
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}

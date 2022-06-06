public class intersectionNode{
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
                 next = null;
             }
         }
//  160. Intersection of Two Linked Lists
//  tc O(m+n) sc O(1)
//     Link both the lists by traversing till the end of the first list to get the tail pointer
//     then attach tail's next as head of second list and call for detect cycle
//     if there is no cycle this means there is no intersection point
//     but if there is a cycle present then assign one of the pointer slow to the head 
//     go one by one slow will start from head and fast will start from the point it came out from the first loop
//     now when they will get equal that will be the intersection node.
//     Proof of this why it is happening will be done later.
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null){
        return null;
    }
    
    ListNode tail = headA;
    while(tail.next!=null){
        tail = tail.next;
    }
    tail.next = headB;
    ListNode ans = detectCycle(headA);
    tail.next = null;
    return ans;
}

private ListNode detectCycle(ListNode head){
    if(head == null || head.next == null){
        return null;
    }
    boolean isCycle = false;
    ListNode slow = head,fast = head;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
        
        if(slow == fast){
            isCycle = true;
            break;
        }
    }
    
    if(!isCycle){
        return null;
    }
    
    slow = head;
    
    while(slow!=fast){
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
}
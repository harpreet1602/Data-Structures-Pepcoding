public class linkedListRandom {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
// 382. Linked List Random Node
// tc O(n) sc O(1)
//     Reservoir sampling alogrithm is getting used here.
//     1*(1/2)*(2/3)*.......*(n/n-1) = 1/n
// rand.nextInt(i) = 0........i-1 random value
//     so with this algorithm, we will keep on traversing the linkedlist
//     and when our rand.nextInt(i) == i-1 randomly then we will store the current node's value in result.
//     Because of this every number has a equal possibility of coming out.
private ListNode head = null;
private Random rand = null;
public Solution(ListNode head) {
    this.head = head;
    rand = new Random();
}

public int getRandom() {
    int res = -1;
    ListNode curr = head;
    for(int i=1;curr!=null;i++){
        if(rand.nextInt(i) == i-1){
            res = curr.val;
        }
        curr = curr.next;
    }
    return res;
}
}

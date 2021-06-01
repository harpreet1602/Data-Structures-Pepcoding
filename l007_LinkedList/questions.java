public class questions {
 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//   public static void addLast(int data)
//   {
//         ListNode node=new ListNode();

        
//   }
  //leetcode 876
  public static ListNode middleNode(ListNode head) {
    ListNode slow=head;
    ListNode fast=head;
    while(fast!=null && fast.next!=null)
    {
            fast=fast.next.next;
            slow=slow.next;
    }
    return slow;
    }
    //leetcode 19
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr=head;
        int count=0;
        while(curr!=null)
        {
            count++;
        }
        int trav=1;
        curr=head;
        while(trav<count-n)
        {
            curr=curr.next;
        }
        ListNode main=curr.next;
        curr=main.next;
        main.next=null;
        return head;
    }
    //gfg 
    //https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
    ListNode divide(int N, ListNode head){
        // code here
        ListNode even=new ListNode(-1);
        ListNode ep=even;
        ListNode odd=new ListNode(-1);
        ListNode op=odd;
        ListNode curr=head;
        while(curr!=null)
        {
            if(curr.val%2==0)
            {
                ep.next=curr;
                ep=ep.next;
            }
            else
            {
                op.next=curr;
                op=op.next;
            }
            curr=curr.next;
        }
        ep.next=odd.next;
        head=even.next;
        op.next=null;
        return head;
    }
    //leetcode 83
    //delete duplicates in a sorted linked list
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode dummy=new ListNode(-101);
        ListNode dp=head;
        dummy.next=dp;
        ListNode curr=head.next;
        while(curr!=null)
        {
            if(dp.val!=curr.val)
            {
                dp.next=curr;
                dp=dp.next;
            }
            curr=curr.next;
        }
        dp.next=curr;
        return dummy.next;
    }
    //leetcode 21. merge two sorted linked lists.
    //   time O(n) and space O(1) and inplace
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
        {
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode dp=dummy,p1=l1,p2=l2;
        while(p1!=null && p2!=null)
        {
            if(p1.val<=p2.val)
            {
                dp.next=p1;
                dp=p1;
                p1=p1.next;
            }
            else
            {
                dp.next=p2;
                dp=p2;
                p2=p2.next;
            }
        }
        while(p1!=null)
        {
                dp.next=p1;
                dp=p1;
                p1=p1.next;
        }
        while(p2!=null)
        {
                dp.next=p2;
                dp=p2;
                p2=p2.next;
            
        }
        return dummy.next;
    }
    public static void main(String[] args)
    {

    }
}

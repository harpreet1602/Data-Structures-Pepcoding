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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)
            return null;
        ListNode curr=head;
        int count=0;
        while(curr!=null)
        {
            curr=curr.next;
            count++;
        }
        int trav=1;
        curr=head;
        if(count-n==0)
        {
            ListNode p=head;
            head=head.next;
            p.next=null;
            return head;
        }
        while(trav<count-n)
        {
            curr=curr.next;
            trav++;
        }
        ListNode main=curr.next;
        curr.next=main.next;
        main.next=null;
        return head;
    }
    //leetcode 19 could you do in one pass ?
    public int getlength(ListNode h)
    {
        ListNode curr=h;
        int count=0;
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
        return count;
    }
       public ListNode removeNthFromEnd(ListNode head, int n)
       {
           if(head==null || head.next==null)
           {
               return null;
           }
           if(getlength(head)-n==0)
           {
               ListNode t=head;
               head=head.next;
               t.next=null;
               return head;
           }
           ListNode slow,fast;
           slow=fast=head;
           
          for(int i=0;i<n;i++)
           {
               // if(fast!=null)
               fast=fast.next;
           }
           while(fast!=null &&fast.next!=null)
           {
               slow=slow.next;
               fast=fast.next;
           }
           ListNode p=slow.next;
           slow.next=p.next;
           p.next=null;
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
    public ListNode mergeTwoSortedLists(ListNode l1,ListNode l2)
    {
        if(l1==null || l2==null)
        return l1!=null?l1:l2;
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy,c1=l1,c2=l2;
        while(c1!=null && c2!=null)
        {
            if(c1.val<=c2.val)
            {
                prev.next=c1;
                c1=c1.next;
            }else
            {
                prev.next=c2;
                c2=c2.next;
            }
            prev=prev.next;
        }
        prev.next=c1!=null?c1:c2;
        return dummy.next;
    }
    public ListNode midNode(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null &&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //leetcode 148 Merge sort the linked list
    public ListNode sortList(ListNode head) {
        
        if(head==null ||head.next==null)
        {
            return head;
        }
        ListNode mid=midNode(head);
        ListNode nhead=mid.next;
        mid.next=null;
        ListNode leftSortedList=sortList(head);
        ListNode rightSortedList=sortList(nhead);
        return mergeTwoSortedLists(leftSortedList,rightSortedList);
    }
    public static void main(String[] args)
    {

    }
}

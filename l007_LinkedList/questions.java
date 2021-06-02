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
    public ListNode removeNthFromEndOpt(ListNode head, int n)
    {
        if(head==null || head.next==null)
        {
            return null;
        }
        // if(getlength(head)-n==0)
        // {
        //     ListNode t=head;
        //     head=head.next;
        //     t.next=null;
        //     return head;
        // }
        ListNode slow,fast;
        slow=fast=head;
        
       for(int i=0;i<n;i++)
        {
            // if(fast!=null)
            fast=fast.next;
        }
        if(fast==null)
        {
             ListNode t=head;
            head=head.next;
            t.next=null;
            return head;
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
    //leetcode 234 is a linked list a pallindrome
    //leetcode 206 reverse a linked list 
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null,curr=head;
        while(curr!=null)
        {
            ListNode forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid=midNode(head);
        ListNode nhead=mid.next;
        mid.next=null;
        nhead=reverse(nhead);
        ListNode p1=head,p2=nhead;
        boolean ispalindrome=true;
        while(p2!=null)
        {
            if(p1.val!=p2.val)
            {
                ispalindrome=false;
                break;
            }
                p1=p1.next;
                p2=p2.next;
        }
        nhead=reverse(nhead);
        mid.next=nhead;
        return ispalindrome;
    }
    //leetcode 234 Recursive is linkedlist a pallindrome using static variable
    ListNode ptr;
    public boolean isPalindromeR(ListNode head)
    {
        ptr=head;
       return isPalindromeRecursive(head);
    }
    public boolean isPalindromeRecursive(ListNode node)
    {
        if(node==null)
        return true;
        
        if(!isPalindromeRecursive(node.next))
        {
            return false;
        }
        if(ptr.val!=node.val)
        {
            return false;
        }
        ptr=ptr.next;
        return true;
    }
    //leetcode 206 reverse a linked list recursively
    public ListNode reverseListRecursive(ListNode curr) {
        if(curr==null || curr.next==null)
            return curr;
         ListNode node=reverseListRecursive(curr.next);
         node.next=curr;
         return curr;
     }
    public ListNode traverse(ListNode curr)
    {
        while(curr!=null &&curr.next!=null)
        {
            curr=curr.next;
        }
        return curr;
    }
     public ListNode reverseList(ListNode head) {
         if(head==null || head.next==null)
             return head;
         ListNode nhead=traverse(head);
        ListNode curr=reverseListRecursive(head);
         curr.next=null;
             return nhead;
     } 
    public static void main(String[] args)
    {

    }
}

public class l001{
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int data){
            this.val = data;
        }
    }

    // mid of ll
    // fast.next null hua to odd ka mid fast.next.next null hua to first middle mil jayega    
    // fast null hogya ho ya fast.next null ho to return second mid hoga
    public static ListNode midNode(ListNode head){
        ListNode slow, fast;
        if(head== null)
        return head;
        slow = fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
    
        return slow;
    }

    // portal reverse ll
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
        return head;
        
        ListNode first,second, third;
        first = null;
        second = head;
        third = second.next;
        while(second!=null){
            second.next=first;
            first=second;
            second=third;
            if(third!=null)
            third=third.next;
        }
        return first;
    }

    // portal Palindrome Linkedlist 
    
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        return true;
        
        ListNode mid = midNode(head);
        ListNode newhead = mid.next;
        mid.next=null;
        newhead = reverse(newhead);
        
        ListNode node1,node2;
        node1=head;
        node2=newhead;
        boolean res=true;
        while(node1!=null && node2!=null){
            if(node1.val != node2.val)
            {
                res=false;
                break;
            }
            node1=node1.next;
            node2=node2.next;
        }
        newhead = reverse(newhead);
        mid.next=newhead;
        return res;
    }

    

    public static void fold(ListNode head) {
        ListNode mid = midNode(head);
     ListNode nhead = mid.next;
     mid.next=null;
     nhead = reverse(nhead);

     ListNode c1,c2,f1,f2;
     c1=head;
     c2=nhead;
     while(c2!=null){
         f1=c1.next;
         f2=c2.next;
         c1.next=c2;
         c2.next=f1;
         c1=f1;
         c2=f2;
     }
  
 }


// my approach 
 public static void unfold(ListNode head) {
    if(head == null || head.next == null){
        return;
    }    
ListNode c1,c2,nhead;     
c1= head;
nhead = c2 = head.next;
while(c2!=null && c2.next!=null){
    c1.next = c2.next;
    c1 = c1.next;
    c2.next = c1.next;
    c2 = c2.next; 
} 

nhead = reverse(nhead);
c1.next = nhead;
}

// sir approach


    public static void unfold1(ListNode head) {
        ListNode d1 = new ListNode(-1), d2 = new ListNode(-1), c1=d1, c2=d2, c=head;
        
        while(c!=null){
            c1.next = c;
            c2.next = c.next;
            c1=c1.next;
            c2=c2.next;
            c = c.next;
            if(c!=null)
            c = c.next;
        }
    ListNode nhead = reverse(d2.next);
    c1.next = nhead;
        head = d1.next;
    }






    public static void main(String[] args){

    }
}
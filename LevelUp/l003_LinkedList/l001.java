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

    // 143. Reorder List

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


    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), c1 = l1, c2 = l2, c = head;
        while(c1!=null && c2!=null){
            if(c1.val<=c2.val){
                c.next=c1;
                c1=c1.next;
            }else{
                c.next=c2;
                c2=c2.next;
            }
            c=c.next;
        }        
        if(c1!=null){
            c.next=c1;
        }
        if(c2!=null){
            c.next=c2;
        }
        return head.next;
        
        
    }

    public static int size(ListNode head){
        ListNode node = head;
        int count=0;
        while(node!=null){
            node=node.next;
            count++;
        }
        return count;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        if(size==n){
            ListNode rnode = head;
            head = head.next;
            rnode.next=null;
                }
        else{
            int count = n;
            ListNode slow,fast;
            slow=fast=head;
            while(count-->0){
                fast=fast.next;
            }
            while(fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }
            ListNode rnode = slow.next;
            slow.next=rnode.next;
            rnode.next=null;
            
        }
        return head;
    
      }

      public static ListNode segregate01(ListNode head) {
        
        if(head == null || head.next==null){
            return head;
        }
        
        ListNode zero = new ListNode(-1), one = new ListNode(-1), zp = zero, op = one, curr =head;
        
        while(curr!=null){
            if(curr.val==0){
                zp.next=curr;
                zp=zp.next;
            }
            else{
                op.next=curr;
                op=op.next;
            }
            curr=curr.next;
        }
        
        zp.next=op.next=null;
        zp.next=one.next;
        return zero.next;
        
        
    }    

    
    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next==null){
       return head;
   }
   
   ListNode zero = new ListNode(-1), one = new ListNode(-1), two = new ListNode(-1), zp = zero, op = one, tp =two, curr =head;
   
   while(curr!=null){
       if(curr.val==0){
           zp.next=curr;
           zp=zp.next;
       }
       else if(curr.val==1){
           op.next=curr;
           op=op.next;
       }
       else{
           tp.next=curr;
           tp=tp.next;
       }
       curr=curr.next;
   }
   
   zp.next=op.next=tp.next=null;
   op.next=two.next;
   zp.next=one.next;
   return zero.next;

}

public static ListNode segregateEvenOdd(ListNode head) {
    if( head == null || head.next ==null){
        return head;
    }
    
    ListNode even  = new ListNode(-1), odd = new ListNode(-1), ep =even, op =odd, curr =head;
    while(curr!=null){
        if((curr.val & 1)==0)
        {
            ep.next = curr;
            ep = ep.next;
        }
        else
        {
            op.next = curr;
            op = op.next;
            
        }
        curr =curr.next;
    }
    ep.next = op.next =null;
    ep.next=odd.next;
    return even.next;
    
    
}


public static ListNode mergeSort(ListNode head) {
    if(head == null || head.next == null){
        return head;
    }
    
    ListNode mid = midNode(head);
    ListNode nhead = mid.next;
    mid.next = null;
    
    return mergeTwoLists(mergeSort(head),mergeSort(nhead));
}

// 23. Merge k Sorted Lists
// portal as well
public static ListNode mergeKLists(ListNode[] lists, int si, int ei){
    if(si == ei){
        return lists[si];
    }
    
    int mid = (si + ei )/2;
    ListNode leftList = mergeKLists(lists,si,mid);
    ListNode rightList = mergeKLists(lists,mid+1,ei);
    
    return mergeTwoLists(leftList,rightList);
}
public static ListNode mergeKLists(ListNode[] lists) {
   if(lists.length == 0){
       return null;
   } 
   
   return mergeKLists(lists, 0 , lists.length-1);
}



public static void printList(ListNode node) {
    while (node != null) {
        System.out.print(node.val + " ");
        node = node.next;
    }
}



public static ListNode th = null, tt =null;
    
public static void addFirst(ListNode node){
    
    if(th == null){
        th = node;
        tt=node;
    }
    else{
        node.next = th;
        th = node;
    }
}

public static ListNode reverseInKGroup(ListNode head, int k) {
    if(head == null || head.next == null || k<=1){
        return head;
    }
    
    ListNode curr =head, oh = null ,ot = null;
    int len = size(head);
    while(len >= k){
        int size = k;
        while(size-->0){
            ListNode forw = curr.next;
            curr.next=null;
            addFirst(curr); 
            curr=forw;
        }
        if(oh== null && ot == null){
            oh = th;
            ot = tt;
        }
        else{
            ot.next = th;
            ot = tt;
        }
        
        th = null;
        tt = null;
        len-=k;
    }
    ot.next = curr;
    return oh;
}




    public static void main(String[] args){

    }
}
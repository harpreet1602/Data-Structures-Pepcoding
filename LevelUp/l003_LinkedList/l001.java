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

// sir ki approach ko analyse karo

public static ListNode reverseInRange(ListNode head, int n, int m) {
    if (head == null || head.next == null || n == m)
        return head;

    ListNode dummy = new ListNode(-1), prev = dummy, curr = head;
    prev.next = head;
    int i = 1;
    while (i <= m) {
        while (i >= n && i <= m) {
            ListNode forw = curr.next;
            curr.next = null;
            addFirstNode(curr);
            curr = forw;
            i++;
        }

        if (i > m) {
            prev.next = th;
            tt.next = curr;
            break;
        }

        i++;
        prev = curr;
        curr = curr.next;
    }

    return dummy.next;
}
// my solution
    
public static ListNode reverseInRange2(ListNode head, int n, int m) {
    if(head ==null ||head.next==null){
        return head;
    }
    int i = 1;
    ListNode prev=null,curr=head,forw=head.next;
    while(curr!=null && i<=m){
        if(i<n){
        prev=curr;
        curr=forw;
        forw=forw.next;
        }
        else if(i>=n && i<=m){
            addFirst(curr);
            curr=forw;
            forw=forw.next;
        }
        i++;
    }
    if(prev==null){
        head=th;
    }
    else{
    prev.next = th;
    }
    tt.next=curr;
    return head;
}




public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1==null || l2==null) return l1==null?l2:l1;
    
    ListNode dummy = new ListNode(-1), prev = dummy, c1 =reverse(l1), c2 =reverse(l2);
    
    int carry=0;
    while(c1!=null || c2!=null){
        int sum = ((c1==null)?0:c1.val) + ((c2==null)?0:c2.val) + carry;
        int digit = sum%10;
        carry = sum/10;
        ListNode node = new ListNode(digit);
        prev.next=node;
        prev=prev.next;
        
        if(c1!=null)
        c1=c1.next;
        if(c2!=null)
        c2=c2.next;
    }
    dummy.next = reverse(dummy.next);
    return dummy.next;
}

        
    
    public static int getLength(ListNode head){
        ListNode node = head;
        int count=0;
        while(node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
    
    public static boolean isBigger(ListNode l1,ListNode l2){
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        if(len1>len2){
            return true;
        }
        else if(len1<len2){
            return false;
        }
        ListNode c1 = l1, c2 =l2;
        while(c1!=null){
            if(c1.val>c2.val) return true;
            else if(c1.val<c2.val) return false;
            c1=c1.next;
            c2=c2.next;
        }
        return true;
    }

  public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
    if(l1==null || l2==null) return l1==null?l2:l1;
    ListNode c1 =null, c2 =null;
          boolean res = isBigger(l1,l2);
          if(!res){
              c1=reverse(l2);
              c2=reverse(l1);
          }
          else{
              c1=reverse(l1);
              c2=reverse(l2);
          }
          
          ListNode dummy = new ListNode(-1), prev = dummy;
          
          int borrow=0;
          while(c1!=null || c2!=null || borrow!=0){
              int diff = ((c1==null)?0:c1.val) - ((c2==null)?0:c2.val) + borrow;
              if(diff<0){
                  borrow=-1;
                  diff+=10;
              }
              else{
                  borrow=0;
              }
              int digit = diff%10;
              ListNode node = new ListNode(digit);
              prev.next=node;
              prev=prev.next;
              
              if(c1!=null)
              c1=c1.next;
              if(c2!=null)
              c2=c2.next;
          }
          ListNode v1 = reverse(dummy.next);
          
          ListNode prev1=dummy;
          prev1.next=null;
          ListNode c =v1;
          while(c!=null){
              if(c.val!=0){
                  dummy.next = c;
                  break;
              }
              c=c.next;
          }
          
          
          return dummy.next!=null?dummy.next:new ListNode(0);
  }


// link nhi todhe
public static ListNode removeDuplicates1(ListNode head) {
    if(head == null || head.next==null){
        return head;
    }
    ListNode curr = head, forw=head.next;
    while(curr!=null){
        if(forw!=null &&curr.val==forw.val){
            forw=forw.next;
        }
        else{
            curr.next=forw;
            curr=curr.next;
            if(forw!=null)
            forw=forw.next;
        }
    }
    return head;
}

// link will be broken


public static ListNode removeDuplicates(ListNode head) {
    if(head == null || head.next==null){
        return head;
    }
    
    
    
    ListNode prev= head,curr=head.next;
    while(curr!=null){
        while(curr!=null && prev.val == curr.val){
            ListNode forw = curr.next;
            curr.next = null;
            curr=forw;
        }
        
        prev.next = curr;
        prev = prev.next;
        if(curr!=null){
            curr=curr.next;
        }
    }
    return head;
}
// 141. Linked List Cycle
     public boolean hasCycle(ListNode head) {
        if(head==null || head.next == null)
            return false;
        ListNode slow, fast;
        slow = fast = head;
        while(fast!=null){
            slow= slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
            
            if(slow==fast)
            {
                return true;
            }
        }
        return false;
    }


    // 142. Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        boolean flag=false;
          if(head==null || head.next == null)
            return null;
        ListNode slow, fast;
        slow = fast = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast=fast.next;
                fast=fast.next;
            
            if(slow==fast)
            {
                flag=true;
                break;
            }
        }
        if(!flag)
            return null;
        
        slow = head;
        
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    // 160. Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode tail = headA;
        while(tail.next!=null){
            tail=tail.next;    
        }
        
        tail.next=headB;
        ListNode ans = detectCycle(headA);
        tail.next=null;
        return ans;
    }

    


    public static void main(String[] args){

    }
}
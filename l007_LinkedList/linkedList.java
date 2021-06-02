public class linkedList { 
       public class Node{
           int data;      // int data=0;
           Node next;     // Node next=null;
            Node()
            {
                data=0;
                next=null;
            }
            Node(int data)
            {
                this.data=data;
            }
        }
        private Node head=null;
        private Node tail=null;
        private int size=0;
        public int size()
        {
            return this.size;
        }
        public boolean isEmpty()
        {
            return this.size==0;
        }
        private void addFirstNode(Node node)
        {
            if(this.size==0)
            {
                this.head=this.tail=node;
            }
            else{
                node.next=this.head;
                this.head=node;
            }
            this.size++;
        }
        public void addFirst(int data)
        {
            Node node=new Node(data);
            addFirstNode(node);
        }
        private void addLastNode(Node node)
        {
            if(this.size==0)
            {
                this.head=this.tail=node;
            }
            else{
                this.tail.next=node;
                this.tail=node;
            }
            this.size++;
        }
        public void addLast(int data)
        {
            Node node=new Node(data);
            addLastNode(node);
        }
        private void addNodeAt(Node node,int idx)
        {
            Node prev=getNodeAt(idx-1);
            if(idx==0)
            {
                node.next=this.head;
                this.head=node;
            }
            node.next=prev.next;
            prev.next=node;
            this.size++;
        }
        public void addAt(int idx,int data)
        {
            Node node=new Node(data);
            addNodeAt(node,idx);
        }
        //.................................Add Done let us do remove
        private Node removeFirstNode()
        {
            Node node=this.head;
            if(this.size==1)
            {
                this.head=this.tail=null;
            }
            else{
                this.head=this.head.next;
                node.next=null;
            }
            this.size--;
            return node;
        }
        public int removeFirst(){
            if(this.size==0)
            return -1;
            Node node=removeFirstNode();
            return node.data;
        }
        private Node removeLastNode()
        {
            Node prev=getNodeAt(this.size-2);
            Node curr=this.tail;
            prev.next=null;
            this.tail=prev;
            return curr;
        }
        public int removeLast()
        {
            if(this.size==0)
            return -1;
            Node node=removeLastNode();
            this.size--;
            return node.data;
        }
        private Node removeNodeAt(int idx)
        {
            Node prev=getNodeAt(idx-1);
            Node curr=getNodeAt(idx);
            if(idx==0)
            {
                this.head=curr.next;
            }
            if(idx==this.size-1)
            {
                this.tail=prev;
            }
            if(idx!=0)
            prev.next=curr.next;
            curr.next=null;
            this.size--;
            return curr;   
        }
        public int removeAt(int idx)
        {
            if(this.size==0)
            return -1;
            Node node=removeNodeAt(idx);
            return node.data;
        }
        //=======================================

        private Node getFirstNode()
        {
            return this.head;
        }
        public int getFirst()
        {
            if(this.size==0)
            return -1;
            Node node=getFirstNode();
            return node.data;
        }
        private Node getLastNode()
        {
            return this.tail;
        }
        public int getLast()
        {
            if(this.size==0)
            return -1;
            return getLastNode().data;
        }
        private Node getNodeAt(int idx)
        {
            Node curr=this.head;
            while(idx-->0)
            {
                curr=curr.next;
            }
            return curr;
        }
        public int getAt(int idx)
        {
            if(idx<0 && idx>=this.size)
            return -1;
            return getNodeAt(idx).data;
        }
        //=====================Questions=============================

        //odd even nodes in Linked list
        public void oddEven(){
        
            if(head==null || head.next==null)
            return;
            Node odd=new Node(-1);
            Node op=odd;
            Node even=new Node(-1);
            Node ep=even;
            Node curr=this.head;
            while(curr!=null)
            {
                if(curr.data%2==0)
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
            op.next=even.next;
            this.head=odd.next;
            ep.next=null;
            if(even.next!=null)
            this.tail=ep;
            else
            this.tail=op;
         }
         //remove duplicates in a sorted ll
         public void removeDuplicates(){
            // write your code here
            if(head==null && head.next==null)
            return;
            Node dummy=new Node(-1);
            Node dp=this.head;
            Node curr=this.head.next;
            dummy.next=dp;
            while(curr!=null)
            {
              if(dp.data!=curr.data)
              {
                  dp.next=curr;
                  dp=curr;
              }
              curr=curr.next;
            }
            dp.next=curr;
            this.head=dummy.next;
          }
          //reverse a linked list
          public void reversePI(){
            // write your code here
              if(head==null || head.next==null)
              return;
              Node prev=null;
              Node curr=this.head;
              while(curr!=null)
              {   
                  Node forward=curr.next;
                  curr.next=prev;
                  prev=curr;
                  curr=forward;
              }
              tail=this.head;
              this.head=prev;
          }
          
    //Kth node from the end
    //Not optimized , brute force
    public int kthFromLast1(int k){
        // write your code here
        if(this.head==null)
        return -1;
        int len=getlength(this.head);
        Node curr=this.head;
        int diff=(len-k-1);
        while(diff-->0)
        {
            curr=curr.next;
        }
        return curr.data;
      }
      //iterative,O(n) single traversal,cannot use size directly or indirectly
      public int kthFromLast(int k)
      {
          Node prev,curr;
          prev=curr=this.head;
          int i=0;
          while(i<k)
          {
              curr=curr.next;
              i++;            
          }
          while(curr.next!=null)
          {
              curr=curr.next;
              prev=prev.next;
          }
          return prev.data;
      }
          //add two linked list
          public static Node reverse(Node head)
          {
              if(head==null || head.next==null)
              return head;
              Node prev=null;
              Node curr=head;
              while(curr!=null)
              {
                  Node forward=curr.next;
                  curr.next=prev;
                  prev=curr;
                  curr=forward;
              }
              return prev;
          }

          public static Node addTwoNumbers(Node l1, Node l2) {
              l1=reverse(l1);
              l2=reverse(l2);
              Node dummy=new Node(-1);
              Node p=dummy,first=l1,second=l2;
              int carry=0;
              while(first!=null || second!=null || carry!=0)
              {
                  int sum=((first!=null)?first.data:0) + ((second!=null)?second.data:0) +carry;
                  carry=sum/10;
                  sum%=10;
                  p.next=new Node(sum);
                  p=p.next;
                  if(first!=null)
                  first=first.next;
                  if(second!=null)
                  second=second.next;
              }
              Node head=dummy.next;
              head=reverse(head);
              return head;
          }
          //add two lists using recursion
          public static int addTwoListsRecursion(Node first,int s1,Node second,int s2,linkedList ans)
          {
              
              int carry=0;
              if(first==null && second==null) 
              {
              return 0;
              }
              else if(s1>s2)
              {
                  carry=addTwoListsRecursion(first.next,--s1,second,s2,ans);
                  int sum=first.data+carry;
                  carry=sum/10;
                  sum=sum%10;
                  ans.addFirst(sum);
              }
              else
              {
                  carry=addTwoListsRecursion(first.next,--s1,second.next,--s2,ans);
                  int sum=first.data+carry+second.data;
                  carry=sum/10;
                  sum=sum%10;
                  ans.addFirst(sum);
              }
              return carry;
          }
          public static linkedList addTwoLists(linkedList one, linkedList two) {
            // write your code here
            linkedList ans=new linkedList();
            if(one.size()<two.size())
            {
                linkedList temp=one;
                one=two;
                two=temp;
            }
            int carry=addTwoListsRecursion(one.head,one.size(),two.head,two.size(),ans);
            if(carry!=0)
            ans.addFirst(carry);
            return ans;
          }
            //Recursive reverse the linked list
    private void reversePRHelper(Node node){
        // write your code here
        if(node.next==null)
        {
            return;
        }
        reversePRHelper(node.next);
        //node.next.next=node;
        Node forw=node.next;
        forw.next=node;
      }
  
      public void reversePR(){
        // write your code here
        reversePRHelper(this.head);
        this.head.next=null;
        Node temp=this.head;
        this.head=this.tail;
        this.tail=temp;
      }
      //recursive display the reverse linked list only without reversing it
      private void displayReverseHelper(Node node){
        // write your code here
        if(node==null)
        return;
        displayReverseHelper(node.next);
        System.out.print(node.data+" ");
      }
  
      public void displayReverse(){
        displayReverseHelper(head);
        System.out.println();
      }
      //is linkedlist a pallindrome
          public Node midNode(Node head)
          {
              Node slow=head;
              Node fast=head;
              while(fast.next!=null &&fast.next.next!=null)
              {
                  fast=fast.next.next;
                  slow=slow.next;
              }
              return slow;
          }
          public boolean IsPalindrome() {
            // write your code here
            Node mid=midNode(this.head);
            Node nhead=mid.next;
            mid.next=null;
            nhead=reverse(nhead);
                Node p1=head;
                Node p2=nhead;
                boolean flag=true;
                while(p2!=null)
                {
                    if(p1.data!=p2.data)
                    {
                        flag=false;
                        break;
                    }
                    p1=p1.next;
                    p2=p2.next;
                }
                nhead=reverse(nhead);
                mid.next=nhead;
                return flag;
          }
          //is linkedlist a pallindrome by recursion
          Node ptr;
          private boolean IsPalindromeRecursive(Node curr)
          {
              if(curr==null)
              return true;
              
              if(!IsPalindromeRecursive(curr.next))
              return false;
      
              if(ptr.data!=curr.data)
              return false;
              
              ptr=ptr.next;
              return true;
          }
          public boolean IsPalindromeRecursive()
          {
              ptr=this.head;
              return IsPalindromeRecursive(this.head);
          }
          //intersection of a linked list
        
    private static int getlength(Node start)
    {
        Node node=start;
        int count=0;
        while(node!=null)
        {
            node=node.next;
            count++;
        }
        return count;
    }
    private static int findIntersection(Node first,Node second)
    {
        int a=getlength(first);
        int b=getlength(second);
        Node biggerListHead=a>b?first:second;
        Node smallerListHead=a<b?first:second;
        int diff=Math.abs(a-b);
        while(diff-->0)
        {
            biggerListHead=biggerListHead.next;
        }
        while(biggerListHead!=smallerListHead)
        {
            biggerListHead=biggerListHead.next;
            smallerListHead=smallerListHead.next;
        }
        return smallerListHead!=null?smallerListHead.data:-1;
    }
    public static int findIntersection(linkedList one, linkedList two){
      // write your code here
      return findIntersection(one.head,two.head);
    }
    

    }

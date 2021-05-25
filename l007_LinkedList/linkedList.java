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
        // private Node removeLastNode()
        // {
            
        // }
        // public int removeLast()
        // {
        //     if(this.size==0)
        //     return -1;
        //     Node node=removeLastNode();
        //     return node.data;
        // }
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
    }

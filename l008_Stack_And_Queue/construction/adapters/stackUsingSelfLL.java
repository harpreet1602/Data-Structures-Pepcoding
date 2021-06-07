package adapters;
import java.util.LinkedList;
public class stackUsingSelfLL {
    public static class stack{
        private class Node{
            int data;
            Node next;
            Node(int data)
            {   
                this.data=data;
            }
        }
        private stack head=null;
        private stack tail=null;
        private int size=0;
        public int size(){
            return this.size;
        }
        public boolean isEmpty(){
            return this.size==0;
        }
        private void addFirst(int data){
            Node node=new Node(data);
            if(this.head==null)
            {
                this.head=node;
            }
            node.next=this.head;
            this.head=node;
        }

    }   
    public static void main(String[] args)
    {

    } 
}

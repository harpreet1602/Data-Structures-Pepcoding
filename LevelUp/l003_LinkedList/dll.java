import java.util.*;
public class dll {
  public static Scanner scn =new Scanner(System.in);
  public static class DoublyLinkedList {
    private class Node {
      int data = 0;
      Node prev = null;
      Node next = null;

      Node(int data) {
        this.data = data;
      }

    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node curr = this.head;
      sb.append("[");
      while (curr != null) {
        sb.append(curr.data);
        if (curr.next != null)
          sb.append(", ");
          curr = curr.next;
      }
      sb.append("]");
      return sb.toString();
    }
    // Exceptions
    private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
      if (index < leftRange || index > rightRange) {
        System.out.print("IndexIsInValid: ");
        return true;
      }
      return false;
    }

    // BasicFunctions
    public int size() {
      return this.size;
    }

    public boolean isEmpty() {
      return this.size == 0;
    }

    // InsertFunctions
    private void insertFirstNode(Node node) {
      if (this.size == 0)
        this.head = this.tail = node;
      else {
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
      }
      this.size++;
    }

    public void insertFirst(int val) {
      Node node = new Node(val);
      insertFirstNode(node);
    }

    private void insertLastNode(Node node) {
      if (this.size == 0)
        this.head = this.tail = node;
      else {
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
      }
      this.size++;
    }

    public void insertLast(int val) {
      Node node = new Node(val);
      insertLastNode(node);
    }
    private void insertAtNode(Node newnode, int index, int data)
	{
		// Your code here
		if(index == 0)
        insertFirst(data);
        else if(index==this.size)
        insertLast(data);
        else
        {
	   Node forw = this.head;
	   int count=0;
	    while(count<index)
	    {
	        count++;
	        forw=forw.next;
	    }
	    Node curr=forw.prev;
		newnode.next = forw;
		forw.prev = newnode;
		newnode.prev = curr;
		curr.next = newnode;
		this.size++;
        }
	}
    
    public void insertAt(int index, int data) {
        if(indexIsInvalidException(index, 0, this.size) == true)
        {
            System.out.println(-1);
            return;
        }
        else{
            Node node = new Node(data);
            insertAtNode(node,index,data);    
        }
    }
}
    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        int ch=5;
        do{
         System.out.println();
         System.out.println("Menu");
         System.out.println("1.Insert at the beginning");
         System.out.println("2.Insert at the last");
         System.out.println("3.Insert at an index");
         System.out.println("4.Display the Linked List");
         System.out.println("5.Exit");
         ch = scn.nextInt();
         switch(ch){
             case 1:
             System.out.print("Enter the element: ");
             dll.insertFirst(scn.nextInt());
             break;
             case 2:
             System.out.print("Enter the element: ");
             dll.insertLast(scn.nextInt());
             break;
             case 3:
             System.out.print("Enter the index and the element: ");
             dll.insertAt(scn.nextInt(),scn.nextInt());
             break;
             case 4:
             System.out.println(dll);
             break;
             default:
             System.exit(0);
         }
        }while(true);
    }
}

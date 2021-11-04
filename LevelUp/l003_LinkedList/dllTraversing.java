import java.util.Scanner;
public class dllTraversing {
public static Scanner scn = new Scanner(System.in);

  public static class dll {
    private static class Node {
      int data;
      Node next;
      Node prev;

      Node(int d) {
        data = d;
        next = prev = null;
      }
    }

    private Node head = null;

    
    public int size() {
        Node curr = head;
        int count = 0;
        while (curr != null) {
          count++;
          curr = curr.next;
        }
        return count;
      }

    // insertion
    private void insertFirstNode(Node node) {
      int size = size();
      if (size == 0)
        this.head = node;
      else {
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
      }
    }

    public void insertFirst(int val) {
      Node node = new Node(val);
      insertFirstNode(node);
    }


    public void forwardTraversal(){
        if(this.head == null){
            System.out.println("Underflow");
            return;
        }
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    
    public void reverseTraversal(){
        if(this.head == null){
            System.out.println("Underflow");
            return;
        }
        Node curr = head;
        while(curr.next!=null){
            curr=curr.next;
        }
        while(curr!=null){            
            System.out.print(curr.data+" ");
            curr = curr.prev;
        }
        System.out.println();
    }
    }

    public static void main(String[] args) {
        dll d = new dll();
        int ch = 4;
        do {
          System.out.println();
          System.out.println("Menu");
          System.out.println("1.Forward Traversal");
          System.out.println("2.Reverse Traversal");
          System.out.println("3.Insert at the beginning");
          System.out.println("4.Exit");
          ch = scn.nextInt();
          switch (ch) {
          case 1:
            System.out.print("List is: ");
            d.forwardTraversal();
            break;
          case 2:
            System.out.print("List is: ");
            d.reverseTraversal();
            break;
          case 3:
            System.out.print("Enter the element: ");
            d.insertFirst(scn.nextInt());
            break;
          default:
            System.exit(0);
          }
        } while (true);
      }
}

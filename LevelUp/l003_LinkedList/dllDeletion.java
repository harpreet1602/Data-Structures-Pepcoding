import java.util.Scanner;

public class dllDeletion {
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

    // Exceptions
    private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
      if (index < leftRange || index > rightRange) {
        System.out.print("IndexIsInValid: ");
        return true;
      }
      return false;
    }

    // display
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

    public int size() {
      Node curr = head;
      int count = 0;
      while (curr != null) {
        count++;
        curr = curr.next;
      }
      return count;
    }

    // function returns the head of the linkedlist
    public int deleteAtStarting() {
      if (head == null) {
        System.out.println("Underflow");
        return -1;
      }
      Node curr = head;
      head = head.next;
      if(head!=null)
      head.prev = null;
      curr.next = null;
      return curr.data;
    }

    public int deleteAtEnding() {
      if (head == null) {
        System.out.println("Underflow");
        return -1;
      }

      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      Node prev = curr.prev;
      prev.next = null;
      curr.prev = null;
      return curr.data;
    }

    public int deleteNode(int x) {
      // Your code here
      if (head == null) {
        System.out.println("Underflow");
        return -1;
      }

      int size = size();
      if (indexIsInvalidException(x, 1, size)) {
        return -1;
      }

      if (x == 1) {
        return deleteAtStarting();
      } else if (x == size) {
        return deleteAtEnding();
      } else {
        Node curr = head;
        while (x-- > 1) {
          curr = curr.next;
        }
        Node prev = curr.prev;
        Node forw = curr.next;
        prev.next = forw;
        forw.prev = prev;
        curr.next = curr.prev = null;
        return curr.data;
      }
    }
  }

  public static void main(String[] args) {
    dll d = new dll();
    int ch = 6;
    do {
      System.out.println();
      System.out.println("Menu");
      System.out.println("1.Delete at the beginning");
      System.out.println("2.Delete at the last");
      System.out.println("3.Delete at an index");
      System.out.println("4.Display the Linked List");
      System.out.println("5.Insert at the beginning");
      System.out.println("6.Exit");
      ch = scn.nextInt();
      switch (ch) {
      case 1:
        System.out.println(d.deleteAtStarting() + " deleted");
        break;
      case 2:
        System.out.println(d.deleteAtEnding() + " deleted");
        break;
      case 3:
        System.out.print("Enter the index: ");
        System.out.println(d.deleteNode(scn.nextInt()) + " deleted");
        break;
      case 4:
        System.out.println(d);
        break;
      case 5:
        System.out.print("Enter the element: ");
        d.insertFirst(scn.nextInt());
        break;
      default:
        System.exit(0);
      }
    } while (true);
  }

}

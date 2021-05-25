public class client {
    public static void main(String[] args)
    {
        linkedList ll=new linkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addFirst(30);
        ll.addLast(40);
        System.out.println(ll.size());
       System.out.println(ll.getAt(2));
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
    }
}

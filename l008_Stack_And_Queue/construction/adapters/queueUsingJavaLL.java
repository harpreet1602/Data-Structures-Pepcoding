import java.util.LinkedList;
public class queueUsingJavaLL {
  public static class queue{
    private LinkedList<Integer> ll=new LinkedList<>();
    public int size(){
        return ll.size();
    }
    public boolean isEmpty(){
        return ll.size()==0;
    }
    public void add(int data)
    {
        ll.addLast(data);
    }
    public int remove()
    {
        return ll.removeFirst();
    }
    public int peek(){
        return ll.getFirst();
    }
  }  
  public static void main(String[] args)
  {
    queue que=new queue();
    que.add(10);
    que.add(20);
    que.add(30);
    System.out.println(que);
    while(!que.isEmpty())
    {
        System.out.println(que.remove());    
    }
  }
}

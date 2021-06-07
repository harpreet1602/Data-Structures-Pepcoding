import java.util.LinkedList;
public class stackUsingJavaLL {
public static class stack{
    private LinkedList<Integer> ll=new LinkedList<>();
    public int size(){
        return ll.size();
    }
    public boolean isEmpty(){
        return ll.size()==0;
    }
    public void push(int data)
    {
        ll.addFirst(data);
    }
    public int pop(){
      return ll.removeLast();
    }
    public int top(){
        return ll.getLast();
    }
}   
public static void main(String[] args)
{
    stack s1=new stack();
    s1.push(10);
    s1.push(20);
    s1.push(30);
    // s1.push(40);
    System.out.println(s1);
    while(!s1.isEmpty()){
        System.out.println(s1.pop());
    }
    //System.out.println(s1.top());
} 
}
